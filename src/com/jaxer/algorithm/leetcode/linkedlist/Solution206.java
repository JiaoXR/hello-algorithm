package com.jaxer.algorithm.leetcode.linkedlist;

/**
 * 反转链表：https://leetcode-cn.com/problems/reverse-linked-list/
 * 解题思路：https://leetcode-cn.com/problems/reverse-linked-list/solution/shi-pin-jiang-jie-die-dai-he-di-gui-hen-hswxy/
 *
 * @author jiaoxiangru
 * @since 2021/9/15 22:13
 */
public class Solution206 {
    public ListNode reverseList02(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            // 移动指针
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode reverseList01(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}
