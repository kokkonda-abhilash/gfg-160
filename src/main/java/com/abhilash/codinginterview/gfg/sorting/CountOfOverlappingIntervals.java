package com.abhilash.codinginterview.gfg.sorting;

/* 
 * 1. First what we can do is sort the given intervals based on the starting time of the interval
 * What is overlapping
 *      [ [1, 2], [1, 3], [2, 3], [3, 4] ]
 *      [1, 2] and [1, 3] are overlapping as the starting time of second interval is less than ending time of first interval
 *      [1, 3] and [3, 4] are non overlapping (even when the end and start time are the same)
 *      [10, 15] and [11, 12] are overlapping and it is obvious
 * 2. We will iterate through the array and count for when we encounter a overlap
 * 3. Then we will remove the interval which has the greater end time (greedy approach - This way we can accommodate maximum number of non-overlapping intervals in the given range - this also helps in minimizing the count of overalps)
 * GFG Video: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/sorting-gfg-160/video/Mjg2NjA%3D
 */
public class CountOfOverlappingIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {5, 10}, {18, 35}, {40, 45}};
        System.out.println(new CountOfOverlappingIntervals().minRmoval1(intervals));
    }

    /* 
     * Approach 1: Sort the intervals based on the staring time
     */
    public int minRmoval1(int[][] intervals) {
        int n = intervals.length;
        if (n <= 1) return 0;
        int count = 0;
        sortIntervals(intervals, 0, n - 1);
        /* for (int[] val: intervals) System.out.println(val[0] + "\t" + val[1]); */
        int currentend = intervals[0][1];
        for (int i = 1; i < n; i ++) {
            if (currentend > intervals[i][0]) {
                count++;
                currentend = Math.min(currentend, intervals[i][1]);
            } else currentend = intervals[i][1];
        }
        return count;
    }

    /* 
     * Approach 2:
     * There is a second approach where we sort the intervals based on the end time of the interval
     */

    private void sortIntervals(int[][] arr, int start, int end) {
        if (start >= end) return;
        int mid = (start + end)/2;
        sortIntervals(arr, start, mid);
        sortIntervals(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    private void merge(int[][] arr, int start, int mid, int end) {
        int left = start;
        int right = mid + 1;
        int[][] temp = new int[end - start + 1][2];
        int index = 0;

        while (left <= mid && right <= end) {
            if (arr[left][0] > arr[right][0]) temp[index++] = arr[right++];
            else temp[index++] = arr[left++];
        }
        while (left <= mid) temp[index++] = arr[left++];
        while (right <= end) temp[index++] = arr[right++];
        for (int i = 0; i < temp.length; i ++) arr[start + i] = temp[i];
    }
}
