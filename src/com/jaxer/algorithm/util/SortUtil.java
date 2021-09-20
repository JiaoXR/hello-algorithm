package com.jaxer.algorithm.util;

/**
 * 排序常用工具类
 *
 * @author jiaoxiangru
 * @since 2021/9/11 16:14
 */
public class SortUtil {
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

    /**
     * 交换数组中的两个元素（异或运算）
     * 注意：i 和 j 是同一个位置的话会出错
     * <p>
     * 位运算性质：
     * 0 ^ N == N
     * N ^ N == 0
     *
     * @param arr 给定数组
     * @param i   下标i
     * @param j   下标j
     */
    public static void swap02(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
