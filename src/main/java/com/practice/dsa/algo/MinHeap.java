package com.practice.dsa.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinHeap {
    public static void main(String[] args) {

        List<Integer> array = Arrays.asList(-7, 2, 3, 8, -10, 4, -6, -10, -2, -7, 10, 5, 2, 9, -9, -5, 3, 8);
        Min min = new Min(array);
        List<Integer> result = Arrays.asList(-5, 2, 6, 24, 8, 7, 24, 391, 48, 56, 12, 24, 8, 41, 76);
        min.remove();
        min.insert(-8);
        min.remove();
        System.out.println(min.heap);



    }

    static class Min {
        List<Integer> heap = new ArrayList<Integer>();

        public Min(List<Integer> array) {
            heap = buildHeap(array);
        }

        public List<Integer> buildHeap(List<Integer> array) {
            // Write your code here.
            for(Integer i: array)
                insert(i);
            return heap;
        }

        public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
            // Write your code here.
            int childOneIdx = 2 * currentIdx + 1;
            while(childOneIdx<=endIdx){
                int childTwoIdx = (2 * currentIdx + 2) <= endIdx ? 2 * currentIdx + 2 : -1;
                int idxToSwap;
                if(childTwoIdx != -1 && heap.get(childTwoIdx)<heap.get(childOneIdx))
                    idxToSwap = childTwoIdx;
                else idxToSwap = childOneIdx;

                if(heap.get(idxToSwap)<heap.get(currentIdx)){
                    swap(idxToSwap, currentIdx, heap);
                    currentIdx=idxToSwap;
                    childOneIdx=2 * currentIdx + 1;
                }else return;
            }
        }

        public void siftUp(int currentIdx, List<Integer> heap) {
            // Write your code here.
            int parentNodeIdx = (int) Math.floor((currentIdx - 1) / 2);
            while (currentIdx > 0 && heap.get(currentIdx) < heap.get(parentNodeIdx)) {
                swap(currentIdx, parentNodeIdx, heap);
                currentIdx = (int) Math.floor((currentIdx - 1) / 2);
                parentNodeIdx = (int) Math.floor((currentIdx - 1) / 2);
            }
        }

        public int peek() {
            // Write your code here.
            System.out.println(heap);
            return heap.get(0);
        }

        public int remove() {
            // Write your code here.

            System.out.println("remove start:"+heap);
            int temp = heap.get(0);
            heap.set(0, heap.get(heap.size()-1));
            heap.remove(heap.size()-1);
            int currentIdx = 0;
            siftDown(currentIdx, heap.size()-1, heap);
            System.out.println("remove end:"+heap);
            return temp;
        }

        public void insert(int value) {
            // Write your code here.
            if (heap.isEmpty()) {
                heap.add(value);
                return;
            }
            heap.add(value);
            siftUp(heap.size() - 1, heap);

            //System.out.println("insert:"+heap);

        }

        void swap(int i, int j, List<Integer> heap) {
            int temp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, temp);

        }

    }
}