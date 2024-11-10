package com.practice.dsa.algo;

import java.util.*;

public class GroupAnagram {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("ana", "bna", "naa", "mbna");
        Map<String, List<String>> map = new HashMap<>();
        words.forEach(w -> {
            char[] array = w.toCharArray();
            Arrays.sort(array);
            String sortedWord = new String(array);
            if(map.containsKey(sortedWord)){
                map.get(sortedWord).add(w);
            } else{
                map.put(sortedWord, Arrays.asList(w));
            }
        });

        System.out.println(map.values());
    }
}
