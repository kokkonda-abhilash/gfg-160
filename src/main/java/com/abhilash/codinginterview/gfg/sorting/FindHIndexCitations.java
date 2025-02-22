package com.abhilash.codinginterview.gfg.sorting;

import java.util.Arrays;

/* 
 * Given an array citations[] of size n such that citations[i] is the number of citations a researcher received for ith paper, the task is to find the H-index. H-index(H) is the largest value such that the researcher has published at least H papers that have been cited at least H times.
 * 'H' stands for Hirsch index as it was proposed by the J.E. Hirsch in 2005. The H-index is defined as the author-level metric that attempts to measure both the productivity and the citation impact of the publication of the scientist or the scholar.
 * 
 * Layman terms:
 * 
 * [5, 0, 2, 0, 2]
 * 5 -> 1 paper with 5 citations
 * 0 -> 2 papers with 0 citations
 * 2 -> 2 papers with 2 citations
 * 
 * [6, 0, 3, 5, 3]
 * 6 -> 1 paper with 6 citations
 * 0 -> 1 paper with 0 citations
 * 3 -> 2 papers with 3 citations
 * 5 -> 1 paper with 5 citations
 * 
 * [3, 0, 5, 3, 0]
 * 3 -> 2 papers with 3 citations
 * 0 -> 2 papers with 0 citations
 * 5 -> 1 paper with 5 citations
 * 
 * [5, 1, 2, 4, 1]
 * 5 -> 1 paper with 5 citations
 * 1 -> 2 papers with 1 citation
 * 2 -> 1 paper with 2 citations
 * 4 -> 1 paper with 4 citations
 * 
 * Examples:
 * 
 * Input: citations[] = {3, 0, 6, 1, 5}
 * Output: 3
 * Explanation: The researcher has 3 papers with at least 3 citations.
 * 
 * Input: citations[] = {5, 0, 2, 0, 2}
 * Output: 2
 * Explanation: There are at least 2 papers (5, 2, 2) with at least 2 citations.
 * 
 * Input: citations[] = {6, 0, 3, 5, 3}
 * Output: 3
 * Explanation: There are at least 3 papers (6, 5, 3, 3) with at least 3 citations.
 */
public class FindHIndexCitations {

    public static void main(String[] args) {
        int[] citations = {6, 0, 3, 5, 3};
        /* int[] citations = {6, 0, 3, 5, 3}; = 3 papers cited atleast 3 times */
        /* int[] citations = {3, 0, 5, 3, 0}; = 3 papers cited atleast 3 times */
        /* int[] citations = {5, 1, 2, 4, 1}; = 2 papers cited atleast 2 times */
        /* int[] citations = {0, 0}; = 0*/
        System.out.println(new FindHIndexCitations().expectedApproach(citations));
    }

    /* 
     * First sort the array in descending order.
     * Initialize idx = 0
     * iterate through the papers from left to right and if citations[idx] > idx
     * Then all the papers from 0 to idx have at least (idx + 1) citations
     * So, keep on incrementing idx till citations[idx] > idx
     * Finally, if we reach the end of array or citations[idx] <= idx, return idx
     */
    public int sortingApproach(int[] citations) {
        int n = citations.length;

        /* Sort the citations in descending order */
        Arrays.sort(citations);
        reverseArray(citations);
        int index = 0;
        // Keep incrementing idx till citations[n - 1 - idx] > idx
        while (index < n && citations[index] > index) index++;
        return index;
    }

    /* 
     * The expected approach is to inverse the given information
     * The given information is number of citations for each paper
     *      Where index is the paper
     *      Value is the number of citations
     * What we do is transform the given information into the number of papers with at least n citations
     * We do this using counting sort
     *     Where index is the number of citations
     *     Value is the number of papers
     * So, after the frequency array is created, if we traverse from right (bigger frequency)
     *   Each value from the right is the number of papers with at least n citations (value is number of papers, index is number of citations)
     * What we want is x (value) papers with at least x citations
     * This means index > x (value)
     * 
     * One edge case while constructing the frequency array is when the number of citations is greater than n
     * As we only get H index at most the size of the array, we can assume the citations greater than n are also as n
     * 
     * [6, 0, 3, 5, 3]
     * Frequency array (number of papers array of size = n + 1 = 6)
     * [1 0 0 2 0 2]
     *  0 1 2 3 4 5
     * At index 5 = we have 2 (value) papers with (at least) 5 citations (index)
     * At index 4 = we have 2 papers with 4 citations
     * At index 3 = we have 2 papers with 3 citations + 2 papers with 5 citations = 4 papers with atleast 3 citations -> This is our answer
     */
    public int expectedApproach(int[] citations) {
        int n = citations.length;
        int[] frequencies = new int[n + 1];
        for (int i = 0; i < n; i++) {
            /* Edge case when the number of citations is greater than n */
            if (citations[i] >= n) frequencies[n]++;
            else frequencies[citations[i]]++;
        }
        /* Now traverse from end of the array */
        int runningsumofpapers = 0;
        int index = frequencies.length - 1;
        while (index >= 0) {
            runningsumofpapers += frequencies[index];
            /* Checking if number of papers are greater than number of citations -> expected result */
            if (runningsumofpapers < index) index--;
            else break;
        }
        return index;
    }

    private void reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
