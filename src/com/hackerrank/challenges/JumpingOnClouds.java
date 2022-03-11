package com.hackerrank.challenges;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class JumpingOnClouds {

    public static final Logger log = Logger.getLogger(JumpingOnClouds.class.getName());

    public static void main(String[] args) {
        int[] ints = new int[]{0, 0, 0, 1, 0, 0};
        List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());
        log.info(String.valueOf(jumpingOnClouds(list)));
    }

    public static int jumpingOnClouds(List<Integer> c) {
        int jumps = 0;
        int i = 0;
        while (i < c.size() - 1) {
            if (c.get(i) == 0) i++;
            jumps++;
            i++;
        }
        return jumps;
    }
}
