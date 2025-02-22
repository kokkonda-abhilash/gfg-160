package com.abhilash.codinginterview.gfg.sorting;

/* 
 * Given an array arr[] containing only 0s, 1s, and 2s. Sort the array in ascending order.
 * 
 * Examples:
 * 
 * Input: arr[] = [0, 1, 2, 0, 1, 2]
 * Output: [0, 0, 1, 1, 2, 2]
 * Explanation: 0s 1s and 2s are segregated into ascending order.
 * 
 * Input: arr[] = [0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1]
 * Output: [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2]
 * Explanation: 0s 1s and 2s are segregated into ascending order.
 */
public class SortZerosAndOnes {

    public static void main(String[] args) {
        int[] arr = { 0, 1, 2, 0, 1, 2 };
        new SortZerosAndOnes().sort012(arr);
    }

    public int[] bruteForce(int[] arr) {
        int n = arr.length;
        int[] counts = new int[3];
        if (n == 0 || n == 1)
            return arr;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0)
                counts[0] += 1;
            if (arr[i] == 1)
                counts[1] += 1;
            if (arr[i] == 2)
                counts[2] += 1;
        }
        for (int val : counts)
            System.out.print(val + "\t");
        System.out.println();
        int index = 0;
        while (counts[0] >= 1) {
            arr[index] = 0;
            counts[0] -= 1;
            index++;
        }
        while (counts[1] >= 1) {
            arr[index] = 1;
            counts[1] -= 1;
            index++;
        }
        while (counts[2] >= 1) {
            arr[index] = 2;
            counts[2] -= 1;
            index++;
        }
        for (int val : arr)
            System.out.print(val + "\t");
        return arr;
    }

    /*
     * [Expected Approach] Dutch National Flag Algorithm - One Pass - O(n) Time and
     * O(1) Space
     * The problem is similar to "Segregate 0s and 1s in an array".
     * The idea is to sort the array of size n using three pointers:
     * lo = 0, mid = 0 and hi = n - 1 such that the array is divided into three
     * parts
     * arr[0] to arr[lo - 1]: This part will have all the zeros.
     * arr[lo] to arr[mid - 1]: This part will have all the ones.
     * arr[hi + 1] to arr[n - 1]: This part will have all the twos.
     * 
     * Here, lo indicates the position where next 0 should be placed
     * mid is used to traverse through the array
     * hi indicates the position where next 2 should be placed
     * 
     * Traverse over the array till mid <= hi, according to the value of arr[mid] we
     * can have three cases:
     * arr[mid] = 0, then swap arr[lo] and arr[mid] and increment lo by 1 because
     * all the zeros are till index lo - 1 and move to the next element so increment
     * mid by 1
     * arr[mid] = 1, then move to the next element so increment mid by 1.
     * arr[mid] = 2, then swap arr[mid] and arr[hi] and decrement hi by 1 because
     * all the twos are from index hi + 1 to n - 1. Now, we don't move to the next
     * element because the element which is now at index mid can be a 0 and
     * therefore needs to be checked again.
     */
    public void sort012(int[] arr) {
        int n = arr.length;
        if (n > 1) {
            int left = 0;
            int mid = 0;
            int right = n - 1;

            while (mid <= right) {
                if (arr[mid] == 0) {
                    swapItems(arr, mid, left);
                    mid++;
                    left++;
                } else if (arr[mid] == 1) {
                    mid++;
                } else {
                    swapItems(arr, mid, right);
                    right--;
                }
            }
        }
    }

    private void swapItems(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}