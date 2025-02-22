package com.abhilash.codinginterview.gfg.strings;

public class FirstRepeatingNonCharacter {

    public static void main(String[] args) {
        System.out.println(new FirstRepeatingNonCharacter().getFirstNonRepeatingChar("racecar"));
    }

    /* 
     * Adopting map to store the frequency
     * But it's better to adopt array instead of map
     */
    public char getFirstNonRepeatingChar(String s) {
        int n = s.length();
        if (n == 0) return '$';
        if (n == 1) return s.charAt(0);

        char[] alphabets = new char[26];
        for (int i = 0; i < n; i ++) alphabets[s.charAt(i) - 'a']++;
        for (int i = 0; i < n; i ++) if (alphabets[s.charAt(i) - 'a'] == 1) return s.charAt(i);
        return '$';
    }
}
