package com.abhilash.codinginterview.gfg.strings;

public class SortNameUsingHashing {
    String name = "bha";

    public String getSortedString(String name) {
        int[] hashes = new int[26];
        char[] chars = new char[name.length()];
        for (int i = 0; i < name.length(); i++) hashes[name.charAt(i) - 'a']++;
        StringBuilder sb = new StringBuilder();
        
        int count = 0;
        for (int i = 0; i < 26; i ++) {
            
        }
        return null;
    }
}
