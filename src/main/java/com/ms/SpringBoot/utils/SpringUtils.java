package com.ms.SpringBoot.utils;

public class SpringUtils {

    public static boolean isEmpty(String pStr) {
        if (pStr.equals("") || pStr.equals(null)) {
            return true;
        } else {
            return false;
        }
    }
}
