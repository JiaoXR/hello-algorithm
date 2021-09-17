package com.jaxer.algorithm.leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表：https://leetcode-cn.com/problems/linked-list-cycle/
 * 判断给定链表是否有环
 *
 * @author jiaoxiangru
 * @since 2021/9/17 21:54
 */
public class Solution141 {
    /**
     * solution2：快慢指针
     *
     * @param head 给定链表头
     * @return 是否有环
     */
    public boolean hasCycle02(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * solution1：遍历，使用Set
     *
     * @param head 给定链表头
     * @return 是否有环
     */
    public boolean hasCycle01(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        Set<ListNode> set = new HashSet<>();
        while (head.next != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }
}
