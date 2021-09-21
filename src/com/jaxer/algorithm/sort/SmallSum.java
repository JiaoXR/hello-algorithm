package com.jaxer.algorithm.sort;

/**
 * 求解数组小和问题（归并排序扩展）
 *
 * @author jiaoxiangru
 * @since 2021/9/21 16:05
 */
public class SmallSum {
    public static void main(String[] args) {
        int[] a = {1, 3, 4, 2, 5};
        System.out.println(process(a, 0, a.length - 1));
    }

    private static int process(int[] a, int left, int right) {
        if (left == right) return 0;

        int mid = left + ((right - left) >> 1);
        return process(a, left, mid) + process(a, mid + 1, right) + merge(a, left, mid, right);
    }

    private static int merge(int[] a, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = 0;
        int sum = 0;
        int p1 = left;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= right) {
            sum += a[p1] < a[p2] ? a[p1] * (right - p2 + 1) : 0;
            temp[i++] = a[p1] < a[p2] ? a[p1++] : a[p2++];
        }
        while (p1 <= mid) {
            temp[i++] = a[p1++];
        }
        while (p2 <= right) {
            temp[i++] = a[p2++];
        }

        for (int j = 0; j < temp.length; j++) {
            a[left + j] = temp[j];
        }

        return sum;
    }
}
