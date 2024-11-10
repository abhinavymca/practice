package com.practice.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PatternMatching {
    public static void main(String[] args) {
        String string = "AMAZING";
        String pattern = "010";

        List<Character> chars = new ArrayList<>(Arrays.asList('A', 'E', 'I', 'O', 'U'));
        if (pattern.length() > string.length()) {
            return;
        }
        int pointer1 = 0;
        int pointer2 = pattern.length() - 1;
        int count = 0;
        while (pointer1 < string.length()-pattern.length()) {
            boolean flag = true;
            String subString = string.substring(pointer1, pointer1+pattern.length());
            for (int i = 0; i < pattern.length(); i++) {
                char ch = subString.charAt(i);
                char p = pattern.charAt(i);
                if (p == '0' && !chars.contains(ch)) {
                    flag = false;
                    break;
                }
                if (p == '1' && chars.contains(ch)) {
                    flag = false;
                    break;
                }
            }
            pointer1++;
            if (flag) {
                count++;
            }

        }
        System.out.println(count);
    }
}
