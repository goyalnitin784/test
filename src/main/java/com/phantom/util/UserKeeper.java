package com.phantom.util;

import com.phantom.model.entity.User;


public class UserKeeper {
    private static final ThreadLocal<User> threadLocal = new ThreadLocal<>();

    public static User getUserDetails() {
        return threadLocal.get();
    }


    public static void setUserDetails(User tenant) {
        threadLocal.set(tenant);
    }

    public static void removeUserDetails() {
        threadLocal.remove();
    }


}
