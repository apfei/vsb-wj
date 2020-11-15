package com.example.anpf.testserver.utils;

import java.util.Random;

/**
 * @Author: anpf
 * @Date: 2020/8/23 17:55
 */
public class StringUtils {
    public static String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random rand = new Random();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i<length; i++){
            int number = rand.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
