package com.practice.dsa;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NonRepeatedString {
    public static void main(String[] args) {
        String str = "asdfghjklasdfghjklzxcvbnm";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            map.put(ch, map.containsKey(ch) ? map.get(ch) + 1 : 1);
        }
        String s = map.entrySet().stream().filter((m)->m.getValue()==1).map(Map.Entry::getKey).collect(Collectors.toList())
                .stream().map(String::valueOf).collect(Collectors.joining());
        System.out.println(s);

        int[] arr = new int[256];
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i)]++;
        }
        boolean[] print = new boolean[256];
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==1)
                stringBuilder.append((char)i);
        }
        System.out.println(stringBuilder);
        stringBuilder.delete(0, stringBuilder.length());
        for (int i = 0; i < str.length(); i++) {
            if(arr[str.charAt(i)]==1 && !print[str.charAt(i)]){
                stringBuilder.append(str.charAt(i));
                print[str.charAt(i)] = true;
            }
        }
        System.out.println(stringBuilder);

        test( Integer.valueOf(1));

        String strr= "Raju Raaj Rangu";

        Map<String,Long> mapss = Arrays.stream(strr.trim().split(" ")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        String res = mapss.entrySet().stream().filter(m -> m.getValue()==1).map(Map.Entry::getKey).map(String::valueOf).sorted().collect(Collectors.joining(" "));
        System.out.println(mapss);
        System.out.println(res);

        TreeSet<String> set = new TreeSet<>(Arrays.asList(strr.trim().split(" ")));
        System.out.println(set);

    }

    public static void test (Object s){
        System.out.println("object");
    }
    public static void test (String s){
        System.out.println("string");
    }


}
