package com.zhou.demo;

import org.junit.Test;

/**
 * @author zhous
 * @create 2019-10-28 15:09
 */
public class Demo28 {

    @Test
    public void test() {
        System.out.println(strStr("hello", ""));
    }

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
