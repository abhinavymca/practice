package com.practice.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionArray {

    public static void main(String[] args) {
        partitionArray(new int[]{1,2,3,4,5,6,7,8,9,10},3);
    }

    static List<int[]> partitionArray(int[] array, int size){
        int count = array.length/size;
        int remaining = array.length%size;
        int start = 0;
        List<int[]> fList = new ArrayList<>();
        for(int i=0;i<size;i++){
            int end = start+count + (i<remaining?1:0);
            int[] batch = Arrays.copyOfRange(array, start, end);
            fList.add(batch);
            start = end;
            Arrays.stream(batch).forEach(j->System.out.print(j+","));
            System.out.println();
        }
        return fList;
    }
}
