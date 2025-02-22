package com.abhilash.codinginterview.gfg.strings.patternmatching;

/* 
 * Suppose that the given string is abc. Then prefixes are "", "a", "ab", "abc"
 * But proper prefixes are "", "a", "ab"
 * A proper prefix length should always be less than the length of the string
 * Similarly, suffixes are "", "c", "bc", "abc"
 * Find out the proper prefix which is also a suffix at every point
 * 
 * Examples:
 * 1. abc
 * Proper prefix: "", "a", "ab"
 * Suffix: "", "c", "bc", "abc"
 */
public class ProperPrefixSuffixArray {

    public static void main(String[] args) {
        String pattern = "abcdbcccabcdbcccababababababababa";
                       /* 00011201234 */
        int[] lps = new ProperPrefixSuffixArray().lpsBuilder(pattern);
        for (int val: lps) System.err.print(val + " ");
    }

    public int[] lpsBuilder(String pattern) {
        final int n = pattern.length();
        final int[] lps = new int[n];
        int index = 1;
        int continuedMatchlength = 0;
        int prev = 0;

        /* We traverse the array from 1 to n - 1 */
        while (index < n) {
            if (pattern.charAt(index) == pattern.charAt(prev)) {
                continuedMatchlength++;
                lps[index] = continuedMatchlength;
                index++;
                prev++;
            } else {
                if (prev == 0) {
                    continuedMatchlength = 0;
                    lps[index] = 0;
                    index++;
                } else {
                    /* We have matched the prefix with suffix until a certaiin point - prev traversed to some portion of the array
                     * Now, we encountered an unmatched character - Do we mve to begining aggain? No, We should not move the prev to zeroth index
                     * We need to check for the previously matched lenght and move prev to that point
                     *  1. Get the length of the previous prefix suffix -> will be the value of lps[prev - 1]
                     *  2. Now move prev to that point
                    */
                    prev = lps[prev - 1];
                    continuedMatchlength = lps[prev];
                }
            }
        }
        return lps;
    }
}
