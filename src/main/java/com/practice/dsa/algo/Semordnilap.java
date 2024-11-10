package com.practice.dsa.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Semordnilap {
    public static void main(String[] args) {

    }

    public ArrayList<ArrayList<String>> semordnilap(String[] words) {
        // Write your code here.
        Set<String> wordSet = Arrays.stream(words).collect(Collectors.toSet());
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        for(String w:words){
            String rev = new StringBuilder(w).reverse().toString();
            if(wordSet.contains(w)&& wordSet.contains(rev)){
                ArrayList<String> subList = new ArrayList<>();
                subList.add(w);
                subList.add(rev);
                list.add(subList);
                wordSet.remove(w);
                wordSet.remove(rev);
            }
        }
        return list;
    }

    public boolean palindrom(String a, String b){
        int i=0;
        int j=b.length()-1;
        while(i<j){
            if(a.charAt(i)!=b.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
