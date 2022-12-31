package com.alorithm.normal;

/**
 * @author 王贤
 */
public class IntToRoman {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        System.out.println(solution.intToRoman(3));
        System.out.println(solution.intToRoman(4));
        System.out.println(solution.intToRoman(9));
        System.out.println(solution.intToRoman(1994));
        System.out.println(solution.intToRoman(58));
        System.out.println(solution.intToRoman(8));
    }


}



class Solution {
    public String intToRoman(int num) {
        int n= num/ 1000;
        int h = (num%1000)/100;
        int d = ((num%100))/10;
                int one =num%10;
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(get(n,"M","",""))
                .append(get(h,"C","D","M"))
                .append(get(d,"X","L","C"))
                .append(get(one,"I","V","X"));

        return stringBuilder.toString();
    }

    public String get(int x,String one,String five,String ten){
        if (x<4){
            final StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < x; i++) {
                stringBuilder.append(one);
            }
            return stringBuilder.toString();
        } else if (x>5&&x!=9) {
            final StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(five);
            for (int i = 6; i <= x; i++) {
                stringBuilder.append(one);
            }
            return stringBuilder.toString();
        }else if (x == 4){
            return one+five;
        } else if (x == 9) {
            return one + ten;
        } else {
            return five;
        }
    }
}