package com.abhilash.codinginterview.sorting;

/* 
 * Merge sort divide and merge approach
 * We will divide the array into two halves until we reach the smallest unit of the array - single element.
 * Then we will merge the two halves in the same order we divided the array.
 * To divided the array we can make use of recursion
 */
public class MergeSortImplementation {

    public static void main(String[] args) {
        int[] arr = { 64, 25, 12, 22, 11 };
        new MergeSortImplementation().mergeSortImplementation(arr);
        for (int val : arr) System.out.print(val + "\t");
    }

    public void mergeSortImplementation(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        divideAndMerge(arr, left, right);
    }

    private void divideAndMerge(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        divideAndMerge(arr, left, mid);
        divideAndMerge(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    /* 
     * Merge the two arrays from the currently considered start value of the actual array
     */
    private void merge(int[] arr, int left, int mid, int right) {
        int[] merger = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int index = 0;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) merger[index++] = arr[i++];
            else merger[index++] = arr[j++];
        }
        while (i <= mid) merger[index++] = arr[i++];
        while (j <= right) merger[index++] = arr[j++];

        /* Adding from currently starting index value - left of the original array */
        for (int k = 0; k < merger.length; k++) arr[left + k] = merger[k];
    }
}
