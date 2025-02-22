package com.abhilash.codinginterview.gfg.strings;

public class CheckIfTwoStringsAreAnagrams {

    public static void main(String[] args) {
        System.out.println(new CheckIfTwoStringsAreAnagrams().checkIfBothAreAnagrams("a", "b"));
    }

    public boolean checkIfBothAreAnagrams(String s1, String s2) {
        int n = s1.length();
        if (n!= s2.length()) return false;
        if (n == 0) return true;
        if (n == 1) return s1.equals(s2);
        /* 
         * Here we can have a array of alphabets and manage the counts
         */
        int[] alphabets = new int[26];
        for (int i = 0; i < n; i ++) alphabets[s1.charAt(i) - 'a']++;
        for (int i = 0; i < n; i ++) alphabets[s2.charAt(i) - 'a']--;
        for (int val: alphabets) if (val > 0) return false;
        return true;
    }
}