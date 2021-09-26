package com.jaxer.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 爬楼梯：https://leetcode-cn.com/problems/climbing-stairs/
 *
 * @author jiaoxiangru
 * @since 2021/9/26 17:48
 */
public class Solution70 {
    private Map<Integer, Integer> map = new HashMap<>();

    /**
     * 递归原始方法改进：缓存已计算的结果
     *
     * @param n 楼梯阶数
     * @return 多少种方法
     */
    public int climbStairs02(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        if (map.containsKey(n)) {
            return map.get(n);
        }

        // 缓存已经计算的结果
        int sum = climbStairs02(n - 1) + climbStairs02(n - 2);
        map.put(n, sum);
        return sum;
    }

    /**
     * 递归原始方法
     * 时间复杂度：2^N, LeetCode不通过
     *
     * @param n 楼梯阶数
     * @return 多少种方法
     */
    public int climbStairs01(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        return climbStairs01(n - 1) + climbStairs01(n - 2);
    }
}
