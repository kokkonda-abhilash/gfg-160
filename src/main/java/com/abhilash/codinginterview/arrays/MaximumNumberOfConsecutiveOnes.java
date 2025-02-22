package com.abhilash.codinginterview.arrays;

public class MaximumNumberOfConsecutiveOnes {

    public int getMaximumConsecutiveOnes(int[] arr) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i ++) {
            /* int start = i;
            int end = -1; */
            if (arr[i] == 0) {
                max = Math.max(count, max);
                count  = 0;
            } else count += 1;
        }
        return count;
    }
}
