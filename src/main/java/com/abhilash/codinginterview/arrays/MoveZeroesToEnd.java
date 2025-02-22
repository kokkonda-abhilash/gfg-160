package com.abhilash.codinginterview.arrays;

import java.util.Arrays;

public class MoveZeroesToEnd {

    public static void main(String[] args) {
        int[] arr = { 3, 5, 0, 0, 4 };
        pushZerosToEnd(arr);
    }


    static void pushZerosToEnd(int[] arr) {
        
        int n = arr.length;
        int actualIndexing = -1;
        int zeroCounter = 0;
        
        for (int i = 0; i < n; i ++) {
            if (zeroCounter == 0) {
                actualIndexing += 1;
            }
            if (arr[i] == 0) {
                if (zeroCounter == 0) {
                    actualIndexing = actualIndexing + 1;
                }
                zeroCounter = zeroCounter + 1;
            } else {
                if (i != actualIndexing) {
                    actualIndexing = actualIndexing + 1;
                    arr[actualIndexing] = arr[i];
                }
            }
        }
        
        for (int j = actualIndexing + 1; j < n; j ++) {
            arr[j] = 0;
        }
        Arrays.asList(arr).forEach(System.out::println);
    }
}
