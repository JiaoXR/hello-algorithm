package com.jaxer.algorithm.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的前序遍历：https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 *
 * @author jiaoxiangru
 * @since 2021/10/14 18:03
 */
public class Solution144 {
    /**
     * solution2：遍历
     */
    public List<Integer> preorderTraversal02(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }

        return list;
    }

    /**
     * solution1：递归
     */
    public List<Integer> preorderTraversal01(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recursive(root, list);
        return list;
    }

    private void recursive(TreeNode root, List<Integer> list) {
        if (root == null) return;

        list.add(root.val);

        recursive(root.left, list);
        recursive(root.right, list);
    }
}
