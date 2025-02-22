package com.abhilash.codinginterview.sorting;

/* 
 * As the name specifies, the selection sort algorithm selects the smallest element from the unsorted portion of the array and swaps it with the first element of the unsorted portion of the array.
 */
public class SelectionSortImplementation {

    public static void main(String[] args) {
        int[] arr = { 64, 25, 12, 22, 11 };
        new SelectionSortImplementation().sortArray(arr);
    }

    public void sortArray(int[] arr) {
        int n = arr.length;
        int index = 0;

        while (index < n - 1) {
            int min = getMinimum(arr, index, n - 1);
            swap(arr, index, min);
            index++;
        }
        for (int val : arr) System.out.print(val + "\t");
    }

    private int getMinimum(int[] arr, int start, int end) {
        int min = start;
        for (int i = start; i <= end; i++) if (arr[i] < arr[min]) min = i;
        return min;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
