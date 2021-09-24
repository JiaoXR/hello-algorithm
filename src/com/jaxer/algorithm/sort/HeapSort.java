package com.jaxer.algorithm.sort;

import com.jaxer.algorithm.util.Common;
import com.jaxer.algorithm.util.SortUtil;

import java.util.Arrays;

/**
 * 堆排序
 * 时间复杂度：O(NlogN)
 * 空间复杂度：O(1)
 *
 * @author jiaoxiangru
 * @since 2021/9/22 15:23
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] array = Common.defaultArray;
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 堆排序
     *
     * @param a 待排序数组
     */
    public static void sort(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }
        // 将数组转为大顶堆
        for (int i = 0; i < a.length; i++) { // O(N)
            heapInsert(a, i); // O(logN)
        }
        // 该方式比上面的for循环更快一点
//        for (int i = a.length; i >= 0; i--) {
//            heapify(a, i, a.length);
//        }
        int heapSize = a.length;
        SortUtil.swap(a, 0, --heapSize);
        while (heapSize > 0) { // O(N)
            heapify(a, 0, heapSize); // O(logN)
            SortUtil.swap(a, 0, --heapSize);
        }
    }

    /**
     * 将数组中的给定元素转为（大顶/大根）堆
     * 某个数现在处于index位置，能否向下移动
     *
     * @param a        给定数组
     * @param index    给定下标
     * @param heapSize 堆的大小
     */
    private static void heapify(int[] a, int index, int heapSize) {
        // index的左子节点下标
        int left = index * 2 + 1;
        while (left < heapSize) {
            // 找到左右子节点中较大的一个的下标
            int larger = (left + 1 < heapSize && a[left + 1] > a[left])
                    ? left + 1
                    : left;

            // 较大的子节点小于当前节点，不换位置
            if (a[index] > a[larger]) {
                break;
            }

            // 互换当前元素与较大子节点
            SortUtil.swap(a, larger, index);
            // 轮询子节点
            index = larger;
            left = index * 2 + 1;
        }
    }

    /**
     * 将数组转为（大顶/大根）堆格式
     * 某个数现在处于index位置，向上继续移动
     *
     * @param a     给定数组
     * @param index 起始位置坐标
     */
    private static void heapInsert(int[] a, int index) {
        // 某个节点元素大于其父节点，互换
        while (a[index] > a[(index - 1) / 2]) {
            SortUtil.swap(a, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    // 可能会数组越界（-1 >> 1 == -1）
//    private static void heapInsert(int[] a, int index) {
//        while (a[index] > a[(index - 1) >> 1]) {
//            SortUtil.swap(a, index, (index - 1) >> 1);
//            index = (index - 1) >> 1;
//        }
//    }
}
