package com.practice.dsa.algo;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutDuplication {
    public static void main(String[] args) {
        String str = "clementisacap";
        Set<Character> chars = new HashSet<>();
        int start = 0;
        String s = "";
        int max = Integer.MIN_VALUE;
        for(int i=0;i<str.length();i++){
            if(!chars.contains(str.charAt(i))) {
                chars.add((str.charAt(i)));
                if (max < i - start + 1) {
                    max = i - start + 1;
                    s = str.substring(start, i);
                }
            } else {
                while(chars.contains(str.charAt(i))){
                    chars.remove(str.charAt(start++));
                }
                chars.add((str.charAt(i)));
            }

        }
        System.out.println(s);
    }
}
