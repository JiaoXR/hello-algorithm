package com.jaxer.algorithm.common;

import com.jaxer.algorithm.util.Common;

/**
 * 获取数组最大值
 *
 * @author jiaoxiangru
 * @since 2021/9/20 17:08
 */
public class MaxNum {
    public static void main(String[] args) {
        int[] array = Common.defaultArray;
        int max = getMax(array, 0, array.length - 1);
        System.out.println(max);
    }

    /**
     * 递归查找数组中的最大值
     * 使用位运算目的：
     * 1.效率较高
     * 2.防止极端情况下溢出（数组太长）
     *
     * @param a     给定数组
     * @param left  数组左边界
     * @param right 数组右边界
     * @return 数组最大值
     */
    private static int getMax(int[] a, int left, int right) {
        if (left == right) {
            return a[left];
        }

        // 位运算获取下标中间值
        int mid = left + ((right - left) >> 1);
        int leftMax = getMax(a, left, mid);
        int rightMax = getMax(a, mid + 1, right);
        return Math.max(leftMax, rightMax);
    }
}
