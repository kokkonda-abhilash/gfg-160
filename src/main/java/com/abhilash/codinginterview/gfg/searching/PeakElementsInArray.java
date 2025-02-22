package com.abhilash.codinginterview.gfg.searching;
/* 
 * Given an array arr[] where no two adjacent elements are same, find the index of a peak element.
 * An element is considered to be a peak if it is greater than its adjacent elements (if they exist).
 * If there are multiple peak elements, return index of any one of them.
 * The output will be "true" if the index returned by your function is correct; otherwise, it will be "false".
 * 
 * Note: Consider the element before the first element and the element after the last element to be negative infinity.
 * 
 * Examples :
 * Input: arr = [1, 2, 4, 5, 7, 8, 3]
 * Output: true
 * Explanation: arr[5] = 8 is a peak element because arr[4] < arr[5] > arr[6].
 * 
 * Input: arr = [10, 20, 15, 2, 23, 90, 80]
 * Output: true
 * Explanation: arr[1] = 20 and arr[5] = 90 are peak elements because arr[0] < arr[1] > arr[2] and arr[4] < arr[5] > arr[6].
 * 
 * Input: arr = [1, 2, 3]
 * Output: true
 * Explanation: arr[2] is a peak element because arr[1] < arr[2] and arr[2] is the last element, so it has negative infinity to its right.
 */
public class PeakElementsInArray {

    public static void main(String[] args) {
        System.out.println(new PeakElementsInArray().getPeakelementByBinarySearch(new int[] { 1, 2, 3 }));
    }

    /* 
     * Naive approach
     * Loop over the array and check for previous and next element and set as peak if greater
     */
    public int getPeakelement(int[] arr) {
        int n = arr.length;
        if (n == 1) return 0;
        for (int i = 0; i < n; i ++) {
            boolean left = true;
            boolean right = true;
            if (i > 0 && arr[i] <= arr[i - 1]) left = false;
            if (i < n - 1 && arr[i] <= arr[i + 1]) right = false;
            if (left && right) return i;
        }
        return 0;
    }

    /* 
     * Employing binary search
     * 
     * If an element is smaller than it's next element then it is guaranteed that at least one peak element will exist on the right side of this element.
     * Conversely if an element is smaller than it's previous element then it is guaranteed that at least one peak element will exist on the left side of this element.
     * 
     * Why it is guaranteed that peak element will definitely exist on the right side of an element, if its next element is greater than it?
     * If we keep moving in the right side of this element, as long as the elements are increasing, we will eventually reach an element that is either:
     *  1. The last element of the array, which will be a peak as it is greater than or equal to its previous element.
     *  2. An element where the sequence is no longer increasing, i.e., arr[i] > arr[i + 1], which would be a peak element.
     * 
     * For the same reasons, if an element is lesser than its previous element, then it is guaranteed that at least one peak element will exist on the left side of that element.
     */
    public int getPeakelementByBinarySearch(int[] arr) {
        int n = arr.length;
        if (n == 1) return 0;
        if (arr[0] > arr[1]) return 0;
        if (arr[n - 1] > arr[n - 2]) return n - 1;

        int left = 1;
        int right = n - 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) return mid;
            else if (arr[mid] < arr[mid + 1]) left = mid + 1;
            else right = mid - 1;
        }
        return 0;
    }
}
