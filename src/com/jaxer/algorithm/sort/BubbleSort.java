package com.jaxer.algorithm.sort;

import com.jaxer.algorithm.util.SortUtil;

import java.util.Arrays;

/**
 * 冒泡排序
 * 原地排序，稳定，最好：O(n)、最坏：O(n^2)
 * 基本不用，太慢
 *
 * @author jiaoxiangru
 * @since 2021/9/10 22:44
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] a = SortUtil.array;
        System.out.println(Arrays.toString(a));

        sort02(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 冒泡排序（优化版）
     *
     * @param a 待排序的数组
     */
    public static void sort02(int[] a) {
        if (a.length <= 1) return;

        for (int i = 0; i < a.length; i++) {
            // 提前退出循环的标志位
            boolean flag = false;
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    SortUtil.swap(a, i, j);
                    flag = true;
                }
            }
            if (!flag) break;
        }
    }

    /**
     * 冒泡排序（原始版）
     *
     * @param a 待排序的数组
     */
    public static void sort01(int[] a) {
        if (a.length <= 1) return;

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    SortUtil.swap(a, i, j);
                }
            }
        }
    }
}
