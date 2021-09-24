package com.jaxer.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和：https://leetcode-cn.com/problems/two-sum/
 *
 * @author jiaoxiangru
 * @since 2021/9/24 10:47
 */
public class Solution01 {
    /**
     * solution2: 使用Map优化
     *
     * @param nums   给定数组
     * @param target 目标和
     * @return 满足条件的两数下标
     */
    public int[] twoSum02(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            // 注意不能是同一个数
            if (map.containsKey(diff) && map.get(diff) != i) {
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    /**
     * solution1: 暴力法
     *
     * @param nums   给定数组
     * @param target 目标和
     * @return 满足条件的两数下标
     */
    public int[] twoSum01(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
