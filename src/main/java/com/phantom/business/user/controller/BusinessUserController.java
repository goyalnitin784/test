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
import com.phantom.model.entity.Strain;
import com.phantom.response.GenericResponse;
import com.phantom.util.PhantomUtil;
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

    @RequestMapping(value = "getDispensaryDetails", method = RequestMethod.GET)
    public @ResponseBody
    String getBusinessUserDetails(HttpServletRequest request) {
        String ssoToken = requestUtils.getCookieValue(request, "bssoToken");
        return businessUserService.getBusinessUserDetailsAsJson(ssoToken);
    }

    @RequestMapping(value = "loginDispensary", method = RequestMethod.POST)
    public @ResponseBody
    String doLogin(HttpServletRequest request, HttpServletResponse response) {
        String msg = "SUCCESS";
        String code = "200";

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String agreeTotermnServices = request.getParameter("agreeTotermnServices");

        if (PhantomUtil.isNullOrEmpty(agreeTotermnServices) || agreeTotermnServices.equalsIgnoreCase("false")) {
            code = "400";
            msg = "NOT AGGREED TO TERMS AND SERVICES";
        }

        BusinessUser businessUser = businessUserService.isValidUser(userName, password);
        if (businessUser != null) {
            String ssoToken = UUID.randomUUID().toString();
            businessUserService.setCookie(response, userName, ssoToken);
            businessUserService.setSSOToken(businessUser.getBusinessUserId(), businessUser.getUserName(), ssoToken);
        } else {
            code = "500";
            msg = "FAILED";
        }

        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.addMessage(msg);
        baseResponseDTO.setCode(code);
        return gson.toJson(baseResponseDTO);
    }

    @RequestMapping(value = "logoutDispensary", method = RequestMethod.GET)
    public @ResponseBody
    String logout(HttpServletRequest request) {
        String ssoToken = requestUtils.getCookieValue(request, "bssoToken");
        return businessUserService.logout(ssoToken);
    }

    

}
