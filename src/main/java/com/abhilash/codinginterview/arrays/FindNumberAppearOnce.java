package com.abhilash.codinginterview.arrays;

import java.util.HashMap;

public class FindNumberAppearOnce {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 1, 3, 3, 4, 4, 5, 5 };
        findNumberAppearOnceTwice3(arr);
    }

    /* 
     * Using hash array
     */
    public static void findNumberAppearOnceTwice1(int[] arr) {
        int max = arr[0];
        int result = -1;
        for (int i = 0; i < arr.length; i ++) max = Math.max(max, arr[i]);
        System.out.println(max);
        int[] hash = new int[max + 1];
        for (int i = 0; i < arr.length; i ++) hash[arr[i]] += 1;
        for (int val: hash) System.out.print(val + "\t");
        System.out.println();
        for (int i = 0; i < hash.length; i ++) {
            if (hash[i] == 1) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }

    /* 
     * Using map1
     */
    public static void findNumberAppearOnceTwice2(int[] arr) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        int result = -1;
        for (int i = 0; i < arr.length; i ++) {
            if (counts.containsKey(arr[i])) counts.put(arr[i], counts.get(arr[i]) + 1);
            else counts.put(arr[i], 1);
        }
        System.out.println(counts);
        for (int key: counts.keySet()) {
            if (counts.get(key) == 1) {
                result = key;
                break;
            }
        }
        System.out.println(result);
    }

    /* 
     * Best approach: XOR
     * XOR of same element = 0
     * XOR 0 and element = element
     */
    public static void findNumberAppearOnceTwice3(int[] arr) {
        int xor = 0;
        for (int i = 0; i < arr.length; i ++) xor ^= arr[i];
        System.out.println(xor);
    }
}
