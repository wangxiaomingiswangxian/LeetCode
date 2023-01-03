package com.alorithm.easy;

/**
 * @author 王贤
 */
public class CountOdds {
    public static void main(String[] args) {
        final CountOdds countOdds = new CountOdds();
        System.out.println(countOdds.countOdds(0,0));
    }

    /**
     *给你两个非负整数 low 和 high 。请你返回 low 和 high 之间（包括二者）奇数的数目。
     */
//    public int countOdds(int low, int high) {
//        if ((low&1) ==1){
//            low--;
//        }
//        if ((high&1) ==1){
//            high++;
//        }
//        return (high-low)/2;
//    }

    public int countOdds(int low, int high) {
        return pre(high) - pre(low - 1);
    }

    public int pre(int x) {
        return (x + 1) >> 1;
    }
}
