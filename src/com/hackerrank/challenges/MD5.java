package com.hackerrank.challenges;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.logging.Logger;

public class MD5 {

    public static final Logger log = Logger.getLogger(MD5.class.getName());

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] array = md.digest(next.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : array) sb.append(Integer.toHexString((b & 0xFF) | 0x100), 1, 3);
        log.info(sb.toString());
    }
}
