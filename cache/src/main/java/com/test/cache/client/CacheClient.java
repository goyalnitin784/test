package com.phantom.cache.client;

import org.springframework.util.StringUtils;

public abstract class CacheClient {

    protected int defaultExpiryTime = 600;

    public String getString(String key) {
        Object object = get(key);
        if (object instanceof String && !StringUtils.isEmpty(object)) {
            return (String) object;
        } else {
            return null;
        }
    }

    public abstract Object get(String key);


    public void set(String key, Object obj) {
        set(key, defaultExpiryTime, obj);
    }

    public abstract void set(String key, int expiry, Object o);

}
