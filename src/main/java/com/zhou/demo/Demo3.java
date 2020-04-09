package com.zhou.demo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo3 {


    @Test
    public void Test11() {
        String str = "loddktdji";
        int i = lengthOfLongestSubstring(str);
        System.out.println(i);
    }

    public int lengthOfLongestSubstring(String s) {
        //滑动窗口
        int max = 0;
        List<Character> list = new ArrayList<Character>();
        for (int i = 0; i < s.length(); ++i) {
            if (!list.contains(s.charAt(i))) {
                list.add(s.charAt(i));
                int a = list.size();
                if(max < a) {
                    max = a;
                }
            } else {
                int begin = list.indexOf(s.charAt(i));
                list.subList(0,begin+1).clear();
                list.add(s.charAt(i));
            }
        }
        return max;
    }
}
