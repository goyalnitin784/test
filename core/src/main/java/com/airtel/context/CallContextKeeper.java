package com.airtel.context;

import com.airtel.request.MapBasedRequest;

public class CallContextKeeper {

    private static final ThreadLocal<MapBasedRequest> threadLocal = new ThreadLocal<>();

    public static MapBasedRequest getCallContext() {
        return threadLocal.get();
    }

    public static void setCallContext(MapBasedRequest callContext) {
        threadLocal.set(callContext);
    }

}