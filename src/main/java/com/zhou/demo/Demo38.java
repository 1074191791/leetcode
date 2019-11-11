package com.zhou.demo;

import org.junit.Test;

/**
 * @author zhous
 * @create 2019-10-28 17:45
 */
public class Demo38 {

    @Test
    public void test(){
        System.out.println(countAndSay(2));
    }

    public String countAndSay(int n) {
        StringBuilder sbf = new StringBuilder();
        for (int i= 1; i <= n; ++i) {
            int count = 0;
            sbf.append(i);
        }
        return sbf.toString();
    }
}
