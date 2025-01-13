package com.noob.algorithm.leetcode.q101_200.q124;


import com.noob.algorithm.base.dataStructure.tree.TreeNode;

/**
 * 🔴 124 二叉树中的最大路径和
 */
public class Solution1 {

    public int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        // 调用递归方法
        dfs(root);
        // 返回结果
        return maxSum;
    }

    // 递归处理（dfs返回的是链的节点值之和，而不是直径的节点值之和）
    private int dfs(TreeNode node) {
        if (node == null) {
            return 0; // 没有节点，和为0
        }

        // 计算左子树的最大链和
        int L = dfs(node.left);

        // 计算右子树的最大链和
        int R = dfs(node.right);

        // 两条链拼成路径
        maxSum = Math.max(maxSum, L + R + node.val);

        // 返回当前子树最大链和，向上层调用返回（如果必须选当前节点）的一定是当前节点+max(左树,右树),不然上一级就无法连城一条线了
        return Math.max(Math.max(L, R) + node.val, 0);

    }
}
