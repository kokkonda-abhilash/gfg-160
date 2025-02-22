package com.abhilash.codinginterview.gfg.searching;

public class NumberOfOccurrencesOfTarget {

    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 2, 2, 2, 3 };
        int target = 4;
        System.out.println(new NumberOfOccurrencesOfTarget().countFreq(arr, target));
    }

    public int countFreq(int[] arr, int target) {
        int n = arr.length;
        if (n == 0) return 0;
        if (n == 1) return (arr[0] == target ? 1 : 0);
        int leftIndex = fetchIndex(arr, target, 0, n - 1, true);
        int rightIndex = fetchIndex(arr, target, 0, n - 1, false);
        if (rightIndex == leftIndex && rightIndex == -1) return 0;
        return (rightIndex - leftIndex + 1);
    }

    public int fetchIndex(int[] arr, int target, int left, int right, boolean forLeftIndex) {
        int result = -1;
        while (left <= right) {
            int mid = (left + right)/2;
            if (arr[mid] == target) {
                result = mid;
                if (forLeftIndex) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
}