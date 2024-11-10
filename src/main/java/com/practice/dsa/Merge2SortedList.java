package com.practice.dsa;

import java.util.Arrays;

public class Merge2SortedList {

    public static void main(String[] args) {
        int[] array1 = new int[] {1,3,5,7};
        int[] array2 = new int[] {2};
        merge(array2,array1);
    }

    public static int[] merge(int[] array1, int[] array2){
        int i=0,j=0, k=0;
        int[] fArray = new int[array1.length+array2.length];
        while(i<array1.length && j<array2.length){
            if(array1[i]<array2[j]){
                fArray[k++]=array1[i++];
            }else{
                fArray[k++]=array2[j++];
            }
        }
        while(i<array1.length){
            fArray[k++]=array1[i++];
        }
        while(j<array2.length){
            fArray[k++]=array2[j++];
        }
        Arrays.stream(fArray).forEach(System.out::println);
        return fArray;
    }
}
