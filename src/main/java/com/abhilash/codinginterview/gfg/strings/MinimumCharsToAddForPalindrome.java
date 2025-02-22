package com.abhilash.codinginterview.gfg.strings;

/* 
 * Given a string s, the task is to find the minimum characters to be added at the front to make the string palindrome.
 * Note: A palindrome string is a sequence of characters that reads the same forward and backward.
 * 
 * Examples:
 * Input: s = "abc"
 * Output: 2
 * Explanation: Add 'b' and 'c' at front of above string to make it palindrome : "cbabc"
 * 
 * Input: s = "aacecaaaa"
 * Output: 2
 * Explanation: Add 2 a's at front of above string to make it palindrome : "aaaacecaaaa"
 * 
 */
public class MinimumCharsToAddForPalindrome {

    public static void main(String[] args) {
        /* System.out.println(new MinimumCharsToAddForPalindrome().getlpsArray("aacecaaaa".toCharArray())); */
                                                                           /*010001222 */
        System.out.println(new MinimumCharsToAddForPalindrome().getlpsArray("aabaaac".toCharArray()));
        /* aacecaaa$aaacecaa */
        /* 01000121012000012 */
    }

    /* 
     * The ask is the return how many characters we need to add in the front to make the given string a palindrome
     * The point to consider here is to add number of characters to add in the front
     *  1. Considering this, what we can do first is to check the longest prefix palindrome
     *  2. We will check if the given string is palindrome
     *  3. Else we will consider string without last character and check if it is palindrome and so on
     *  4. We will keep track of the count of left charcters at the end of the string in checking for LPP
     *  5. Finally when we are done, the count of left characters at the end are the minimum characters to be added
     */
    public int bruteForce(String s) {
        int n = s.length();
        if (n == 0 || n == 1) return 0;
        for (int i = n - 1; i >= 0; i--) {
            if (checkIfPalindrome(s, 0, i)) return n - 1 - i;
        }
        return n - 1;
    }

    private boolean checkIfPalindrome(String test, int start, int end) {
        if (start == end) return true;
        while (start < end) {
            if (test.charAt(start) != test.charAt(end)) return false;
            else {
                start++;
                end--;
            }
        }
        return true;
    }

    /* 
     * The approach is to employ KMP algorithm
     * For the gven string say a b c c d a b
     * We will create a new array which is the array conactenated with the reverse of the given array
     * KPM Array               a b a b d $ d b a b a 
     * Now we build LPS array 
     *                         0 0 1 2 0 0 0 0 1 2 3
     * Then the number of characters to be added in the front to make it palindrome is 2 - nothing but lps[n - 1] - 1
     */
    public int getNumberOfCharacters(String s) {
        int n = s.length();
        if (n == 0 || n == 1) return 0;
        char[] kmparray = getKMPArray(s, n);
        int[] lps = getlpsArray(kmparray);
        return n - lps[lps.length - 1];
    }

    private char[] getKMPArray(String s, int n) {
        char[] kmparray = new char[(2 * n) + 1];
        int m = kmparray.length;
        for (int i = 0; i <= n - 1; i++) {
            kmparray[i] = s.charAt(i);
            kmparray[m - i - 1] = s.charAt(i);
        }
        kmparray[n] = '$';
        System.out.println();
        for (char i: kmparray) System.out.print(i + " ");
        System.out.println();
        return kmparray;
    }

    private int[] getlpsArray(char[] kmparray) {
        int n = kmparray.length;
        int index = 1;
        int prev = 0;
        int continuedMatchlength = 0;
        final int[] lps = new int[n];

        while (index < n) {
            if (kmparray[index] == kmparray[prev]) {
                continuedMatchlength++;
                lps[index] = continuedMatchlength;
                index++;
                prev++;
            } else {
                if (prev == 0) {
                    continuedMatchlength = 0;
                    lps[index] = continuedMatchlength;
                    index++;
                } else {
                    /* Go to the previously matched prefix array */
                    prev = lps[prev - 1];
                    continuedMatchlength = lps[prev];
                }
            }
        }
        return lps;
    }

    private int[] gfglps(String pat) {

        int[] lps = new int[pat.length()];
        
        // counter stores the length of longest prefix which 
        // is also a suffix for the previous index
        int counter = 0;

        // lps[0] is always 0
        lps[0] = 0;

        int i = 1;
        while (i < pat.length()) {
            
            // If characters match, increment the size of lps
            if (pat.charAt(i) == pat.charAt(counter)) {
                counter++;
                lps[i] = counter;
                i++;
            } else {
                // If there is a mismatch
                if (counter != 0) {
                    // Update counter to the previous lps value
                    // to avoid redundant comparisons
                    counter = lps[counter - 1];
                } else {
                    // If no matching prefix found, set lps[i] to 0
                    lps[i] = 0;
                    i++;
                }
            }
        }
        for (int x: lps) System.out.println(x + " ");
        return lps;
    }
}
