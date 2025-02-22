package com.abhilash.codinginterview.hashing;

/* 
 * >>>> Hashing <<<<
 * Let’s first try to understand the importance of hashing using an example:
 * Given an array of integers: [1, 2, 1, 3, 2] and we are given some queries: [1, 3, 4, 2, 10].
 * For each query, we need to find out how many times the number appears in the array.
 * For example, if the query is 1 our answer would be 2, and if the query is 4 the answer will be 0
 * 
 * Similarly, the following will be the answers to the given queries
 * We can use brute force approach and iterate over the array for each element in the query
 * There by we get the count of each element in the query
 * ---------
 * | 1 | 2 |
 * | 3 | 1 |
 * | 4 | 0 |
 * | 2 | 2 |
 * |10 | 0 |
 * ---------
 * 
 * Optimized approach using Hashing
 * 
 * >>>> What is Hashing <<<<
 * Combination of pre-storing and fetching
 * 
 * 
 * 
 * Step 1:
 *  We iterate over the array and store the count of occurence of the element in a map
 *  This step is called pre-storing because we are pre-storing the information before answering the queries
 * Step 2:
 *  Now for each query we will fetch the information of that from the map
 * 
 * So as per the query array, we store the all the elements into hash array
 * | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 |
 * | 2 | 2 | 1 | 0 | 0 | 0 | 0 | 0 | 0 |  0 |
 * 
 * >>>> What if the largest element in the query array is 10^9. In this case it is not practically good to pre-store 10^9 elements into map
 * So with the above method we can solve if the array is of a soecifed size. Later we can discuss on overcoming the limitation of specific size.
 * 
 * Solving the frequency using Map
 * In map, we can store the value as key and it's frequency as its value
 * 
 * >>>> What is HASHING and HOW IT WORKS <<<<
 * Methods of hashing
 *  Divison method
 *  Folding method
 *  Mid-Square method
 * 
 * >>>> Divison Method <<<<
 * Suppose we are given an array [ 2, 5, 16, 28, 139 ]
 * Inorder to create a hashing array we need to create an array of size 140 as the largest element is 139
 * >> What if the constraint is that we cannot use an array of size 10 <<
 * 
 *  Let's say, to solve this problem we consider using modulo 10 of each element (element % 10)
 *  Then we will hash (pre-store and fetch) the elements
 *  Pre-store hashing = index in hash array for the element arr[i] = arr[i]%10
 *  The elements end up like this in the hash array
 *  | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
 *  | 0 | 0 | 2 | 0 | 0 | 5 | 16| 0 | 8 |139|
 *  [ 0   0   1   0   0   1   1   0   1   1 ]
 *  For example, let us fetch number 139 from the hash array
 *  The index of 139 is 139%10 = 9, so value of 139 in hash array = hash[9] = 1
 *  Inorder to store the frequency of the element we can do hash[arr[i]%10] += 1
 * 
 * Let say, we have this array [ 2, 5, 16, 18, 28, 38, 138 ], and we are allowed to use an array of size 10
 * Lets employ the divison and modulo 10 method. So we have indexes from 0 to 9 in the hash array
 * | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
 * | 0 | 0 | 2 | 0 | 0 | 5 | 16| 0 | 8 | 0 |
 *                                   28
 *                                   38
 *                                   138
 * Here we have collison for 28 38 and 138 as they all have the same index 8. So we can use chaining to store the elements
 * They are saved as linked list in the hash array in sorted order.
 * So if you want to fetch 28, you can go to index 8 and traverse the linked list to get the element.
 * As it is sorted you can easily find the element using binary search
 */
public class BasicsOfHashing { }