package com.practice.dsa.algo;

/**
 * Given an array of non-negative integers and a number x, create a method to find a pair in the array whose product is closest to x.
 * Examples:
 * Input : arr[] = [2, 3, 5, 9]
 *        x = 47
 * Output : {5, 9}
 *
 * Input : arr[] = [2, 13, 5, 9]
 *        x = 8
 * Output : {2, 5}
 * Please provide your answers in pseudo code and also provide your considerations and areas where you feel improvements can be made.
 */
public class Main {
    public static void main(String[] args) {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
//        int[] arr = new int[]{2, 3, 5, 9}; //
//        int target = 47;
//        int[] close = new int[2];
//        Map<Integer, Integer> map = new HashMap<>();
//        int nearest = target;
//        for(int i=0; i<arr.length;i++){
//            for(int j=i+1;j<arr.length;j++){
//                int product = arr[i]*arr[j];
//                int diff = Math.abs(target-product);
//                if(diff<nearest){
//                    nearest = diff;
//                    close[0] = arr[i];
//                    close[1] = arr[j];
//                }
//            }
//        }
//
//        System.out.println(close[0]+" "+close[1]);
//
//        StringBuilder sb = new StringBuilder();
//        sb.append(123+",");
//        sb.deleteCharAt(sb.length()-1);
//        System.out.println(sb);
        int input = 1;
        String result = "";
        StringBuilder sb = new StringBuilder();
        int start = (int)(Math.pow(10,input-1));
        int max = (int) (Math.pow(10,input));
        for(int i=start;i<max;i++){
            if(isValid(Integer.toString(i))){
                sb.append(i).append(",");
            }
        }
        System.out.println(start+" "+max +" "+sb);
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }

    public static boolean isValid(String number){
        for(int i=0;i<number.length()-1;i++){
            if(number.charAt(i)>number.charAt(i+1))
                return false;
        }
        return true;
    }
}