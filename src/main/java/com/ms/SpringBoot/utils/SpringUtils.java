package com.ms.SpringBoot.utils;

public final class SpringUtils {
    private SpringUtils() {}
    public static boolean isEmpty(String value) {
        return value == null || value.isEmpty();
    }
}
