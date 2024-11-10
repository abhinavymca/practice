package com.practice.dsa.leetcode;

import java.util.List;

public class TriangleMinimum {

    public int minimumTotal(List<List<Integer>> triangle) {
        int sum=0;
        for(List<Integer> list : triangle){
            sum+=list.stream().min(Integer::compareTo).get().intValue();
        }
        return sum;
    }
}
