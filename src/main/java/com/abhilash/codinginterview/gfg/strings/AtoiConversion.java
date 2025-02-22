package com.abhilash.codinginterview.gfg.strings;

/* 
 * 
 */
public class AtoiConversion {

    public static void main(String[] args) {
        System.out.println(new AtoiConversion().getInteger("  -0012gfg4"));
    }

    public int getInteger(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int index = 0;
        boolean isNegative = false;

        /* Check for white spaces in the beginning of the string
         * Loop until you don't encounter non space character
        */
        while (index < n && s.charAt(index) == ' ') index ++;

        /* Now check for the sign  -> negative or positive
         * Check the fist character at the index position
        */
        if (index < n && (s.charAt(index) == '-' || s.charAt(index) == '+')) {
            isNegative = s.charAt(index) == '-';
            index ++;
        }

        /* 
         * Loop until you encounter non digit character
         * MAX Value 2147483647 (-ve if MIN value)
         */
        System.out.println("Max Value: " + Integer.MAX_VALUE);
        System.out.println("Max Value: " + Integer.MIN_VALUE);
        int result = 0;
        while (index < n && (s.charAt(index) >= '0' && s.charAt(index) <= '9')) {
            int digit = s.charAt(index) - '0';
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result = result * 10 + digit;
            index ++;   
        }
        return (isNegative) ? -1 * result : result;
    }
}
