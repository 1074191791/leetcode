package com.zhou.demo;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhous
 * @version 1.0
 * @date 2020/8/14 16:25
 */
public class Demo1 {

    @Test
    public void test() {
        int[] nums = { 3,2,4};

        int target = 6;
        int[] ints = this.twoSum(nums, target);
        Arrays.stream(ints).forEach(a-> System.out.println(a));
    }


    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> temp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (temp.containsKey(nums[i])) {
                return new int[]{temp.get(nums[i]), i};
            } else {
                temp.put(target - nums[i], i);
            }
        }
        return null;
    }


    //public int[] twoSum(int[] nums, int target) {
    //    int length = nums.length;
    //    int[] res = new int[2];
    //    for(int i = 0; i < length; ++i) {
    //        int flag = 0;
    //        for(int j = i+1; j < length; ++j) {
    //            if(nums[i] + nums[j] == target) {
    //                res[0] = i;
    //                res[1] = j;
    //                flag++;
    //            }
    //        }
    //        if(flag > 0) {
    //            break;
    //        }
    //    }
    //    return res;
    //}
}
