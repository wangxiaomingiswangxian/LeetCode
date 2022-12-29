package com.alorithm.normal;

/**
 * @author 王贤
 */
public class NumberReverse {
    public static void main(String[] args) {
        System.out.println(reverse(123));
    }

    /**
     * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
     * <p>
     * 如果反转后整数超过 32 位的有符号整数的范围[−2^31, 2^31− 1] ，就返回 0。
     * <p>
     * 假设环境不允许存储 64 位整数（有符号或无符号）。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/reverse-integer
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int reverse(int x) {
        int res = 0, s;
        while (x != 0) {
            s = x % 10;
            if (res > 214748364 || (res == 214748364 && s > 7)) {
                return 0;
            }
            if (res < -214748364 || (res == -214748364 && s < -8)) {
                return 0;
            }
            res = res * 10 + s;
            x /= 10;
        }
        return res;
    }
}
