package com.abhilash.codinginterview.gfg.strings;

/* 
 * Given two binary strings
 * Add them and return string binary result
 */
public class AddTwoBinaryStrings {

    public static void main(String[] args) {
        System.out.println(new AddTwoBinaryStrings().getResultString("01001001", "0110101"));
    }

    public String getResultString(String s1, String s2) {
        int n = s1.length() - 1;
        int m = s2.length() - 1;
        int index1 = 0;
        int index2 = 0;
        int carry = 0;
        StringBuilder result = new StringBuilder();

        while (index1 < n && s1.charAt(index1) == '0') index1 += 1;
        while (index2 < m && s2.charAt(index2) == '0') index2 += 1;
        while (((n - index1) >= 0) || ((m - index2) >= 0)) {
            int sum = carry;
            if (n - index1 >= 0) sum += s1.charAt(n) - '0';
            if (m - index2 >= 0) sum += s2.charAt(m) - '0';
            result.append(sum % 2);
            carry = sum/2;
            n--;
            m--;
        }
        if (carry != 0) result.append(carry);
        return result.reverse().toString();
    }
}
