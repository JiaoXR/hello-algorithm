package com.jaxer.algorithm.leetcode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层序遍历：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * 解题思路：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/bfs-de-shi-yong-chang-jing-zong-jie-ceng-xu-bian-l/
 *
 * @author jiaoxiangru
 * @since 2021/10/15 11:15
 */
public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            // 收集每一层的节点
            int size = q.size();
            for (int i = 0; i < size; i++) {
                root = q.poll();
                level.add(root.val);
                if (root.left != null) {
                    q.add(root.left);
                }
                if (root.right != null) {
                    q.add(root.right);
                }
            }
            result.add(level);
        }
        return result;
    }
}
