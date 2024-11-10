package com.practice.dsa;

import java.util.ArrayList;
import java.util.List;

public class ClosestProductPair {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int k = 56;
        int[] pair = nearestProduct1(arr, k);
        System.out.println(pair[0] + "," + pair[1]);
    }

    private static int[] nearestProduct1(int[] arr, int k) {
        int i=0, j= arr.length-1;
        int[] pair = new int[2];
        int diff = Integer.MAX_VALUE;
        while(i<j){
            if(Math.abs(arr[i]*arr[j] - k) < diff){
                pair[0]=arr[i];
                pair[1]=arr[j];
                diff = Math.abs(arr[i]*arr[j] - k);
            }
            if(arr[i]*arr[j] <= k)
                i++;
            if(arr[i]*arr[j] >= k)
                j--;
        }
        return pair;
    }


    private static int[] nearestProduct(int[] arr, int product) {
        int l = 0, r = arr.length - 1;
        int[] pair = {arr[l], arr[r]};
        int diff = Integer.MAX_VALUE;
        while (l < r) {
            int current = Math.abs(arr[l] * arr[r] - product);
//            int existing = Math.abs(pair[0]*pair[1] - product);
            if (current < diff) {
                pair[0] = arr[l];
                pair[1] = arr[r];
                diff = current;
            }
            if (arr[l] * arr[r] <= product)
                l++;
            else
                r--;
        }
        return pair;
    }
}
