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


    /**
     * 你有一个炸弹需要拆除，时间紧迫！你的情报员会给你一个长度为 n 的 循环 数组 code 以及一个密钥 k 。
     *
     * 为了获得正确的密码，你需要替换掉每一个数字。所有数字会 同时 被替换。
     *
     * 如果 k > 0 ，将第 i 个数字用 接下来 k 个数字之和替换。
     * 如果 k < 0 ，将第 i 个数字用 之前 k 个数字之和替换。
     * 如果 k == 0 ，将第 i 个数字用 0 替换。
     * 由于 code 是循环的， code[n-1] 下一个元素是 code[0] ，且 code[0] 前一个元素是 code[n-1] 。
     *
     * 给你 循环 数组 code 和整数密钥 k ，请你返回解密后的结果来拆除炸弹！
     *
     * 来源：力扣（LeetCode）
     * 链接：@link{<a href="https://leetcode.cn/problems/defuse-the-bomb">...</a>}
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @示例
     * 输入：code = [5,7,1,4], k = 3
     * 输出：[12,10,16,13]
     * 解释：每个数字都被接下来 3 个数字之和替换。解密后的密码为 [7+1+4, 1+4+5, 4+5+7, 5+7+1]。注意到数组是循环连接的。
     *
     */
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
