package com.phantom.util;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Component
public class RequestUtils {

    public static boolean itIsAJSONRequest(Map<String, Object> searchCriteria) {
        return itIsAJSONRequest(searchCriteria.get("JSON"));
    }

    public static boolean itIsAJSONRequest(Object obj) {
        return obj != null && obj.toString().equalsIgnoreCase("JSON");
    }

    public static String getCookie(HttpServletRequest request, String key) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals(key)) {
                    return cookies[i].getValue();
                }
            }
        }
        return null;
    }

    public static Map<String, String> toMap(String queryString) {
        Map<String, String> map = new HashMap<>();
        if (!StringUtils.isEmpty(queryString)) {
            String[] nameValues = queryString.split("\\&");
            for (String nameValue : nameValues) {
                String keyValues[] = nameValue.split("=");
                if (keyValues.length >= 2) {
                    map.put(keyValues[0], keyValues[1]);
                }
            }
        }
        return map;
    }

    public static Map<String, String> getParamaters(HttpServletRequest request) {
        Map<String, String> requestParameters = new HashMap<String, String>();
        Enumeration<?> e = request.getParameterNames();
        while (e.hasMoreElements()) {
            String fieldName = (String) e.nextElement();
            String fieldValue = request.getParameter(fieldName);
            Object[] fieldValues = request.getParameterValues(fieldName);
            if (fieldValues.length > 1) {
                for (Integer iter = 0; iter < fieldValues.length; iter++) {
                    requestParameters.put(fieldName + "_" + iter, (String) fieldValues[iter]);
                }
            } else {
                requestParameters.put(fieldName, fieldValue);
            }
        }

        return requestParameters;
    }

    public static String getClientAddress(HttpServletRequest request) {

        String clientAddress = !StringUtils.isEmpty(request.getHeader("client-ip-address"))
                ? request.getRemoteAddr()
                : request.getHeader("client-ip-address");

        String ipAddressListWithProxies = request.getHeader("X-FORWARDED-FOR");
        if (ipAddressListWithProxies != null) {
            clientAddress = ipAddressListWithProxies;
            int idx = clientAddress.indexOf(',');
            if (idx > -1) {
                clientAddress = clientAddress.substring(0, idx);
            }
        }
        return clientAddress;
    }

    public static String getHostIPAddress(HttpServletRequest request) {
        return request.getLocalAddr();
    }

    @SuppressWarnings("unchecked")
    public static Map<String, String> getHeaders(HttpServletRequest request) {

        Map<String, String> map = new HashMap<>();

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }

        return map;
    }

    public static Map<String, String> getHeaders(HttpServletRequest request, boolean acceptEncoding) {

        Map<String, String> map = getHeaders(request);
        if (!acceptEncoding) {
            map.remove("accept-encoding");
        }

        return map;
    }

    public String getParameterFromUrlEncodedUrl(String encodedUrl,
                                                String parameter) {
        try {
            String decodedUrl = URLDecoder.decode(encodedUrl, "UTF-8");
            URL url = new URL(decodedUrl);
            String query = url.getQuery();
            String queryParts[] = query.split("&");
            for (String part : queryParts) {
                String expression[] = part.split("=");
                if (expression[0].equalsIgnoreCase(parameter)) {
                    return expression[1];
                }
            }

        } catch (UnsupportedEncodingException | MalformedURLException e) {

        }
        return encodedUrl;
    }

    public String getCookieValue(HttpServletRequest request, String key) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals(key)) {
                    return cookies[i].getValue();
                }
            }
        }
        return null;
    }

    public void addCookie(HttpServletResponse response, String name,
                          String value) {
        Cookie cookie = new Cookie(name, value);
        // cookie.setMaxAge(propertyManager.getPropertyAsInt(AppProperties.SESSION_COOKIE_AGE));
        cookie.setPath("/");
        response.addCookie(cookie);
    }

}
