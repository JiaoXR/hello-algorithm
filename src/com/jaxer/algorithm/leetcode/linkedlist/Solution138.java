package com.jaxer.algorithm.leetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * 复制带随机指针的链表：https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 *
 * @author jiaoxiangru
 * @since 2021/9/24 17:22
 */
public class Solution138 {
    /**
     * 复制带随机指针的链表
     *
     * @param head 待复制链表头部
     * @return 深拷贝的链表
     */
    public Node copyRandomList02(Node head) {
        if (head == null) return null;

        // 原链表每个节点后增加copy节点
        Node cur = head;
        Node next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = next;
            cur = next;
        }

        // 处理copy链表的random指针
        // 1 -> 1' -> 2 -> 2'
        cur = head;
        Node curCopy = null;
        while (cur != null) {
            curCopy = cur.next;
            curCopy.random = cur.random != null ? cur.random.next : null;
            cur = cur.next.next;
        }

        // 分离新老链表
        cur = head;
        Node res = cur.next;
        while (cur != null) {
            next = cur.next.next; // 原链表下一个节点
            curCopy = cur.next;
            curCopy.next = next != null ? next.next : null;
            cur.next = next; // 恢复原链表
            cur = next;
        }

        return res;
    }

    /**
     * 复制带随机指针的链表（使用HashMap）
     *
     * @param head 待复制链表头部
     * @return 深拷贝的链表
     */
    public Node copyRandomList01(Node head) {
        if (head == null) return null;

        Map<Node, Node> map = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }
}
