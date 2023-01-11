package com.alorithm.easy;

import java.util.*;

/**
 * 有效的括号
 *
 * @author 王贤
 */
public class ValidParenthesis {
    public static void main(String[] args) {
        final ValidParenthesis validParenthesis = new ValidParenthesis();
        System.out.println(validParenthesis.isValid("(({}))"));
        System.out.println(validParenthesis.isValid("{(})"));
        System.out.println(validParenthesis.isValid("[](){}"));
        System.out.println(validParenthesis.isValid("{[]}"));
    }


    public boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<Character,Character>(4,1){
            {
                put('}','{');
                put(']','[');
                put(')','(');
            }
        };
        Deque<Character> stack = new LinkedList<>();
        final char[] chars = s.toCharArray();
        for (char aChar : chars) {
           if (map.containsKey(aChar)){
               if (stack.isEmpty() || !stack.peek().equals(map.get(aChar))){
                   return false;
               }
               stack.pop();
           }else {
               stack.push(aChar);
           }
        }
        return stack.isEmpty();
    }
}
