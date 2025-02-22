package com.abhilash.codinginterview.sorting;

/* 
 * In bubble sort, the biggest element bubbles up to the end of the array in each iteration.
 * We compare adjacent elements and swap them if they are in the wrong order.
 * With each iteration, the biggest element bubbles up to the end of the array.
 * So, for the next iteration, we don't need to check the last element.
 * 
 * i ->
 *      0 - n - 1
 *      0 - n - 2
 *      0 - n - 3
 *      0 - n - 4
 *      0 - 1
 * j -> 0 to i - 1 as we need to compare arr[j] and arr[j + 1]
 * 
 * *** Optimisation -> if array is already sorted, then there will be no swapping. So, we can break the loop.
 * 
 * *** The best case time complexity is O(n) when the array is already sorted.
 */
public class BubbleSortImplementation {

    public static void main(String[] args) {
        int[] arr = { 64, 25, 12, 22, 11 };
        new BubbleSortImplementation().sortGivenArray(arr);
        for (int val : arr) System.out.print(val + "\t");
    }

    public void sortGivenArray(int[] arr) {
        int n = arr.length;
        /* i runs from n - 1 to 1 anf for each iteration we go through the elements and swap */
        for (int i = n - 1; i > 0; i --) {
            int swap = 0;
            for (int j = 0; j < i; j ++) if (arr[j] > arr[j + 1]) {
                swap(arr, j, j + 1);
                swap += 1;
            }
            if (swap > 0) break;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
