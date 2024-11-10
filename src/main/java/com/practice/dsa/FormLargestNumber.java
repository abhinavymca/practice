package com.practice.dsa;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class FormLargestNumber {
    public static void main(String[] args) {
        int[] arr = {10,68, 75, 7, 21, 2};
        String[] strArr = new String[arr.length];
        for(int i=0;i<arr.length;i++){
            strArr[i] = String.valueOf(arr[i]);
        }
        System.out.println("775".compareTo("757"));
        Comparator<String> cmp = (a,b) -> (a+b).compareTo(b+a);
        Arrays.sort(strArr, cmp.reversed());
        String str = String.join("", strArr);
        System.out.println(str);
    }
}
