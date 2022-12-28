package com.alorithm.easy;

import java.util.Arrays;

/**
 * @author 王贤
 */
public class MaxRepeatSubString {

    /**
     * 给你一个字符串sequence，如果字符串 word连续重复k次形成的字符串是sequence的一个子字符串，那么单词word 的 重复值为 k 。
     * 单词 word的 最大重复值是单词word在sequence中最大的重复值。如果word不是sequence的子串，那么重复值k为 0 。
     *
     * 给你一个字符串 sequence和 word，请你返回 最大重复值k 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/maximum-repeating-substring
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        System.out.println(maxRepeating("ababc",
                "ab"));
        System.out.println(maxRepeating("ababc",
                "ba"));
        System.out.println(maxRepeating("ababc",
                "ac"));
        System.out.println(maxRepeating("aaabaaaabaaaabaaaabaaaaba",
                "aaaba"));
    }


    public static int maxRepeating(String sequence, String word) {
        int n = sequence.length(), m = word.length();
        if (n < m) {
            return 0;
        }

        int[] f = new int[n];
        for (int i = m - 1; i < n; ++i) {
            boolean valid = true;
            for (int j = 0; j < m; ++j) {
                if (sequence.charAt(i - m + j + 1) != word.charAt(j)) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                f[i] = (i == m - 1 ? 0 : f[i - m]) + 1;
            }
        }

        return Arrays.stream(f).max().getAsInt();
    }
}
