package com.alorithm.easy;

import java.util.Map;

/**
 * @author 王贤
 */
public class RomanToInt {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        System.out.println(solution.romanToInt("III"));
        System.out.println(solution.romanToInt("IV"));
        System.out.println(solution.romanToInt("IX"));
        System.out.println(solution.romanToInt("MCMXCIV"));
    }
}
class Solution {
    private static final int[] A ={1000,900,500,400,100,90,50,40,10,9,5,4,1};
    private static final String[] B={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    public int romanToInt(String s) {
        int res =0;
        for (int i = 0; i < B.length; i++) {
            String com = B[i];
            while (s.startsWith(com)){
                s = s.replaceFirst(com,"");
                res += A[i];
            }
        }

        return res;

    }
}