package com.practice.dsa;

import java.util.*;

public class MergeKSortedArrayList {
    public static void main(String[] args) {

        //mergeKSortedListNotOptimised();
        //mergeKSortedListHeapPriortyQueue();
        mergeKSortedArrayUsingIndex();
    }

    // list-index, index, number
    public static List<Integer> mergeKSortedListHeapPriortyQueue(){
        List<List<Integer>> arrays = new ArrayList<>();
        List<Integer> mergedList = new ArrayList<>();
        arrays.add(new ArrayList<>(Arrays.asList(1,2,3,4,5)));
        arrays.add(new ArrayList<>(Arrays.asList(1,2,3,4,5)));
        arrays.add(new ArrayList<>(Arrays.asList(1,2,3,4,5)));
        arrays.add(new ArrayList<>(Arrays.asList(1,2,3,4,5)));
        PriorityQueue<List<Integer>> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.get(0)));
        priorityQueue.addAll(arrays);

        while(!priorityQueue.isEmpty()){
            List<Integer> list = priorityQueue.poll();
            mergedList.add(list.get(0));
            list.remove(0);
            if(!list.isEmpty()){
                priorityQueue.add(list);
            }
        }
        System.out.println(mergedList);
        return mergedList;
    }

    private static void mergeKSortedArrayUsingIndex() {
        List<List<Integer>> arrays = new ArrayList<>();
        List<Integer> mergedList = new ArrayList<>();
        arrays.add(new ArrayList<>(Arrays.asList(1,2,3,4,5)));
        arrays.add(new ArrayList<>(Arrays.asList(1,2,3,4,5)));
        arrays.add(new ArrayList<>(Arrays.asList(1,2,3,4,5)));
        arrays.add(new ArrayList<>(Arrays.asList(1,2,3,4,5)));
        List<Integer> indexsList = new ArrayList<>(Collections.nCopies(arrays.size(),0));
        while(true){
            List<ListItem> smallestArray = new ArrayList<>();
            for(int i=0;i<arrays.size();i++){
                if(indexsList.get(i)<arrays.get(i).size()) {
                    smallestArray.add(new ListItem(arrays.get(i).get(indexsList.get(i)), i));
                }
            }
            if(smallestArray.isEmpty())
                break;
            ListItem item = findSmallest(smallestArray);
            mergedList.add(item.val);
            indexsList.set(item.arrayIndex, indexsList.get(item.arrayIndex)+1);

        }
        System.out.println(mergedList);
    }

    public static ListItem findSmallest(List<ListItem> smallestArray) {
        ListItem smallest = smallestArray.get(0);
        for(int i=1;i<smallestArray.size();i++){
            if(smallestArray.get(i).val<smallest.val)
                smallest = smallestArray.get(i);
        }
        return smallest;
    }
    static class ListItem{
        int val;
        int arrayIndex;

        public ListItem(int val, int arrayIndex) {
            this.val = val;
            this.arrayIndex = arrayIndex;
        }
    }

    public static int[] mergeKSortedListNotOptimised(){
        int[][] sortedList = {{1, 6, 8, 10}, {2, 3, 9, 11}, {1, 2, 4, 6, 7}};
        int[] fList = sortedList[0];
        for (int i = 1; i < sortedList.length; i++) {
            fList = mergeList(fList, sortedList[i]);
        }
        System.out.println(Arrays.toString(fList));
        return fList;
    }
    public static int[] mergeList(int[] l1, int[] l2) {
        int i = 0, j = 0, k = 0;
        int[] fList = new int[l1.length + l2.length];
        while (i < l1.length && j < l2.length) {
            if (l1[i] < l2[j]) {
                fList[k++] = l1[i++];
            } else {
                fList[k++] = l2[j++];
            }
        }

        while (i < l1.length) {
            fList[k++] = l1[i++];
        }
        while (j < l2.length) {
            fList[k++] = l2[j++];
        }
        return fList;
    }

}
