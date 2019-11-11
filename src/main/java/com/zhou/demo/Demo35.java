package com.zhou.demo;

import org.junit.Test;

/**
 * @author zhous
 * @create 2019-10-28 17:32
 */
public class Demo35 {

    @Test
    public void test() {
        int[] arr = {1, 3, 5, 6};
        int i = searchInsert(arr, 0);
        System.out.println(i);
    }


    public int searchInsert(int[] nums, int target) {
        int flag = 0;
        for(int i = 0; i < nums.length; ++i) {
            if(nums[i] < target) {
                flag++;
            } else {
                break;
            }
        }
        return  flag;
    }

}
