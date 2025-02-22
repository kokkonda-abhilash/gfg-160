package com.abhilash.codinginterview.gfg.searching;

public class MinimumElementInRotatedSortedArray {

    public static void main(String[] args) {
        System.out.println(new MinimumElementInRotatedSortedArray().pullMinimumElement(new int[] { 4, 2, 3 }));
    }

    /* 
     * As the array is sorted we can apply binary search
     * Observation in case of rotation of sorted array
     * Example:
     * arr = [1, 2, 3, 4, 5, 6]
     * rotarr = [5, 6, 1, 2, 3, 4]
     * mid = 3 rotarr[mid] = 2
     * rotarr[mid] < arr[left] => left half is not sorted & that also means right half is sorted
     * Always the minimum element lies in the unsorted part of the array
     * So, here update right as mid
     * 
     * Example:
     * arr = [1, 2, 3, 4, 5, 6]
     * rotarr = [3, 4, 5, 6, 1, 2]
     * mid = 3, rotarr[mid] = 6
     */

    public int pullMinimumElement(int[] arr) {
        int n = arr.length;
        if (n == 1) return arr[0];
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = (left + right)/2;
            if (arr[mid] > arr[right]) {
                /* Right half of the array is not sorted 
                 * So check in the right half of the array
                */
                left = mid + 1;
            } else {
                /*
                 * Right half of the array is aorted.
                 * Check in the left half of the array
                */
                right = mid;
            }
        }
        return arr[left];
    }
}
