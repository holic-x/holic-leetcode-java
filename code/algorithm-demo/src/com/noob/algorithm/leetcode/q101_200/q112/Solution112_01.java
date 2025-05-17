package com.noob.algorithm.leetcode.q101_200.q112;


import com.noob.algorithm.base.dataStructure.tree.TreeNode;

/**
 * 🟢 112 路径总和 - https://leetcode.cn/problems/path-sum/
 */
public class Solution112_01 {

    /**
     * 思路分析：
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, 0, targetSum);
    }

    // 递归遍历节点
    private boolean dfs(TreeNode node, int curPathSum, int targetSum) {
        if (node == null) {
            return false;
        }

        // 处理当前节点
        curPathSum += node.val;

        // 如果是叶子节点，则判断当前路径值
        if (node.left == null && node.right == null) {
            if (curPathSum == targetSum) {
                return true;
            }
        }

        // 处理左节点
        boolean left = dfs(node.left, curPathSum, targetSum);

        // 处理右节点
        boolean right = dfs(node.right, curPathSum, targetSum);

        return left || right;
    }

}
