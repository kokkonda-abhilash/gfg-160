package com.abhilash.codinginterview.gfg.searching;

public class SearchInSortedRotatedArray {

    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 5, 1 };
        int target = 1;
        System.out.println(new SearchInSortedRotatedArray().searchInRotatedArray(arr, target, 0, arr.length - 1));
    }

    public int searchInRotatedArray(int[] arr, int target, int left, int right) {
        if (left > right) return -1;
        int mid = left + (right - left) / 2;
        if (arr[mid] == target) return mid;
        else if (arr[left] <= arr[mid]) {
            /* Left half is sorted */
            if (target < arr[mid] && target >= arr[left]) {
                return searchInRotatedArray(arr, target, left, mid - 1);
            } else {
                return searchInRotatedArray(arr, target, mid + 1, right);
            }
        } else {
            /* Right half is sorted */
            if (target > arr[mid] && target <= arr[right]) {
                return searchInRotatedArray(arr, target, mid + 1, right);
            } else {
                return searchInRotatedArray(arr, target, left, mid - 1);
            }
        }
    }
}
