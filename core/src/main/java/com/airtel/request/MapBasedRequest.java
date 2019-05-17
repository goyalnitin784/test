package com.airtel.request;


import com.airtel.logging.MyLogger;
import com.airtel.util.RequestUtils;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public abstract class MapBasedRequest implements Serializable {


    static MyLogger myLogger = MyLogger.getLoggerObject(MapBasedRequest.class);
    private static final long serialVersionUID = -327986489173488918L;
    protected Map<String, String> requestParameters;
    protected String requestBody;

    public MapBasedRequest(Map<String, String> parameterMap) {
        requestParameters = new HashMap<String, String>(parameterMap);
    }

    public MapBasedRequest(String requestBody) {
        this.requestBody = requestBody;
    }

    public MapBasedRequest() {
        requestParameters = new HashMap<String, String>();
    }

    public MapBasedRequest(HttpServletRequest httpRequest) {
        requestParameters = RequestUtils.getParamaters(httpRequest);
        try {
            requestBody = IOUtils.toString(httpRequest.getReader());
        } catch (IOException e) {
            myLogger.error("Exception came while parsing request ", e);
        }
    }

    public String getParameter(String key) {
        return requestParameters.get(key);
    }

    public Map<String, String> getParameterMap() {
        return requestParameters;
    }

    @Override
    public String toString() {
        return requestParameters.toString();
    }

    protected String getParameter(String key, String defaultValue) {
        String str = getParameter(key);
        return str == null ? defaultValue : str;
    }

}
