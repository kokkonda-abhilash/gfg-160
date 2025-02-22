package com.abhilash.codinginterview.gfg.sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeOverlappingIntervals {

    public static void main(String[] args) {
        int[][] arr = {{1,3},{2,4},{6,8},{9,10}};
        List<int[]> result = new MergeOverlappingIntervals().merge(arr);
        result.forEach(x -> System.out.println(x[0] + "\t" + x[1]));
    }

    private List<int[]> merge(int[][] arr) {
        List<int[]> result = new ArrayList<>();
        int n = arr.length;
        if (n <= 1) {
            if (n == 1) result.add(arr[0]);
            return result;
        }
        divideAndMerge(arr, 0, arr.length - 1);
        for (int[] x: arr) System.out.println(x[0] + "\t" + x[1]);
        System.out.println();
        result.add(arr[0]);

        for (int i = 0; i < arr.length; i++) {
            int[] interval = result.get(result.size() - 1);
            if (interval[1] >= arr[i][0]) {
                int intervalend = Math.max(interval[1], arr[i][1]);
                interval[1] = intervalend;
            } else result.add(arr[i]);
        }
        return result;
    }

    private void divideAndMerge(int[][] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end)/2;
            divideAndMerge(arr, start, mid);
            divideAndMerge(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    private void merge(int[][] arr, int start, int mid, int end) {
        int left = start;
        int right = mid + 1;
        int[][] temp = new int[end - start + 1][2];
        int index = 0;
        while (left <= mid && right <= end) {
            if (arr[left][0] > arr[right][0]
                || (arr[left][0] == arr[right][0]
                    && arr[left][1] > arr[right][1])
            ) temp[index++] = arr[right++];
            else temp[index++] = arr[left++];
        }
        while (left <= mid) temp[index++] = arr[left++];
        while (right <= end) temp[index++] = arr[right++];
        for (int i = 0; i < temp.length; i++) arr[start + i] = temp[i];
    }
}
