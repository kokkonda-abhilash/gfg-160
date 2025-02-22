package com.abhilash.codinginterview.arrays;

/* 
 * Problem Statement: Given an integer N and an array of size N-1 containing N-1 numbers between 1 to N.
 * Find the number(between 1 to N), that is not present in the given array.
 * Example 1:
 * Input Format:
 * N = 5, array[] = {1,2,4,5}
 * Result:
 * 3
 * Explanation:
 * In the given array, number 3 is missing. So, 3 is the answer.
 */
public class MissingElementInArray {

    public static void main(String[] args) {
        int[] arr = { 0, 2, 2, 3, 4 };
        System.out.println(arrangeElements(arr));
    }

    /* 
     * Approach: Hashing array
     */
    public int getMissingElement(int[] inputArray) {
        int n = inputArray.length;
        int[] hashArray = new int[n + 1];
        for (int i = 0; i < n; i ++) hashArray[inputArray[i]] = 1;
        for (int i = 1; i <= n; i ++) if (hashArray[i] == 0) return i;
        return -1;
    }

    /* 
     * Optimal solution 1: Sum difference
     */
    public static int getMissingElement2(int[] arr) {
        /* If the array size is not given */
        int max = arr[0];
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < arr.length; i ++) if (max < arr[i]) max = arr[i];
        for (int i = 0; i < arr.length; i ++) sum1 += arr[i];
        sum2 = max * (max + 1)/2;
        return (sum2 - sum1);
    }

    /* Optimal solution 2: XOR */
    public static int getMissingElement3(int[] arr) {
        /* If the array size is not given */
        int xor1 = arr[0];
        int xor2 = arr.length;
        for (int i = 0; i < arr.length; i ++) {
            xor1 ^= arr[i];
            xor2 ^= i;
        }
        return (xor1 ^ xor2);
    }

    /* 
     * 
     * Refer this video for more good solutions: https://www.youtube.com/watch?v=MPJe14plo28
     * 
     */

    public static int arrangeElements(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i ++) {
            int position = arr[i] - 1;
            if (i != position && position >= 0 && position < n) {
                int temp = arr[position];
                arr[position] = arr[i];
                arr[i] = temp;
                if (i - 1 >= -1) i -= 1;
            }
        }

        for (int i = 0; i < n; i ++) if (arr[i] != i + 1) return i + 1;
        return n + 1;
    }
}
