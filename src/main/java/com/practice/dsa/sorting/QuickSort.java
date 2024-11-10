package com.practice.dsa.sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {4,6,1,6,9,2,5,8,4,2,7,6};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int left, int right) {
        if(left<right) {
            int j = partition(arr, left, right);
            System.out.println("j:"+j);
            quickSort(arr, left, j - 1);
            quickSort(arr, j + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        System.out.println(left+":"+right);
        int pivot = arr[left];
        int i=left+1, j=right;
        while(i<=j){
            while(i<=right && arr[i]<=pivot)
                i++;
            while(j>=left && arr[j]>pivot)
                j--;
            if(i<j){
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        int tmp = arr[left];
        arr[left] = arr[j];
        arr[j] = tmp;
        System.out.println(pivot+":"+Arrays.toString(Arrays.copyOfRange(arr,left, right)));
        return j;
    }


}
