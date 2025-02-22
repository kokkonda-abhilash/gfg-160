package com.abhilash.codinginterview.gfg.searching;

public class FindFirstAndLastOccurrenceOfElementInSortedArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 2, 2, 2, 2, 3, 4, 7, 8, 8};
        int target = 2;
        int[] positions = new FindFirstAndLastOccurrenceOfElementInSortedArray().getIndexes(arr, target);
        System.out.println(positions[0] + "\t" + positions[1]);
    }

    public int[] getIndexes(int[] arr, int target) {
        int n = arr.length;
        int[] positions = { -1, -1};
        if (n == 0) return positions;
        if (n == 1) return (arr[0] == target ? new int[] { 0, 0 } : positions);
        int leftindex = findFirstOrLastIndex(arr, 0, n - 1, target, true);
        int rightindex = findFirstOrLastIndex(arr, 0, n - 1, target, false);
        positions[0] = leftindex;
        positions[1] = rightindex;
        return positions;
    }

    public int findFirstOrLastIndex(int[] arr, int start, int end, int target, boolean forLeftIndex) {
        int result = -1;
        while (start <= end) {
            int mid = (start + end)/2;
            if (arr[mid] == target) {
                result = mid;
                if (forLeftIndex) end = mid - 1;
                else start = mid + 1;
            } else if (target < arr[mid]) end = mid - 1;
            else start = mid + 1;
        }
        return result;
    }
}
