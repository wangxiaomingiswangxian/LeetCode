package com.alorithm.easy;

/**
 * @author 王贤
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        System.out.println(solution.isPalindrome(0));
    }

    /**
     * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
     *
     * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     *
     * 例如，121 是回文，而 123 不是。
     *
     * 来源：力扣（LeetCode）
     * 链接：<a href="https://leetcode.cn/problems/palindrome-number" \a>
     *
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    static class Solution{

        @SuppressWarnings("all")
        public boolean isPalindrome(int x) {
            int res=0;
            if (x<0||(x%10 ==0 &&x!=0)){
                return false;
            }
            while (x> res){
                res = res*10+x%10;
                x /=10;
            }
            return x==res|| x==res/10;
        }
    }
}
