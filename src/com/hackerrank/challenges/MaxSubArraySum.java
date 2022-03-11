package com.hackerrank.challenges;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Logger;

class Solution {

    public static final Logger log = Logger.getLogger(Solution.class.getName());

    private Solution() {
    }

    /*
     * Complete the 'maximumSum' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. LONG_INTEGER_ARRAY a
     *  2. LONG_INTEGER m
     *
     * 1234
     * 1234
     * 234
     * 34
     * 5
     *
     */

    public static long maximumSum1(List<Long> a, long m) {
        long max = 0;
        int limit = (int) Math.pow(2, a.size());
        for (int i = 1; i < limit; i++) {
            int temp = i;
            long sum = 0;
            String set = "";
            for (int j = a.size() - 1; j >= 0; j--) {
                int r = temp % 2;
                temp /= 2;
                if (r != 0) {
                    set = a.get(j) + " \t" + set;
                    sum = a.get(j) + sum;
                }
            }
            long diff = sum % m;
            if (diff > max) max = diff;
            log.info(set + "\n" + sum + "\t" + diff);
        }
        return max;
    }

    public static long maximumSum(List<Long> a) {
        long overallSum = a.get(0);
        long currentSum = a.get(0);
        for (int i = 1; i < a.size(); i++) {
            if (currentSum >= 0) currentSum += a.get(i);
            else currentSum = a.get(i);
            if (currentSum > overallSum) overallSum = currentSum;
        }
        return overallSum;
    }

    public static long maximumSumModulo(List<Long> a, int m) {
        long overallSum = a.get(0);
        long currentSum = a.get(0);
        Set<Long> set = new TreeSet<>();
        for (int i = 1; i < a.size(); i++) {
            if (currentSum >= 0) {
                currentSum = (currentSum + a.get(i)) % m;
            } else currentSum = a.get(i) % m;
            set.add(currentSum);
            if (currentSum > overallSum) overallSum = currentSum;
        }
        return overallSum;
    }

    static long maximumSum(List<Long> a, long m) {
        TreeSet<Long> prefix = new TreeSet<>();
        long maxSum = 0;
        long currSum = 0;
        for (int i = 0; i < a.size(); i++) {
            currSum = (currSum + a.get(i) % m) % m;
            maxSum = Math.max(maxSum, currSum);
            Long pr = prefix.higher(currSum);
            if (pr != null) {
                maxSum = Math.max(maxSum, (currSum - pr + m) % m);
            }
            prefix.add(currSum);
        }
        return maxSum;
    }

    public static void findSubSets(List<Long> a) {
        int limit = (int) Math.pow(2, a.size());
        for (int i = 1; i < limit; i++) {
            int temp = i;
            String set = "";
            for (int j = a.size() - 1; j >= 0; j--) {
                int r = temp % 2;
                temp /= 2;
                if (r == 0) set = "-\t" + set;
                else {
                    set = a.get(j) + "\t" + set;
                }
            }
            log.info(set);
        }
    }

}

public class MaxSubArraySum {

    public static void main(String[] args) {
        List<Long> a = new ArrayList<>();
        a.add(3L);
        a.add(3L);
        a.add(9L);
        a.add(9L);
        a.add(5L);
        Solution.maximumSum(a, 7);
    }

}
