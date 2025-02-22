package com.abhilash.codinginterview.gfg.arrays;

public class MaximumCicularSubArraySum {
    /* 
     * VERY VERY IMPORTAN PLEASE READ
     * Here we are only talking about the maximum contiguous sub array sum
     * Meaning that we need to remove the minimum contiguous sub array sum - and this minimum sum is
     * not to be taken as circular
     * Here we have two possibilities
     *      1. The maximum value can lie in the non-circular sub array
     *      2. The maximum value can like in the circular sub array portion
     */

    public static void main(String[] args) {
        // 107
        // int[] arr = { -7, 32, -11, 21, 18, 35, -26, -17, 35, -12, -38, -33, 32, 16, 44, 11, -40, -21, 2, 27, -35, 21, -37, -12, 1 };
        int[] arr = { -2, -3, -3 };
        System.out.println(new MaximumCicularSubArraySum().getMaximumSubArrayCircularSum2(arr));
    }

    /* 
     * Experiment here:
     *  As we consider only maximum sum as circular sub array
     *  We can extract the minimum sum sub array which is non-circular
     *  Then we can subtract that from the total sum
     */
    public int getMaximumSubArrayCircularSum(int[] arr) {
        int n = arr.length;
        int minsum = Integer.MAX_VALUE;
        int currentrunningminsum = 0;
        int totalsum = 0;

        for (int i = 0; i < n; i ++) {
            currentrunningminsum = Math.min(currentrunningminsum + arr[i], arr[i]);
            minsum = Math.min(currentrunningminsum, minsum);
            totalsum += arr[i];
        }
        if (minsum >= 0) {
            for (int i = 0; i < i; i ++) {
                if (minsum > arr[i]) minsum = arr[i];
            }
        }
        System.out.println("Min sum: " + minsum);
        System.out.println("Total sum: " + totalsum);
        int maxcircularsubarraysum = totalsum - minsum;
        return maxcircularsubarraysum;
    }

    /* 
     * VERY VERY IMPORTANT
     * The problem with the above approach is that, we are not considering if we can have max sum in the non-circualr sub array itself
     * So, we also calculated the max sum sub array and return the maximum value among them
     */
    public int getMaximumSubArrayCircularSum2(int[] arr) {
        int n = arr.length;
        int minsum = Integer.MAX_VALUE;
        int currentrunningminsum = 0;
        int totalsum = 0;
        int maxsum = Integer.MIN_VALUE;
        int currentrunningmaxsum = 0;

        for (int i = 0; i < n; i ++) {
            
            currentrunningminsum = Math.min(currentrunningminsum + arr[i], arr[i]);
            minsum = Math.min(currentrunningminsum, minsum);

            currentrunningmaxsum = Math.max(currentrunningmaxsum + arr[i], arr[i]);
            maxsum = Math.max(currentrunningmaxsum, maxsum);

            totalsum += arr[i];
        }
        if (maxsum == 0) {
            maxsum = Integer.MIN_VALUE;
            for (int a: arr) if (a > maxsum) maxsum = a;
        }
        /* If total sum and min sum are same, then the result min-total is zero, and it will be a wrong result */
        /* This is i think a case of all negatie integers */
        /* In this case we can return the normal maximum sum */
        if (totalsum == minsum) return maxsum;
        int maxcircularsubarraysum = totalsum - minsum;
        return Math.max(maxsum, maxcircularsubarraysum);
    }
}