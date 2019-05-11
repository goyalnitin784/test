package com.phantom.cache.service;


import com.phantom.cache.client.CacheClient;

public class CacheHandler extends CacheClient {

    private CacheClient cacheClient;

    @Override
    public String getString(String key) {
        return cacheClient.getString(key);
    }

    @Override
    public Object get(String key) {
        return cacheClient.get(key);
    }

    @Override
    public void set(String key, Object obj) {
        cacheClient.set(key, obj);
    }

    @Override
    public void set(String key, int expiry, Object obj) {
        cacheClient.set(key, expiry, obj);
    }

    public CacheClient getCacheClient() {
        return cacheClient;
    }

    public void setCacheClient(CacheClient cacheClient) {
        this.cacheClient = cacheClient;
    }
}
