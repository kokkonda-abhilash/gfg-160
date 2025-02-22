package com.abhilash.codinginterview.gfg.searching;


/* 
 * Given two sorted arrays of sizes m and n respectively, the task is to find the element that would be at the k-th position in the final sorted array formed by merging these two arrays.
 * 
 * Examples: 
 * Input: a[] = [2, 3, 6, 7, 9], b[] = [1, 4, 8, 10], k = 5
 * Output: 6
 * Explanation: The final sorted array is [1, 2, 3, 4, 6, 7, 8, 9, 10]. The 5th element is 6.
 * 
 * Input: a[] = [100, 112, 256, 349, 770], b[] = [72, 86, 113, 119, 265, 445, 892], k = 7
 * Output: 256
 * Explanation: The final sorted array is [72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892]. The 7th element is 256.
 * 
 * 
 */
public class KthElementOfTwoSortedMergedArrays {

    public static void main(String[] args) {
        int[] a = { 100, 112, 256, 349, 770 };
        int[] b = { 72, 86, 113, 119, 265, 445, 892 };
        int k = 7;
        System.out.println(new KthElementOfTwoSortedMergedArrays().pullKthElement(a, b, k));
    }

    /* 
     * ==>> Naive Approach: Merge arrays into one sorted array
     * We create a merged array and push elements in sorted order from both the arrays.
     * Then we pull the kth element
     */

    /* 
     * ==>> Optimized merging: Avoid creating extra space for merger array
     * 1. We start with two pointers at the beginning of each array and another counter to keep track of the number of elements processed
     * 2. By comparing the current elements of both arrays, the smaller one is considered as part of the merged sequence
     * 3. And the pointer for that array would be incremented by 1
     * 4. This process continues until we have processed k elements. The kth element encountered in this process is the result
     */
    public int pullKthElement(int[] a, int[] b, int k) {
        int first = 0;
        int second = 0;
        int mergerindex = 0;
        int currentelement = a[0];

        int n = a.length;
        int m = b.length;
        while (first < n && second < m && mergerindex < k) {
            if (a[first] <= b[second]) {
                currentelement = a[first++];
                mergerindex ++;
            } else {
                currentelement = b[second++];
                mergerindex ++;
            }
        }
        while (first < n && mergerindex < k) {
            currentelement = a[first++];
            mergerindex ++;
        }
        while (second < m && mergerindex < k) {
            currentelement = b[second++];
            mergerindex ++;
        }
        return currentelement;
    }

    /* 
     * ===>> Best approach: Employ binary search
     * 1. 
     * 2. 
     * 3. 
     */
}
