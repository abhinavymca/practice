package com.practice.dsa.algo;

import java.util.*;

public class CommonChars {
    public static void main(String[] args) {
        String[] strings = new String[]{"abc", "bcd", "cbad"};
        Map<Character, Integer> common = new HashMap<>();
        for(String s: strings){
            Set<Character>  charSet = new HashSet<>();
            for(int i=0;i<s.length();i++){
                charSet.add(s.charAt(i));
            }
            for (Character ch : charSet){
                common.put(ch, common.getOrDefault(ch,0)+1);
            }
        }
        List<Character> list = new ArrayList<>();
        for(Map.Entry<Character, Integer> entry: common.entrySet()){
            if(entry.getValue() == strings.length)
                list.add(entry.getKey());
        }
        String[] fList = new String[list.size()];
        int k=0;
        for(Character ch: list)
            fList[k++]=ch.toString();
        System.out.println(list);
    }
    static void sol1(){
        String[] strings = new String[]{"abc", "bcd", "cbad"};
        Map<String, Integer> map = new HashMap<>();
        String min = strings[0];
        for(String s: strings){
            if(min.length()>s.length())
                min=s;
        }
        for(char s: min.toCharArray()){
            map.put(s+"",0);
        }

        for(String s: strings){
            for(Map.Entry<String, Integer> entry: map.entrySet()){
                if(s.contains(entry.getKey()))
                    entry.setValue(entry.getValue()+1);
            }
        }
        List<String> list = new ArrayList<>();
        for(Map.Entry<String, Integer> entry: map.entrySet()){
            if(entry.getValue() == strings.length)
                list.add(entry.getKey());
        }

        System.out.println(list.toArray(new String[0]));
    }
}
