package com.practice.dsa.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {4,6,1,6,9,2,5,8,4,2,7,6};

        for(int i=0;i<arr.length-1;i++){
            boolean swapped = false;
            for(int j=0;j< arr.length-i-1; j++){
                if(arr[j]>arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    swapped = true;
                }
            }
            if(!swapped) break;
        }
        System.out.println(Arrays.toString(arr));
    }
}
