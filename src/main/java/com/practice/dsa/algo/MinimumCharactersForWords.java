package com.practice.dsa.algo;

import java.util.*;

public class MinimumCharactersForWords {

    PriorityQueue<Integer> pq = new PriorityQueue<>(Integer::compareTo);
    public static void main(String[] words) {
        
        words = new String[]{"this", "that", "did", "deed", "them!", "a"};
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<words.length;i++){
            Map<Character,Integer> subMap = new HashMap<>();
            for(int j=0;j<words[i].length();j++){
                char ch = words[i].charAt(j);
                subMap.put(ch, subMap.getOrDefault(ch, 0)+1);
            }
            System.out.println(subMap);
            for(Map.Entry<Character,Integer> sub : subMap.entrySet()){
                if(map.containsKey(sub.getKey())) {
                    map.put(sub.getKey(), Math.max(map.get(sub.getKey()),sub.getValue()));

                }
                else
                    map.put(sub.getKey(), sub.getValue());
            }
        }
        List<Character> str = new ArrayList<>();
        for(Map.Entry<Character,Integer> m : map.entrySet()){
            for(int i=0;i<m.getValue();i++){
                str.add(m.getKey());
            }
        }
        System.out.println(map);
        char[] chars = new char[str.size()];
        for(int i=0;i<str.size();i++){
            chars[i] = str.get(i);
        }
        Arrays.asList(chars).stream().forEach(System.out::println);
    }
}
