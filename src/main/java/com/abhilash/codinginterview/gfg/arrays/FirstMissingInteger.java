package com.abhilash.codinginterview.gfg.arrays;

public class FirstMissingInteger {

    public static void main(String[] args) {
        int[] arr = { 3, 4, -1, 1 };
        System.out.println(new FirstMissingInteger().getFirstMissigInteger(arr));
    }


    public int getFirstMissigInteger(int[] arr) {
        int n = arr.length;
        if (n == 0) return 1;
        if (n == 1) return (arr[0] == 1) ? 2 : 1;

        for (int i = 0; i < n; i ++) {
            int position = arr[i] - 1;
            if (position >= 0 && position < n && arr[position] != (position + 1)) {
                int temp = arr[position];
                arr[position] = arr[i];
                arr[i] = temp;

                if (arr[i] != i + 1) i --;      // Check if arr[i] has the right value
            }
        }
        for (int i = 0; i < n; i ++) {
            System.out.println(i + "\t" + arr[i]);
            System.out.println();
        }
        for (int i = 0; i < n; i ++) {
            if (arr[i] != i + 1) return i + 1;
        }
        return n + 1;
    }
}
