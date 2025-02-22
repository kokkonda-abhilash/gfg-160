package com.abhilash.codinginterview.arrays;

public class RotateArray {

    static void rotateArr(int arr[], int d) {
        int n = arr.length;
        int numberOfRotations = 0;
        if (d < n) numberOfRotations = d;
        else if (d > n) numberOfRotations = (d % n);
        if (d != 0) {
            reverseArray(arr, 0, numberOfRotations);
            reverseArray(arr, numberOfRotations, numberOfRotations + n);
            reverseArray(arr, 0, n);
        }
    }
    
    private static void reverseArray(int arr[], int start, int end) {
        while (start < end/2) {
            int temp = arr[start];
            arr[start] = arr[end - start - 1];
            arr[end-start-1] = temp;
            start ++;
        }   
    }
}
