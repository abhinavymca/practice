package com.practice.dsa;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * [1,3],[2,4],[3,5]
 *
 * [1,9],[2,9],[3,5],[6,9],[6,10]
 *
 */
public class MaximumOverlappingMeeting {
    public static void main(String[] args) {
        //int[][] inp = new int[][]{{1,3},{2,4},{3,5}};
        int[][] inp = new int[][]{{1,9},{2,9},{3,5},{6,9},{7,10}};
        List<Pair> list = new ArrayList<>();
        for(int[] i: inp){
            list.add(new Pair(i[0],'x'));
            list.add(new Pair(i[1],'y'));
        }
        list.sort(Comparator.comparingInt(a -> a.time));
        int max=0;
        int count=0;
        for(Pair p: list){
            if(p.startEnd=='x') count++;
            if(p.startEnd=='y') count--;
            max = Math.max(max, count);
        }
        System.out.println(max);
    }
    static class Pair{
        int time;
        char startEnd;

        public Pair(int time, char startEnd) {
            this.time = time;
            this.startEnd = startEnd;
        }
    }
}
