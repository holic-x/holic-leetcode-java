package com.noob.algorithm.leetcode.q301_400.q337;


import com.noob.algorithm.base.dataStructure.tree.TreeNode;

/**
 * 🟡 337 打家劫舍III - https://leetcode.cn/problems/house-robber-iii/description/
 */
public class Solution3 {

    /**
     * 动态规划思路：对于每个节点都记录偷、不偷的情况下偷窃金额
     * ① 偷 当前节点：则不能偷其子节点，只能偷其子节点的子节点
     * ② 不偷 当前节点：则考虑偷其子节点的方案
     */
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] amount = dfs(root);
        return Math.max(amount[0], amount[1]);
    }

    private int[] dfs(TreeNode node) {
        // 递归出口
        if (node == null) {
            return new int[]{0, 0};
        }
        // 1.dp 定义：dp[0]表示不偷、dp[1]表示偷
        int[] dp = new int[2];

        /**
         * 2.dp 递推：
         * ① 不偷：选择不偷当前节点，判断其左右孩子的情况（左、右孩子各自也可能偷或者不偷）: max{偷左节点，不偷左节点} + max{偷右节点，不偷右节点}
         * ② 偷：选择偷当前节点，则不能偷左右孩子：val(偷当前节点) + 不偷左节点 + 不偷右节点
         */
        int[] left = dfs(node.left); // 左节点的偷盗情况
        int[] right = dfs(node.right); // 右节点的偷盗情况

        // ① 不偷
        int robAmount1 = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        // ② 偷
        int robAmount2 = node.val + left[0] + right[0];

        // 返回偷窃方案
        return new int[]{robAmount1, robAmount2};
    }
}
