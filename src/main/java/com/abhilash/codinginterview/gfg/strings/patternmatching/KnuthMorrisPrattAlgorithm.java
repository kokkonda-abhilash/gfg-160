package com.abhilash.codinginterview.gfg.strings.patternmatching;

import java.util.ArrayList;

/* 
 * https://www.youtube.com/watch?v=4jY57Ehc14Y
 * 
 * KMP Algorithm is used for pattern matching in a string
 * KMP algorithm aims at avoiding redundant comparisons.
 * For this purpose, we will build a prefix suffix array, so that we can keep track of
 * common elements at the end and start of the string
 * 
 * For this, we will build a prper prefix suffix array, and proper prefix suffix index array
 * A proper prefix of array abc means "", a, ab
 * 
 * **** The main aim is to calculate the longest prefix that is also a suffix in the given pattern ****
 * **** This means that if the begining of the pattern is again appearing anywhere in the pattern ****
 */
public class KnuthMorrisPrattAlgorithm {

    /* 357 */

    public static void main(String[] args) {
        String s1 =     "ebccaacdebbccacbccdcbbcaacdebbccacbcccaacdebbccacbccecaacdebbccacbccabdcaacdebbccacbccbaceedbeacaacdebbccacbccebecaacdebbccacbcccdedcaacdebbccacbcccaacdebbccacbccbbcaacdebbccacbccacaacdebbccacbcceccaacdebbccacbcccaacdebbccacbccccaacdebbccacbcccaacdebbccacbcccaacdebbccacbccecaacdebbccacbcccaacdebbccacbccecaacdebbccacbccbdcaacdebbccacbccedacaacdebbccacbccaacaacdebbccacbccceabdcaacdebbccacbccececaacdebbccacbccbbbcaacdebbccacbcccaacdebbccacbcceebcaacdebbccacbcccacaacdebbccacbccadbebdecbeacaacdebbccacbcccdcdcaacdebbccacbccdabcaacdebbccacbcccaacdebbccacbccabcbcaacdebbccacbccededdecabcbbcaacdebbccacbcceccaccaacdebbccacbccecaacdebbccacbccabaedcbddebccaacdebbccacbcccaacdebbccacbccbdacaacdebbccacbccaacaacdebbccacbcccdabdddcaacdebbccacbcccaacdebbccacbcccaacdebbccacbccdcaacdebbccacbcccaacdebbccacbcccaacdebbccacbcccaacdebbccacbccdabcacbcdbdaacaacdebbccacbcccaacdebbccacbcccaacdebbccacbccebcaacdebbccacbccecaacdebbccacbcccaacdebbccacbcccaacdebbccacbcccaacdebbccacbcccaacdebbccacbcccaacdebbccacbcccaacdebbccacbcc";
        String pattern = "caacdebbccacbcc";
                        /*00123456*/    /*00123 */
        System.out.println(new KnuthMorrisPrattAlgorithm().kmpMatcher(pattern, s1));
    }

    /* Brute-force approach */
    public boolean bruteForceMatcher(String s1, String pattern) {
        int n = s1.length();
        int m = pattern.length();
        int i = 0;
        while (i < n) {
            int index = 0;
            while (index < m) {
                System.out.println(pattern.charAt(index) + " " + s1.charAt(i) + " Equals: " + (pattern.charAt(index) == s1.charAt(i)));
                if (pattern.charAt(index) == s1.charAt(i)) {
                    index++;
                    i++;
                    if (index == m) return true;
                } else {
                    i++;
                    break;
                }
            }
        }
        return false;
    }

    public ArrayList<Integer> kmpMatcher(String pat, String txt) {
        int n = txt.length();
        int m = pat.length();
        if (n == 0 || m == 0) return new ArrayList<>();
        int[] lps = new ProperPrefixSuffixArray().lpsBuilder(pat);
        int index = 0;
        int patternindex = 0;
        ArrayList<Integer> indexes = new ArrayList<>();

        while (index < n) {
            if (pat.charAt(patternindex) == txt.charAt(index)) {
                if (patternindex == m - 1) {
                    indexes.add(index - patternindex);
                    if (index >= n - 1) {
                        return indexes;
                    }
                    patternindex = lps[patternindex];
                } else patternindex++;
                index++;
            } else {
                if (patternindex == 0) index++;
                else patternindex = lps[patternindex - 1];
            }
        }
        return indexes;
    }
}