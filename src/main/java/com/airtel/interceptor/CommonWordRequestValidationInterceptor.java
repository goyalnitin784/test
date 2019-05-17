package com.airtel.interceptor;

import com.airtel.context.CallContextKeeper;
import com.airtel.logging.MyLogger;
import com.airtel.request.CommonWordRequest;
import com.airtel.request.MapBasedRequest;
import com.airtel.util.Constants;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class CommonWordRequestValidationInterceptor extends HandlerInterceptorAdapter {
    static MyLogger logger = MyLogger.getLoggerObject(CommonWordRequestValidationInterceptor.class);

    public CommonWordRequestValidationInterceptor() {
        super();
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        CommonWordRequest commonWordRequest = new CommonWordRequest(request);
        if (commonWordRequest.isInvalidRequest()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return false;
        }
        if (commonWordRequest.getFilesPaths().size() < Constants.MIN_NUMBER_OF_FILES) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return false;
        } else {
            BufferedReader reader = null;
            int minimumLength = Integer.MAX_VALUE;
            for (String filePath : commonWordRequest.getFilesPaths()) {
                try {
                    File file = new File(filePath);
                    if (!file.exists()) {
                        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                        return false;
                    }
                    commonWordRequest.getFileList().add(file);
                    reader = new BufferedReader(new FileReader(filePath));
                    int ch;
                    char charToSearch = ' ';
                    int counter = 0;
                    while ((ch = reader.read()) != -1) {
                        if (charToSearch == (char) ch) {
                            counter++;
                        }
                    }
                    if (counter < Constants.MIN_WORDS) {
                        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                        return false;
                    }
                    if (counter < minimumLength) {
                        minimumLength = counter;
                        commonWordRequest.setMinimumWordFile(file);
                    }
                } catch (Exception e) {
                    logger.error("Exception came while file parsing for file : ", e);
                } finally {
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (Exception e) {
                            logger.error("Exception came while file parsing for file : ", e);
                        }
                    }
                }
            }
        }
        CallContextKeeper.setCallContext(commonWordRequest);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView model) throws Exception {
        CallContextKeeper.setCallContext(null);
    }
}