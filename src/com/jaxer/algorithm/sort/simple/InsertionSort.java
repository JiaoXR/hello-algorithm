package com.jaxer.algorithm.sort.simple;

import com.jaxer.algorithm.util.Common;
import com.jaxer.algorithm.util.SortUtil;

import java.util.Arrays;

/**
 * 插入排序
 * 原地排序，稳定，最好：O(n)、最坏：O(n^2)
 * 样本小&基本有序时效率较高
 *
 * @author jiaoxiangru
 * @since 2021/9/11 11:06
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] array = Common.defaultArray;
        System.out.println(Arrays.toString(array));

        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort02(int[] a) {
        if (a.length <= 1) return;

        for (int i = 1; i < a.length; i++) {
            for (int j = i - 1; j >= 0 && a[j] > a[j + 1]; j--) {
                SortUtil.swap(a, j, j + 1);
            }
        }
    }

    public static void sort(int[] a) {
        if (a.length <= 1) return;

        for (int i = 1; i < a.length; i++) {
            int val = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (a[j] > val) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = val;
        }
    }
}
