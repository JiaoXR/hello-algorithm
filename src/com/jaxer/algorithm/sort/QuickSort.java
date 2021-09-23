package com.jaxer.algorithm.sort;

import com.jaxer.algorithm.util.Common;
import com.jaxer.algorithm.util.SortUtil;

import java.util.Arrays;

/**
 * 快排（荷兰国旗问题）
 *
 * @author jiaoxiangru
 * @since 2021/9/21 18:57
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = Common.defaultArray;
        sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] a, int left, int right) {
        quickSort(a, left, right);
    }

    private static void quickSort(int[] a, int left, int right) {
        if (left < right) {
            // 取数组中随机位置一个元素与末尾元素交换
            SortUtil.swap(a, left + (int) (Math.random() * (right - left + 1)), right);
            int[] partition = partition(a, left, right);
            quickSort(a, left, partition[0] - 1);
            quickSort(a, partition[1] + 1, right);
        }
    }

    /**
     * 数组分区
     *
     * @param a     给定数组
     * @param left  数组左边界
     * @param right 数组右边界
     * @return 分区后的数组
     */
    private static int[] partition(int[] a, int left, int right) {
        // 左右边界
        int less = left - 1;
        int more = right;
        while (left < more) {
            // 该元素小于基准元素，<边界右移，交换数据，当前指针右移
            if (a[left] < a[right]) {
                SortUtil.swap(a, ++less, left++);
                // 该元素大于基准元素，>边界左移，当前指针不移动
            } else if (a[left] > a[right]) {
                SortUtil.swap(a, --more, left);
            } else {
                // 该元素等于基准元素，不移动，当前指针后移
                left++;
            }
        }
        SortUtil.swap(a, more, right);
        return new int[]{less + 1, more};
    }
}
