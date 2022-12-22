package com.alorithm.easy;

import java.util.Arrays;

/**
 * 拆炸弹
 *
 * @author 王贤
 */
public class BombDisposal {


    public static void main(String[] args) {
        int[] a = {5,7,1,4};
        int[] b = {1,2,3,4};
        int[] c = {2,4,9,3};
        System.out.println(Arrays.toString(new Solution().decrypt(a, 3)));
        System.out.println(Arrays.toString(new Solution().decrypt(b, 0)));
        System.out.println(Arrays.toString(new Solution().decrypt(c, -2)));
    }


    static class Solution {
        public int[] decrypt(int[] code, int k) {
            final int length = code.length;
            int[] result = new int[length];
            if (k > 0) {
                for (int i = 0; i < length; i++) {
                    int sum = 0;
                    for (int j = 1; j <= k; j++) {
                        if (i + j < length) {
                            sum += code[i + j];
                        } else {
                            sum += code[i + j - length];
                        }
                    }
                    result[i] = sum;

                }

            } else if (k < 0) {
                for (int i = 0; i < length; i++) {
                    int sum = 0;
                    for (int j = -1; j >= k; j--) {
                        if (i + j < 0) {
                            sum += code[length+i+j];
                        } else {
                            sum += code[i + j];
                        }
                    }
                    result[i] = sum;

                }
            } else {
                Arrays.fill(result, 0);
            }
            return result;
        }
    }
}
