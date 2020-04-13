package com.zhou.demo;

import org.junit.Test;

public class Demo58 {

    @Test
    public void test() {
        System.out.println(lengthOfLastWord("a  "));
    }

    public int lengthOfLastWord(String s) {
        if(s.trim().length() == 0) return 0;
        String[] s1 = s.split(" ");
        return s1[s1.length-1].trim().length();
    }
}
