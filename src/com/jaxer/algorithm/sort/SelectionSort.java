package com.jaxer.algorithm.sort;

import com.jaxer.algorithm.util.SortUtil;

import java.util.Arrays;

/**
 * 选择排序法
 * 原地排序，不稳定，最好、最坏时间复杂度：O(n^2)
 * 基本不用，不稳
 *
 * @author jiaoxiangru
 * @since 2021/9/11 14:32
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] a = {8, 2, 4, 1, 9, 3, 7, 6, 5};
        System.out.println(Arrays.toString(a));

        sort(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 选择排序
     *
     * @param a 待排序的数组
     */
    public static void sort(int[] a) {
        if (a.length <= 1) return;

        for (int i = 0; i < a.length - 1; i++) {
            // 从未排序区间选出最小值
            int minIdx = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIdx]) {
                    minIdx = j;
                }
            }

            // 交换
            SortUtil.swap(a, i, minIdx);
        }
    }
}
