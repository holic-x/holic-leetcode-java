package com.noob.algorithm.leetcode.q901_q1000.q968;


import com.noob.algorithm.base.dataStructure.tree.TreeNode;

/**
 * 🔴 968 监控二叉树 - https://leetcode.cn/problems/binary-tree-cameras/submissions/592840411/
 */
public class Solution1 {

    public int minCameraCover(TreeNode root) {
        // 调用递归方法获取状态
        int[] arr = dfs(root);
        // 返回最终的b状态即为所得
        return arr[1];
    }


    // 递归处理
    public int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{Integer.MAX_VALUE / 2, 0, 0}; // 除2用于防止加法溢出
        }

        int[] leftArr = dfs(node.left);
        int[] rightArr = dfs(node.right);

        // 分别处理当前节点的3种状态
        int a = leftArr[2] + rightArr[2] + 1;
        int b = Math.min(a, Math.min(leftArr[0] + rightArr[1], leftArr[1] + rightArr[0]));
        int c = Math.min(a, leftArr[1] + rightArr[1]);
        return new int[]{a, b, c};
    }

}
