package com.jaxer.algorithm.leetcode.linkedlist;

/**
 * 相交链表：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 *
 * @author jiaoxiangru
 * @since 2021/9/26 22:57
 */
public class Solution160 {
    /**
     * 两个链表若相交，返回相交的第一个节点
     *
     * @param headA 链表1
     * @param headB 链表2
     * @return 相交的第一个结点
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        // 两个指针走完两个链表
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA != null ? pA.next : headB;
            pB = pB != null ? pB.next : headA;
        }
        return pA;
    }

}
