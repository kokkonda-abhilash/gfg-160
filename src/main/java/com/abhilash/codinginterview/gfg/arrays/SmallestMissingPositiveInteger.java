package com.abhilash.codinginterview.gfg.arrays;
/* 
 * 
 */
public class SmallestMissingPositiveInteger {

    public static void main(String[] args) {
        int [] arr = { 2, 2, -5, 2, -2, 7, 1, -8 };
        System.out.println(new SmallestMissingPositiveInteger().missingSmallestInteger(arr));
    }
    /* 
     * 1. We need to check only positive integers
     * 2. We are concerned only anout the elements which are between 1 and n and they should be positive
     * 3. The logic is to place the element in their respective positions -> 1 should be at 0 index, 2 at 1 3 at 2 and so on until n at n - 1
     * 4. For placing purpose we will swap the elements
     * 5. After swapping if the current element is not at its correct position, we will deal with the current position again
     * 6. If all elements are in their correct position, we will return n + 1 as that will be the smallest missing positive integer
     */
    public int missingSmallestInteger(int[] arr) {
        int n = arr.length;
        
        for (int i = 0; i < n; i ++) {
            int element = arr[i];

            /* This is to consider only positive integers that are lying between 1 and n */
            if (element <= 0 || element > n) continue;
            
            int itsCorrectPosition = element - 1;
            if (arr[itsCorrectPosition] != element) {
                /* If the element is not at its correct position, we will swap the elements */
                int temp = arr[itsCorrectPosition];
                arr[itsCorrectPosition] = element;
                arr[i] = temp;
                /* We may encounter the current element may not be in its correct position after swapping, so decrement i */
                if (arr[i] != i + 1) i -= 1;
            }
        }
        /* Return the first element which is not in it's correct position */
        for (int i = 0; i < n; i ++) if (arr[i] != i + 1) return i + 1;
        return n + 1;
    }
}
