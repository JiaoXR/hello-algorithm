package com.jaxer.algorithm.leetcode.linkedlist;

/**
 * 分隔链表：https://leetcode-cn.com/problems/partition-list/
 *
 * @author jiaoxiangru
 * @since 2021/9/24 15:53
 */
public class Solution86 {
    /**
     * 分隔链表
     *
     * @param head 给定链表头
     * @param x    特定值
     * @return 分隔后的链表
     */
    public ListNode partition(ListNode head, int x) {
        // 准备两个链表：一个为小于特定值，一个大于等于特定值
        ListNode sH = null;
        ListNode sT = null;
        ListNode bH = null;
        ListNode bT = null;
        while (head != null) {
            // 摘除当前节点
            ListNode next = head.next;
            head.next = null;
            // 小于特定值的元素放到链表一
            if (head.val < x) {
                if (sH == null) {
                    sH = head;
                } else {
                    sT.next = head;
                }
                sT = head;
            } else {
                // 大于等于特定值的元素放到链表二
                if (bH == null) {
                    bH = head;
                } else {
                    bT.next = head;
                }
                bT = head;
            }
            head = next;
        }
        // 注意判空
        if (sT != null) {
            sT.next = bH;
            return sH;
        }
        return bH;
    }
}
