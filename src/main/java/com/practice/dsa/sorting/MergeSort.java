package com.practice.dsa.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {4,6,1,6,9,2,5,8,4,2,7,6};
        System.out.println(Arrays.toString(mergeSort(arr)));
    }

    private static int[] mergeSort(int[] arr) {
        if(arr.length<=1) return arr;
        int mid = arr.length/2;
        int[] left = Arrays.copyOfRange(arr,0, mid);
        int[] right = Arrays.copyOfRange(arr,mid, arr.length);
        return merge(mergeSort(left),mergeSort(right));
    }

    private static int[] merge(int[] left, int[] right) {
        int i=0,j=0,k=0;
        int[] out = new int[left.length+right.length];
        while(i<left.length && j<right.length){
            if(left[i]<right[j]){
                out[k++]=left[i++];
            } else{
                out[k++]=right[j++];
            }
        }
        while(i<left.length){
            out[k++]=left[i++];
        }
        while(j<right.length){
            out[k++]=right[j++];
        }
        return out;
    }
}
