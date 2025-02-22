package com.abhilash.codinginterview.codingquestions;

public class SortTheGivenString {

    public static void main(String[] args) {
        String name = "abhilash";
        new SortTheGivenString().sortString(name.toCharArray());
    }

    public void sortString(char[] characters) {
        divideAndMerge(characters, 0, characters.length - 1);
        System.out.println(new String(characters));
    }

    private void divideAndMerge(char[] characters, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        divideAndMerge(characters, left, mid);
        divideAndMerge(characters, mid + 1, right);
        merge(characters, left, mid, right);
    }

    private void merge(char[] characters, int start, int mid, int end) {
        char[] temp = new char[end - start + 1];
        int index = 0;
        int i = start;
        int j = mid + 1;
        while (i <= mid && j <= end) {
            if (characters[i] >= characters[j]) temp[index++] = characters[j++];
            else temp[index++] = characters[i++];
        }
        while (i <= mid) temp[index++] = characters[i++];
        while (j <= end) temp[index++] = characters[j++];

        /* Populate the same in actual array */
        for (int k = 0; k < temp.length; k ++) characters[start + k] = temp[k];
    }
}
