package com.zhou.demo;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author zhous
 * @create 2019-10-28 14:01
 */
public class Demo26 {

    @Test
    public void test() {
        int[] ar = {-3,-1,0,0,0,3,3};
        int i = removeDuplicates(ar);
        System.out.println(i);
    }


    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new TreeSet<Integer>();
        for(int i = 0; i < nums.length; ++i) {
            set.add(nums[i]);
        }
        Object[] obj = set.toArray();
        for(int i = 0; i < obj.length; ++i) {
            nums[i] = (Integer)obj[i];
        }
        return obj.length;
    }

}
