package com.zhou.demo;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author zhous
 * @create 2019-10-16 10:31
 */
public class Demo20 {
    /*
    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

    有效字符串需满足：

    左括号必须用相同类型的右括号闭合。
    左括号必须以正确的顺序闭合。
    注意空字符串可被认为是有效字符串。
     */

    @Test
    public void test() {
        System.out.println(isValid("{([])}"));
    }


    public boolean isValid(String s) {
        Stack stack = new Stack();
        char[] chars = s.toCharArray();
        for(int i =0; i < chars.length; ++i) {
            if(chars[i] == '{' || chars[i] == '[' || chars[i]== '(') {
                //左括号入栈
                stack.push(chars[i]);
            } else {
                //右括号弹栈
                if(stack.empty()) {
                    return false;
                }
                char pop = (Character) stack.pop();
//                System.out.println(pop);
                if((pop == '{' && chars[i] == '}') || (pop == '[' && chars[i] == ']') || (pop == '(' && chars[i] == ')')) {
                    //匹配，不做任何操作，已经弹栈
                } else {
                    return false;
                }
            }
        }

        return stack.size() == 0;
    }

}
