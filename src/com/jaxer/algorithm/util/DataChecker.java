package com.jaxer.algorithm.util;

import com.jaxer.algorithm.sort.MergeSort;
import com.jaxer.algorithm.sort.simple.InsertionSort;

import java.util.Arrays;
import java.util.Random;

/**
 * 对数器（验证排序算法是否正确）
 *
 * @author jiaoxiangru
 * @since 2021/9/11 17:37
 */
public class DataChecker {
    public static void main(String[] args) {
        boolean checkedResult = check(1000);
        System.out.println("same: " + checkedResult);
    }

    /**
     * 校验排序算法是否正确
     *
     * @param arrLength 生成数组的长度
     * @return 与系统排序算法结果是否一致
     */
    private static boolean check(int arrLength) {
        int[] array = generateRandomArray(arrLength);
        int[] copiedArray = new int[array.length];
        System.arraycopy(array, 0, copiedArray, 0, array.length);

        Arrays.sort(array);
//        BubbleSort.sort01(copiedArray);
//        SelectionSort.sort(copiedArray);
//        InsertionSort.sort(copiedArray);
//        InsertionSort.sort02(copiedArray);
        MergeSort.sort(copiedArray, 0, copiedArray.length - 1);

        boolean same = true;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != copiedArray[i]) {
                same = false;
                break;
            }
        }
        return same;
    }

    /**
     * 生成一个随机数组
     *
     * @param length 给定数组长度
     * @return 生成的数组
     */
    private static int[] generateRandomArray(int length) {
        if (length <= 0) {
            return new int[]{};
        }

        Random random = new Random();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(length);
        }

        return arr;
    }
}
