package com.practice.dsa.algo;

public class ReverseWords {

    public static String reverseWordsInString(String string) {
        // Write your code here.
        StringBuilder sb = new StringBuilder();

        int start = 0;

        if(string.isEmpty()) return "";
        for(int i=0; i<string.length();i++){
            char ch = string.charAt(i);
            if(ch == ' '){
                sb.insert(0, string.substring(start, i));
                start = i;
            } else if(string.charAt(start) == ' '){
                sb.insert(0, " ");
                start = i;
            }
        }
        sb.insert(0, string.substring(start));
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWordsInString("test        "));
    }
}
