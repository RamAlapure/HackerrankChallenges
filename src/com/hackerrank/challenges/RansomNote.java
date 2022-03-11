package com.hackerrank.challenges;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

public class RansomNote {

    public static final Logger log = Logger.getLogger(RansomNote.class.getName());

    private RansomNote() {
    }

    /*
     * Complete the 'checkMagazine' function below.
     *
     * The function accepts following parameters:
     *  1. STRING_ARRAY magazine
     *  2. STRING_ARRAY note
     */
    public static void checkMagazine(List<String> magazine, List<String> note) {
        Map<String, Integer> magazineMap = new HashMap<>();
        Map<String, Integer> noteMap = new ConcurrentHashMap<>();

        magazine.forEach(str -> magazineMap.put(str, magazineMap.getOrDefault(str, 0) + 1));
        note.forEach(str -> noteMap.put(str, noteMap.getOrDefault(str, 0) + 1));
        final boolean[] match = {false};
        for (Entry<String, Integer> entry : noteMap.entrySet()) {
            if (magazineMap.containsKey(entry.getKey())) {
                Integer noteCount = entry.getValue();
                Integer magazineCount = magazineMap.get(entry.getKey());
                if (noteCount > magazineCount) {
                    match[0] = false;
                    break;
                } else {
                    noteMap.remove(entry.getKey());
                    magazineMap.remove(entry.getKey());
                    match[0] = true;
                }
            } else {
                match[0] = false;
                break;
            }
        }
        log.info(match[0] ? "Yes" : "No");
    }

}