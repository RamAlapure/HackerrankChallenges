package com.hackerrank.DataStructures;

import java.util.ArrayList;
import java.util.List;

public class SparseArray {

    /*
     * Complete the 'matchingStrings' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY strings
     *  2. STRING_ARRAY queries
     */

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        List<Integer> list = new ArrayList<>();
        queries.forEach(query -> {
            int[] count = new int[]{0};
            strings.stream().filter(query::equals).forEach(str -> count[0]++);
            list.add(count[0]);
        });
        return list;
    }

}
