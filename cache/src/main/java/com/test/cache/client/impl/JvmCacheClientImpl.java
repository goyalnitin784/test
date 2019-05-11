package com.phantom.cache.client.impl;

import com.phantom.cache.client.CacheClient;
import org.apache.commons.collections.map.LRUMap;

public class JVMCacheClientImpl extends CacheClient {
    private final LRUMap lruMap = new LRUMap(2500);

    @Override
    public Object get(String key) {
        synchronized (lruMap) {
            return lruMap.get(key);
        }
    }

    @Override
    public void set(String key, int expiry, Object o) {
        synchronized (lruMap){
            lruMap.put(key, o);
        }
    }
}
