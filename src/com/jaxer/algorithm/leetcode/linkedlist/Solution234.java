package com.jaxer.algorithm.leetcode.linkedlist;

import java.util.Stack;

/**
 * 回文链表：https://leetcode-cn.com/problems/palindrome-linked-list/solution/
 *
 * @author jiaoxiangru
 * @since 2021/9/24 14:39
 */
public class Solution234 {
    public boolean isPalindrome02(ListNode head) {
        return false;
    }

    /**
     * 判断链表是否回文链表（使用栈）
     *
     * @param head 链表头
     * @return 是否回文链表
     */
    public boolean isPalindrome01(ListNode head) {
        if (head == null || head.next == null) return true;

        // 快慢指针：快指针到末尾时，慢指针到中间
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 后半部分入栈
        Stack<ListNode> stack = new Stack<>();
        while (slow != null) {
            stack.push(slow);
            slow = slow.next;
        }

        // 后半部分倒过来与前半部分逐一比较
        while (!stack.isEmpty()) {
            if (head.val != stack.pop().val) {
                return false;
            }
            head = head.next;
        }

        return true;
    }
}
