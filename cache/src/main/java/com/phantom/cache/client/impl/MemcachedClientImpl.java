package com.phantom.cache.client.impl;

import com.phantom.cache.client.CacheClient;
import net.spy.memcached.MemcachedClient;

public class MemcachedClientImpl extends CacheClient {

    private MemcachedClient memcachedClient;

    public MemcachedClientImpl(MemcachedClient memcachedClient, int defaultExpiryTime)
    {
        this.memcachedClient = memcachedClient;
        super.defaultExpiryTime = defaultExpiryTime;
    }

    @Override
    public Object get(String key) {
        return memcachedClient.get(key);
    }

    public void set(String key, int expiry, Object obj) {
        memcachedClient.set(key, expiry, obj);
    }


}
