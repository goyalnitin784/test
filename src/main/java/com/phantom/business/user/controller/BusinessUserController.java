package com.phantom.business.user.controller;

import com.google.gson.Gson;
import com.phantom.business.user.request.BusinessUserBean;
import com.phantom.business.user.service.BusinessUserService;
import com.phantom.dto.BaseResponseDTO;
import com.phantom.logging.PhantomLogger;
import com.phantom.model.dao.BusinessUserDao;
import com.phantom.model.dao.BusinessUserSSOTokenMappingDao;
import com.phantom.model.entity.BusinessUser;
import com.phantom.model.entity.BusinessUserSSOTokenMapping;
import com.phantom.response.GenericResponse;
import com.phantom.util.RequestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@RestController
@RequestMapping(value = "businessUser")
public class BusinessUserController {
    private static final Gson gson = new Gson();
    private static final PhantomLogger logger = PhantomLogger.getLoggerObject(BusinessUserController.class);

    @Autowired
    private BusinessUserService businessUserService;
    @Autowired
    private BusinessUserDao businessUserDao;
    @Autowired
    private RequestUtils requestUtils;
    @Autowired
    private BusinessUserSSOTokenMappingDao businessUserSSOTokenMappingDao;

    @RequestMapping(value = "registerDispensary", method = RequestMethod.POST)
    public @ResponseBody
    String registerUser(HttpServletRequest request, HttpServletResponse response) {
        BusinessUserBean businessUserBean = new BusinessUserBean(request);
        businessUserService.setCookie(response, businessUserBean.getUserName(), businessUserBean.getSsoToken());
        return businessUserService.insertUserDetails(businessUserBean);
    }

    @RequestMapping(value = "getUserDetails", method = RequestMethod.GET)
    public @ResponseBody
    String getBusinessUserDetails(HttpServletRequest request) {
        String ssoToken = requestUtils.getCookieValue(request, "bssoToken");
        return businessUserService.getBusinessUserDetailsAsJson(ssoToken);
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public @ResponseBody
    String doLogin(HttpServletRequest request, HttpServletResponse response) {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        BusinessUser businessUser = businessUserService.isValidUser(userName, password);
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        if (businessUser != null) {
            String ssoToken = UUID.randomUUID().toString();
            businessUserService.setCookie(response, userName, ssoToken);
            businessUserService.setSSOToken(businessUser.getBusinessUserId(), businessUser.getUserName(), ssoToken);
            baseResponseDTO.setCode("200");
            baseResponseDTO.addMessage("SUCCESS");
        } else {
            baseResponseDTO.setCode("500");
            baseResponseDTO.addMessage("FAILED");
        }
        return gson.toJson(baseResponseDTO);
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public @ResponseBody
    String logout(HttpServletRequest request) {
        String ssoToken = requestUtils.getCookieValue(request, "bssoToken");
        return businessUserService.logout(ssoToken);
    }

}
