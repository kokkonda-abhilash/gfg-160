package com.abhilash.codinginterview.sorting;

/* 
 * In insertion sort, we pick an element and place in correct position in the sorted array.
 * In order to place that element in correct position programatically, we employ swapping mechanism until the element cannot be swapper further.
 */
public class InsertionSortImplementation {

    public static void main(String[] args) {
        int[] arr = { 64, 25, 12, 22, 11 };
        new InsertionSortImplementation().sortGivenArray(arr);
        for (int val : arr) System.out.print(val + "\t");
    }

    public void sortGivenArray(int[] arr) {
        /* 
         * As we need to compare the elements we start from 1.
         * 
         * Pick an element at i, compare it with i - 1, if it is smaller, swap it with i - 1 until index 0
         * 
         * Best case time complexity is O(n) when the array is already sorted.
         */
        int n = arr.length;
        for (int i = 1; i < n - 1; i ++) placeElement(arr, i);
    }

    private void placeElement(int[] arr, int index) {
        while (index > 0 && arr[index] < arr[index - 1]) {
            swap(arr, index, index - 1);
            index--;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}