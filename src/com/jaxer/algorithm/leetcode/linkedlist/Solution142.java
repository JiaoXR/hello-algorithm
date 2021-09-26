package com.jaxer.algorithm.leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表：https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * 判断链表是否有环，若有环，返回入环节点
 *
 * @author jiaoxiangru
 * @since 2021/9/26 21:25
 */
public class Solution142 {
    /**
     * solution2: 使用有限个变量
     *
     * @param head 给定链表头节点
     * @return 入环节点
     */
    public ListNode detectCycle02(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }

        // 快慢指针判断链表有环
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }

        // 快指针复位到头部，快慢指针同时向后遍历
        fast = head;
        while (slow != null) {
            if (fast == slow) {
                return fast;
            }
            fast = fast.next;
            slow = slow.next;
        }

        return null;
    }

    /**
     * solution1: 使用HashSet
     *
     * @param head 给定链表头节点
     * @return 入环节点
     */
    public ListNode detectCycle01(ListNode head) {
        if (head == null || head.next == null) return null;

        Set<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            if (set.contains(cur)) {
                return cur;
            }
            set.add(cur);
            cur = cur.next;
        }

        return null;
    }
}
