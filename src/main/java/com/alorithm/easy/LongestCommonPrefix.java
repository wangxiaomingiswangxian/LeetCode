package com.alorithm.easy;

/**
 * @author 王贤
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }


    public static String longestCommonPrefix(String[] strs) {
        final StringBuilder stringBuilder = new StringBuilder();
        String s = strs[0];

        for (int i = 0; i < s.length(); i++) {
            boolean flag=true;
            for (String str : strs) {
                if ( str.length()<i+1||str.charAt(i)!=s.charAt(i)){
                    flag=false;
                    break;
                }
            }
            if (!flag){
                break;
            }
            stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString();
    }

}
