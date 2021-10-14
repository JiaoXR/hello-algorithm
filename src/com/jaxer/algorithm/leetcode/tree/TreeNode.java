package com.jaxer.algorithm.leetcode.tree;

/**
 * 二叉树节点
 *
 * @author jiaoxiangru
 * @since 2021/9/30 18:39
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
