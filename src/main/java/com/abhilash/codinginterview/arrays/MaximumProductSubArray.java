package com.abhilash.codinginterview.arrays;

/* 
 * Problem Statement: Given an array that contains both negative and positive integers, find the maximum product subarray.
 * Example 1:
 * Input:
 * Nums = [1,2,3,4,5,0]
 * Output:
 * 120
 * Explanation:
 * In the given array, we can see 1×2×3×4×5 gives maximum product value.
 * Example 2:
 * Input:
 * Nums = [1,2,-3,0,-4,-5]
 * Output:
 * 20
 * Explanation:
 * In the given array, we can see (-4)×(-5) gives maximum product value.
 */
public class MaximumProductSubArray {

    /* 
     * Best & intuitive approach
     * Time: O(n)
     * Space: (1)
     */
    public int getMaxProduct4(int[] inputArray) {
        int max = inputArray[0];
        int min = inputArray[0];
        int result = inputArray[0];

        for (int i = 1; i < inputArray.length; i ++) {
            if (inputArray[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(inputArray[i], max * inputArray[i]);
            min = Math.min(inputArray[i], min * inputArray[i]);
            result = Math.max(result, max);
        }
        return result;
    }

    /* 
     * Approach 1: Brute force
     * Time: O(n * n * N)
     * Space: (1)
     */
    public int getMaxProduct(int[] inputArray) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < inputArray.length; i ++) {
            for (int j = i; j < inputArray.length; j ++) {
                int product = 1;
                for (int k = i; k <= j; k ++) product *= inputArray[k];
                result = Math.max(product, result);
            }
        }
        return result;
    }

    /* 
     * Approach 2: Better approach
     * Time: O(n * n * N)
     * Space: (1)
     */
    public int getMaxProduct2(int[] inputArray) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < inputArray.length; i ++) {
            int product = 1;
            for (int j = i; j < inputArray.length; j ++) {
                result = Math.max(product, result);
                product = product *= inputArray[j];
            }
        }
        return result;
    }

    /* 
     * If the given array only contains positive numbers: If this is the case, we can confidently say that the maximum product subarray will be the entire array itself.
     * If the given also array contains an even number of negative numbers: As we know, an even number of negative numbers always results in a positive number. So, also, in this case, the answer will be the entire array itself.
     * If the given array also contains an odd number of negative numbers: Now, an odd number of negative numbers when multiplied result in a negative number. Removal of 1 negative number out of the odd number of negative numbers will leave us with an even number of negatives. Hence the idea is to remove 1 negative number from the result. Now we need to decide which 1 negative number to remove such that the remaining subarray yields the maximum product.
     * For example, the given array is: {3, 2, -1, 4, -6, 3, -2, 6}. We will try to remove each possible negative number and check in which case the subarray yields the maximum product.
     *  Upon observation, we notice that each chosen negative number divides the array into two parts.
     *  The answer will either be the prefix part or the suffix part of that negative number.
     *  To find the answer, we will check all possible prefix subarrays (starting from index 0) and all possible suffix subarrays (starting from index n-1).
     *  The maximum product obtained from these prefix and suffix subarrays will be our final answer.
     *  If the array contains 0’s as well: We should never consider 0’s in our answer(as considering 0 will always result in 0) and we want to obtain the maximum possible product. So, we will divide the given array based on the location of the 0’s and apply the logic of case 3 for each subarray.
     *  For example, the given array is: {-2, 3, 4, -1, 0, -2, 3, 1, 4, 0, 4, 6, -1, 4}.
     *    In this case, we will divide the array into 3 different subarrays based on the 0’s locations. So, the subarrays will be {-2, 3, 4, -1}, {-2, 3, 1, 4}, and {4, 6, -1, 4}.
     *    In these 3 subarrays, we will apply the logic discussed in case 3. We will get 3 different answers for 3 different subarrays.
     *    The maximum one among those 3 answers will be the final answer.
     */
    public int getmaxProduct3(int[] inputArray) {
        int n = inputArray.length;
        int pre = 1;
        int suf = 1;
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < n; i ++) {
            if (pre == 0) pre = 1;
            if (suf == 0) suf = 1;
            pre = pre * inputArray[i];
            suf = suf * inputArray[n - i - 1];
            result = Math.max(result, Math.max(pre, suf));
        }
        return result;
    }
}