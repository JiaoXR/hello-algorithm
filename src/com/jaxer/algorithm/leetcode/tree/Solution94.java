package com.jaxer.algorithm.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历：https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 *
 * @author jiaoxiangru
 * @since 2021/10/14 18:07
 */
public class Solution94 {
    /**
     * solution2：遍历
     */
    public List<Integer> inorderTraversal02(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }

        return list;
    }

    /**
     * solution1：递归
     */
    public List<Integer> inorderTraversal01(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;

        inorder(root.left, list);
        list.add(root.val);

        inorder(root.right, list);
    }
}
