package com.abhilash.codinginterview.arrays;

/* 
 * Given an array of integers arr[] representing a permutation, implement the next permutation that rearranges the numbers into the lexicographically next greater permutation. If no such permutation exists, rearrange the numbers into the lowest possible order (i.e., sorted in ascending order).
 * Note - A permutation of an array of integers refers to a specific arrangement of its elements in a sequence or linear order.
 * 
 * Input: arr = [2, 4, 1, 7, 5, 0]
 * Output: [2, 4, 5, 0, 1, 7]
 * Explanation: The next permutation of the given array is {2, 4, 5, 0, 1, 7}
 * 
 * Input: arr = [3, 2, 1]
 * Output: [1, 2, 3]
 * Explanation: As arr[] is the last permutation, the next permutation is the lowest one
 * 
 * Input: arr = [3, 4, 2, 5, 1]
 * Output: [3, 4, 5, 1, 2]
 * Explanation: The next permutation of the given array is {3, 4, 5, 1, 2}
 * 
 * >>>> Intuition <<<<
 * Consider the array - [2, 4, 1, 7, 5, 0]
 * If we observe, the array will be sorted at a break point. Here it is 1
 * Left to 1 is ascending order and right to 1 is descending order
 * We need to find the next permutaiton, meaning the next higher order arrangement
 * So the next higher element to 1 is 5, so 5 will come in the place of 1. We can swap these two elements
 * After that, we have already placed the next higher element, the right part can be sorted to he minimum higher arrangement of the elements
 * 
 */
public class NextPermutation {

    public static void main(String[] args) {
        int[] arr = { 1, 4, 3, 2 };
        new NextPermutation().findNextPermuation(arr);
        for (int a: arr) System.out.print(a + "\t");
    }

    public void findNextPermuation(int[] arr) {
        int n = arr.length;
        int breakPoint = -1;
        int nextPermuationIndex = -1;

        if (n > 1) {
            /* Step 1: Run from the right of the array and identify the break point */
            for (int i = (n - 2); i >= 0; i--) {
                if (arr[i] < arr[i + 1]) {
                    breakPoint = i;
                    break;
                }
            }
            /*
             * Step 2: If break point is -1, then the the given permutation is the last
             * permutation
             * In this case we will give the first permutation as the result - Sort the
             * array in ascending order
             */
            if (breakPoint == -1) reverseArray(arr, 0, n);
            else {
                /*
                 * Step 3: The break point is identified, now get the least possible number
                 * greater then the element at breakpoint and swap them
                 * Here also we can apply the same intuition - the right part of the array will
                 * be in sorted order
                 * So, iterate the array from the end and get the first occurring greater
                 * element
                 */
                for (int i = (n - 1); i >= (breakPoint + 1); i--) {
                    if (arr[i] > arr[breakPoint]) {
                        nextPermuationIndex = i;
                        break;
                    }
                }
                int temp = arr[breakPoint];
                arr[breakPoint] = arr[nextPermuationIndex];
                arr[nextPermuationIndex] = temp;

                /*
                * Step 4: Sort the right part of the array
                * Here also we can apply the obsrvation.
                * As we have replaced the element in the right part of the array with minimum
                * greater element
                * straight reversal will do the sorting
                */
                reverseArray(arr, breakPoint + 1, n + breakPoint + 1);
            }
        }
    }

    private void reverseArray(int[] arr, int start, int end) {
        while (start < end / 2) {
            int temp = arr[start];
            arr[start] = arr[end - start - 1];
            arr[end - start - 1] = temp;
            start ++;
        }
    }
}
