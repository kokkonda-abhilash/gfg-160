package com.abhilash.codinginterview.gfg.strings;

public class CheckIfTwoStringsAreRotated {

    public static void main(String[] args) {
        System.out.println(new CheckIfTwoStringsAreRotated().checkIfRotated("abcd", "acbd"));
    }

    /* 
     * We will employ KMP algorithm to match the pattern
     */
    public boolean checkIfRotated(String s1, String s2) {
        int n = s1.length();
        if (n == 0) return true;
        if (n == 1) return (s1.charAt(0) == s2.charAt(0));
        String text = s1 + s1;
        int[] lps = prepareLpsArray(s2);
        int index = 0;
        int textindex = 0;

        while (index < n && textindex < n * 2) {
           if (s2.charAt(index) == text.charAt(textindex)) {
               if (index == n - 1) return true;
               index++;
               textindex++;
           } else {
               if (index == 0) textindex++;
               else index = lps[index - 1];
           }
        }
        return false;
    }

    private int[] prepareLpsArray(String s2) {
        int n = s2.length();
        int[] lps = new int[n];
        int index = 1;
        int previous = 0;
        int continuedMatchLength = 0;

        while (index < n) {
            if (s2.charAt(index) == s2.charAt(previous)) {
                continuedMatchLength++;
                lps[index] = continuedMatchLength;
                index++;
                previous++;
            } else {
                if (previous == 0) {
                    continuedMatchLength = 0;
                    lps[index] = 0;
                    index++;
                } else {
                    previous = lps[previous - 1];
                    continuedMatchLength = lps[previous];
                }
            }
        }
        return lps;
    }
}
