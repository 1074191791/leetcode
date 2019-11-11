package com.zhou.demo;

import org.junit.Test;

/**
 * @author zhous
 * @create 2019-09-18 19:43
 */
public class Demo27 {

    @Test
    public void test27() {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int count = removeElement(nums, 2);
        System.out.println("==============");
        System.out.println(count);
        System.out.println("==============");
        for (int i = 0; i < count; i++) {
            System.out.println(nums[i]);
        }

    }

    public void test(int[] nums) {
        nums[1] = 9999999;
    }

    public int removeElement(int[] nums, int val) {
        int flag = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (val == nums[i]) {
                continue;
            }
            nums[flag] = nums[i];
            flag++;
        }
        return flag;
    }
}
