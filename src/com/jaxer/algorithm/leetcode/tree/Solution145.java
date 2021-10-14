package com.jaxer.algorithm.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的后序遍历：https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 *
 * @author jiaoxiangru
 * @since 2021/10/14 21:25
 */
public class Solution145 {
    /**
     * solution2：遍历
     */
    public List<Integer> postorderTraversal02(TreeNode root) {
        if (root == null) return new ArrayList<>();

        Stack<TreeNode> s1 = new Stack<>();
        s1.push(root);
        Stack<TreeNode> s2 = new Stack<>();
        while (!s1.isEmpty()) {
            root = s1.pop();
            s2.push(root);
            if (root.left != null) {
                s1.push(root.left);
            }
            if (root.right != null) {
                s1.push(root.right);
            }
        }

        List<Integer> list = new ArrayList<>();
        while (!s2.isEmpty()) {
            list.add(s2.pop().val);
        }
        return list;
    }

    /**
     * solution1：递归
     */
    public List<Integer> postorderTraversal01(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recursive(root, list);
        return list;
    }

    public void recursive(TreeNode root, List<Integer> list) {
        if (root == null) return;

        recursive(root.left, list);
        recursive(root.right, list);
        list.add(root.val);
    }
}
