package com.abhilash.codinginterview.gfg.sorting;

public class MergeArraysWithoutExtraSpace {

    public static void main(String[] args) {
        int[] a = {1, 5, 9, 10, 15, 20};
        int[] b = {2, 3, 8, 13};
        new MergeArraysWithoutExtraSpace().arrangeElements(a, b);
        for (int val: a) System.err.print(val + "\t");
        System.out.println();
        for (int val: b) System.err.print(val + "\t");
        System.out.println();
    }

    /* 
     * Approach 1:
     * As the second array should contain the elements that are the continuation of the last element of the first array
     * We compare elements of both the arrays and place them properly in correct array
     * Then we sort both the arrays to get the expected result
     * 
     * As both the arrays are sorted
     * We compare the last element of first array with first array of second element
     * If the element in the first array is greater than the one in the second one we swap the elements
     * We increment the pointer of second array and decrement pointer of first array
     */
    public void arrangeElements(int[] a, int[] b) {
        int firstpointer = a.length - 1;
        int secondpointer = 0;
        boolean didswap = false;
        while (firstpointer >= 0 && secondpointer < b.length) {
            if (a[firstpointer] > b[secondpointer]) {
                swap(a, b, firstpointer, secondpointer);
                didswap = true;
            }
            firstpointer--;
            secondpointer++;
        }
        if (didswap) {
            sort(a);
            sort(b);
        }
    }

    /* 
     * Approach 2: Gap Approach
     * We get the total size of the arrays - n = a.length (n) + b.length (m)
     * We iterate for each value of gap n+m/2 until n+m/2 > 0
     * We have two pointers i, j
     * j is gap units awat from i
     * i and j gets incremented and goes from 0 index of a to m index of b (i - n until m value)
     * we compare elements a[i] and b[j] (a[i], b[j - n] a[i - n] and b[j - n]) and swap elements if a[i] is greater
     * We repeat until gap (=n+m/2) is not 0
     */
    public void expectedArrangeElements(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int gap = (n + m)/2;
        while (gap > 0) {
            int firstpointer = 0;
            int secondpointer = firstpointer + gap;
            while (firstpointer < (n + m) && secondpointer < (n + m)) {

            }
            if (gap == 1) break;
            gap = gap/2;
        }
    }

    private void sort(int[] arr) {
        quicklySort(arr, 0, arr.length - 1);
    }

    private void quicklySort(int[] arr, int start, int end) {
        if (start >= end) return;
        int pivot = arr[end];
        int leftpointer = start;
        int rightpointer = end;
        while (leftpointer < rightpointer) {
            while (arr[leftpointer] <= pivot && leftpointer < rightpointer) leftpointer++;
            while (arr[rightpointer] >= pivot && leftpointer < rightpointer) rightpointer--;
            swap(arr, leftpointer, rightpointer);
        }
        if (arr[leftpointer] > arr[end]) swap(arr, leftpointer, end);
        else leftpointer = end;
        quicklySort(arr, start, leftpointer - 1);
        quicklySort(arr, leftpointer + 1, end);
    }

    private void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    private void swap(int[] a, int[] b, int index1, int index2) {
        int temp = a[index1];
        a[index1] = b[index2];
        b[index2] = temp;
    }
}
