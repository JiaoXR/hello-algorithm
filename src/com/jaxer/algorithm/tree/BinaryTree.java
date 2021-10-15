package com.jaxer.algorithm.tree;

import com.jaxer.algorithm.leetcode.tree.TreeNode;

import java.util.*;

/**
 * 二叉树遍历
 *
 * @author jiaoxiangru
 * @since 2021/9/30 18:40
 */
public class BinaryTree {
    public static void main(String[] args) {
        TreeNode root = buildTree();

        levelOrder(root);

//        preOrderRecur(root);
//        System.out.println();
//        preOrderUnRecur(root);

//        inOrderRecur(root);
//        System.out.println();
//        inOrderUnRecur(root);

//        postOrderRecur(root);
//        System.out.println();
//        postOrderUnRecur(root);
    }

    /**
     * 二叉树按层遍历
     *
     * @param root 二叉树头节点
     */
    private static void levelOrder(TreeNode root) {
        if (root == null) return;

        List<Integer> list = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            list.add(root.val);
            if (root.left != null) {
                queue.add(root.left);
            }
            if (root.right != null) {
                queue.add(root.right);
            }
        }

        System.out.println(list);
    }

    /**
     * 前序遍历（递归）
     *
     * @param head 二叉树头节点
     */
    private static void preOrderRecur(TreeNode head) {
        if (head == null) return;

        System.out.print(head.val + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    /**
     * 前序遍历（非递归）
     *
     * @param head 二叉树头节点
     */
    private static void preOrderUnRecur(TreeNode head) {
        if (head == null) return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);

        while (!stack.isEmpty()) {
            head = stack.pop();
            System.out.print(head.val + " ");
            if (head.right != null) {
                stack.push(head.right);
            }
            if (head.left != null) {
                stack.push(head.left);
            }
        }

        System.out.println();
    }

    /**
     * 中序遍历（递归）
     *
     * @param head 二叉树头节点
     */
    private static void inOrderRecur(TreeNode head) {
        if (head == null) return;

        inOrderRecur(head.left);
        System.out.print(head.val + " ");
        inOrderRecur(head.right);
    }

    /**
     * 中序遍历（非递归）
     *
     * @param head 二叉树头节点
     */
    private static void inOrderUnRecur(TreeNode head) {
        if (head == null) return;

        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.print(head.val + " ");
                head = head.right;
            }
        }

        System.out.println();
    }

    /**
     * 后序遍历（递归）
     *
     * @param head 二叉树头节点
     */
    private static void postOrderRecur(TreeNode head) {
        if (head == null) return;

        postOrderRecur(head.left);
        postOrderRecur(head.right);
        System.out.print(head.val + " ");
    }

    /**
     * 后序遍历（非递归）
     *
     * @param head 二叉树头节点
     */
    private static void postOrderUnRecur(TreeNode head) {
        if (head == null) return;

        Stack<TreeNode> stack1 = new Stack<>();
        stack1.push(head);
        Stack<TreeNode> stack2 = new Stack<>();
        while (!stack1.isEmpty()) {
            head = stack1.pop();
            stack2.push(head);
            if (head.left != null) {
                stack1.push(head.left);
            }
            if (head.right != null) {
                stack1.push(head.right);
            }
        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().val + " ");
        }
    }

    /**
     * 构造一个二叉树
     *
     * @return 二叉树
     */
    private static TreeNode buildTree() {
        TreeNode node = new TreeNode(1);

        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);

        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);

        return node;
    }
}
