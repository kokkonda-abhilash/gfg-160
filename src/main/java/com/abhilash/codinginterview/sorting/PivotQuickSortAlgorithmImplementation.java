package com.abhilash.codinginterview.sorting;

import java.util.Random;

/* 
 * To code the quick sort algorithm, the best way is the do manual working of the algorithm and then code it.
 * We will pick a pivot, and move
 *      elements smaller than pivot to left of pivot
 *      Elements larger than pivot to right of pivot
 * In order to do this, we will have two pointers and increment one and decrement one & once the breaking condition is encountered we will swap elements at those pointers
 * Once we reach left==right, it is the place where left pointer points to the element greater than pivot
 * Now we will swap the element at left pointer and pivot
 */

public class PivotQuickSortAlgorithmImplementation {

    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i ++) arr[i] = random.nextInt(100);
        new PivotQuickSortAlgorithmImplementation().quicksort(arr);
    }

    public void quicksort(int[] arr) {
        System.out.print("Before sorting:\t");
        for (int val: arr) System.out.print(val + "\t");
        System.out.println();
        partitionAndSwap(arr, 0, arr.length - 1);
        System.out.print("After sorting:\t");
        for (int val: arr) System.out.print(val + "\t");
        System.out.println();
    }

    private void partitionAndSwap(int arr[], int start, int end) {
        /* At some point, of the recursive call, we will have a array with single element - Simply return */
        if (start >= end) return;
        /* We will always the last element as the pivot */
        int pivot = arr[end];
        int left = start;
        int right = end - 1;
        while (left < right) {
            while (arr[left] <= pivot && left < right) left++;
            while (arr[right] >= pivot && left < right) right--;
            swap(arr, left, right);
        }
        /* Once the arrangement of the elements are done, left will point to the element greater than pivot, we will swap both so that pivot stays in middle/separation of the arrangement */
        if (arr[left] > arr[end]) swap(arr, left, end);
        else left = end;
        /* Recursively repeat the operation */
        partitionAndSwap(arr, start, left - 1);
        partitionAndSwap(arr, left + 1, end);
    }

    private void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}