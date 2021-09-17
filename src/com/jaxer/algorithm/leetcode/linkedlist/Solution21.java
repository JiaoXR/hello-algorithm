package com.jaxer.algorithm.leetcode.linkedlist;

/**
 * 合并两个有序链表：https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * @author jiaoxiangru
 * @since 2021/9/16 22:08
 */
public class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode();
        ListNode curr = newHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        // 一个链表已经为空，合并另一个链表的剩余部分
        if (l1 != null) {
            curr.next = l1;
        }
        if (l2 != null) {
            curr.next = l2;
        }

        return newHead.next;
    }
}
