package com.jaxer.algorithm.sort;

import com.jaxer.algorithm.util.Common;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author jiaoxiangru
 * @since 2021/9/20 18:39
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] array = Common.defaultArray;
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] a) {
        process(a, 0, a.length - 1);
    }

    // 归
    private static void process(int[] a, int left, int right) {
        if (left == right) return;

        int mid = left + ((right - left) >> 1);
        process(a, left, mid);
        process(a, mid + 1, right);
        merge(a, left, mid, right);
    }

    // 并
    private static void merge(int[] a, int left, int mid, int right) {
        // 准备临时数组
        int[] temp = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        // 合并左右两个有序数组（类比合并两个链表）
        while (p1 <= mid && p2 <= right) {
            temp[i++] = a[p1] <= a[p2] ? a[p1++] : a[p2++];
        }
        while (p1 <= mid) {
            temp[i++] = a[p1++];
        }
        while (p2 <= right) {
            temp[i++] = a[p2++];
        }
        // 排序后的数据拷贝到原数组
        for (int j = 0; j < temp.length; j++) {
            a[left + j] = temp[j];
        }
//        System.arraycopy(temp, 0, a, left, temp.length);
    }
}
