package com.jaxer.algorithm.common;

/**
 * 数组中出现奇偶次数的数字（异或运算）
 *
 * @author jiaoxiangru
 * @since 2021/9/19 21:25
 */
public class EvenTimesOddTimes {
    /**
     * 使用异或计算数组中出现奇数次的数字
     *
     * @param arr 给定数组
     */
    private static void findOddTimesNum(int[] arr) {
        int eor = 0;
        for (int a : arr) {
            eor ^= a;
        }
        System.out.println(eor);
    }

    /**
     * 使用异或统计数组中出现奇数次的两个数字
     *
     * @param arr 给定数组
     */
    private static void findEvenTimesTwoNums(int[] arr) {
        int eor1 = 0;
        for (int a : arr) {
            eor1 ^= a;
        }
        // eor = a ^ b
        // eor != 0
        // eor 必有一个位置为1
        int rightOne = eor1 & (~eor1 + 1); // 提取最右边的1

        int eor2 = 0;
        for (int b : arr) {
            if ((rightOne & b) == 1) {
                eor2 ^= b;
            }
        }
        System.out.println((eor1 ^ eor2) + ", " + eor2);
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 1, 2, 2, 3, 3, 3, 4};
//        findOddTimesNum(a);
        findEvenTimesTwoNums(a);
    }
}
