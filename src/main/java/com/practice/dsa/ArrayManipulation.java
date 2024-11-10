package com.practice.dsa;

import java.util.Arrays;

public class ArrayManipulation {
    public static void main(String[] args) {
        int arr[] =new int[]{4, 0, 1, -2, 3};
        int brr[] = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            brr[i] = arr[i];
            if(i>0)
                brr[i] += arr[i-1];
            if(i < arr.length-1)
                brr[i] += arr[i+1];
        }
        System.out.println(Arrays.toString(brr));
    }
}
