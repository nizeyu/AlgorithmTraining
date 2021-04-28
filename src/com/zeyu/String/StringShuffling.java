package com.zeyu.String;

/**
 * @Auther: Zeyu Ni
 * @Date: 4/22/21 - 04 - 22 - 2:25 PM
 * @Description: com.zeyu.String
 * @Version: 1.0
 */
public class StringShuffling {
    public char[] solution(char[] input) {
        if (input == null || input.length == 0) {
            return input;
        }



        convert(input, 0, input.length - 1);

        return input;
    }

    private void convert(char[] a, int l, int r) {
        if (r - l <= 1) {
            return;
        }

        int size = r - l + 1;
        int m = l + size / 2;
        int lm = l + size / 4;
        int rm = l + size * 3 / 4;

        reverse(a, lm, m - 1);
        reverse(a, m, rm - 1);
        reverse(a, lm, rm - 1);

        convert(a, l, l + 2 * (lm - l) - 1);
        convert(a, l + 2 * (lm - l), r);
    }

    private void reverse(char[] chars, int i, int j) {
        while (i <= j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        StringShuffling stringShuffling = new StringShuffling();
        char[] input = {'A','B','C','D','E','1','2','3','4','5'};
        char[] output = stringShuffling.solution(input);
        for (Character c : output) {
            System.out.println(c);
        }

    }
}
