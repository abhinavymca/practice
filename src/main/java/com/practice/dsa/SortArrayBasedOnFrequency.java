package com.practice.dsa;

import java.util.*;
import java.util.stream.Collectors;

public class SortArrayBasedOnFrequency {
    public static void main(String[] args) {
        int[] arr = {3, 3, 1, 1, 1, 8, 3, 6, 8, 7, 8};
        int[] out = new int[arr.length];
        int k = 0;
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> index = new HashMap<>();
        for (int i=0;i< arr.length;i++) {
            if (!index.containsKey(arr[i])) {
                index.put(arr[i], i);
            }
            count.put(arr[i], count.getOrDefault(arr[i], 0) + 1);
        }

        List<Integer> integers = new ArrayList<>(Arrays.stream(arr).boxed().toList());
        Comparator<Integer> cmp = (a,b) -> {
            int aCount =  count.get(a);
            int bCount =  count.get(b);
            if(aCount!=bCount)
                return bCount-aCount;
            else {
                int aIdx = index.get(a);
                int bIdx = index.get(b);
                return aIdx-bIdx;
            }
        };
        integers.sort(cmp);

        System.out.println(integers);
    }


}
