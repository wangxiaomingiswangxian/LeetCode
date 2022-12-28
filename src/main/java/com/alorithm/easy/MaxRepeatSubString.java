package com.alorithm.easy;

import java.util.Arrays;

/**
 * @author 王贤
 */
public class MaxRepeatSubString {

    /**
     * 给你一个字符串sequence，如果字符串 word连续重复k次形成的字符串是sequence的一个子字符串，那么单词word 的 重复值为 k 。
     * 单词 word的 最大重复值是单词word在sequence中最大的重复值。如果word不是sequence的子串，那么重复值k为 0 。
     * <p>
     * 给你一个字符串 sequence和 word，请你返回 最大重复值k 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/maximum-repeating-substring
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        System.out.println(maxRepeatingKmp("ababc",
                "ab"));
        System.out.println(maxRepeatingKmp("ababc",
                "ba"));
        System.out.println(maxRepeatingKmp("ababc",
                "ac"));
        System.out.println(maxRepeatingKmp("aaabaaaabaaaabaaaabaaaaba",
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

    /**
     * kmp算法
     */
    public static int maxRepeatingKmp(String sequence, String word) {
        int n = sequence.length(), m = word.length();
        if (n < m) {
            return 0;
        }
        int[] f = new int[n];
        int[] next = getPresuffix(word);

        int j = -1;
        for (int i = 0; i < n; i++) {
            while (j != -1 && word.charAt(j + 1) != sequence.charAt(i)) {
                j = next[j];
            }
            if (word.charAt(j + 1) == sequence.charAt(i)) {
                ++j;
                if (j == m - 1) {
                    f[i] = (i > m ? f[i - m] : 0) + 1;
                    j = next[j];
                }
            }
        }


        return Arrays.stream(f).max().getAsInt();
    }

    /**
     * 本质上是为了解决j回溯到起点的问题
     * 为何命名
     */
    @SuppressWarnings("unused")
    public static int[] getPresuffix(String sequence) {
        final int length = sequence.length();
        int[] next = new int[length];
        Arrays.fill(next, -1);
        for (int i = 1; i < length; i++) {
            int j = next[i - 1];
            while (j != -1 && sequence.charAt(j + 1) != sequence.charAt(i)) {
                j = next[j];
            }
            if (sequence.charAt(j + 1) == sequence.charAt(i)) {
                next[i] = j + 1;
            }
        }
        return next;
    }
}
