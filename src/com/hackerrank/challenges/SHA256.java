package com.hackerrank.challenges;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256 {

    private SHA256() {
    }

    private static String encrypt(String str) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] array = md.digest(str.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < array.length; ++i) {
            sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100), 1, 3);
        }
        return sb.toString();
    }
}
