package com.jaxer.algorithm.util;

/**
 * 排序常用工具类
 *
 * @author jiaoxiangru
 * @since 2021/9/11 16:14
 */
public class SortUtil {
    public static int[] array = {8, 2, 4, 1, 9, 3, 7, 6, 5};

    /**
     * 交换数组中的两个元素
     *
     * @param arr 给定数组
     * @param i   下标i
     * @param j   下标j
     */
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
