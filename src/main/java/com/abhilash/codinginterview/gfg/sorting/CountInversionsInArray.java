package com.abhilash.codinginterview.gfg.sorting;

public class CountInversionsInArray {

    public static void main(String[] args) {
        int[] arr = { 4, 3, 2, 1 };
        new CountInversionsInArray().expectedApproach(arr);
    }

    private void bruteForce(int[] arr) {
        int n = arr.length;
        int count = 0;

        for (int i = 0; i < n - 1; i++) {
            count += getNumberOfInversions(arr, i, n);
        }
        System.out.println(count);
    }

    private int getNumberOfInversions(int[] arr, int i, int n) {
        int count = 0;
        for (int j = i + 1; j < n; j ++) {
            if (arr[i] > arr[j]) count += 1;
        }
        return count;
    }

    /* 
     * The expected approach is to use the MergeSort technique
     * We divide the array in to two halves in merge sort
     * 1. We count the inversions in both the halves
     * 2. While merging, we count the cross-inversions (element in left half greater than element in right half)
     * 
     * https://www.geeksforgeeks.org/batch/gfg-160-problems/track/sorting-gfg-160/article/Mzk2OA%3D%3D
     * https://www.youtube.com/watch?v=AseUmwVNaoY
     */
    private void expectedApproach(int[] arr) {
        System.out.println(divideAndMerge(arr, 0, arr.length - 1));
        for (int k = 0;k < arr.length; k++) System.out.print(arr[k] + " ");
    }

    private int divideAndMerge(int[] arr, int start, int end) {
        int inversionscount = 0;
        if (start >= end) return inversionscount;
        int mid = (end + start)/2;
        inversionscount += divideAndMerge(arr, start, mid);
        inversionscount += divideAndMerge(arr, mid + 1, end);
        inversionscount += merge(arr, start, mid, end);
        return inversionscount;
    }

    private int merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int leftsubarrayindex = start;
        int rightsubarrayindex = mid + 1;
        int inversionscount = 0;
        int temparrayindex = 0;
        while (leftsubarrayindex <= mid && rightsubarrayindex <= end) {
            if (arr[leftsubarrayindex] > arr[rightsubarrayindex]) {
                /* Inversion scenario */
                temp[temparrayindex] = arr[rightsubarrayindex];
                /* When left element in the left (sorted) sub array is greater than the element from the right
                 * Then all the elements to the right of that left sub array elements are also greater than the right sub array element
                 * So, how many elements are there to the right of the element in the left sub array
                 * We can say mid - start + 1 number of elements
                 */
                inversionscount += mid - leftsubarrayindex + 1;
                temparrayindex++;
                rightsubarrayindex++;
            } else {
                temp[temparrayindex] = arr[leftsubarrayindex];
                temparrayindex++;
                leftsubarrayindex++;
            }
        }
        while (leftsubarrayindex <= mid) {
            temp[temparrayindex] = arr[leftsubarrayindex];
            temparrayindex++;
            leftsubarrayindex++;
        }
        while (rightsubarrayindex <= end) {
            temp[temparrayindex] = arr[rightsubarrayindex];
            temparrayindex++;
            rightsubarrayindex++;
        }
        for (int i = 0; i < temp.length; i ++) arr[start + i] = temp[i];
        return inversionscount;
    }
}