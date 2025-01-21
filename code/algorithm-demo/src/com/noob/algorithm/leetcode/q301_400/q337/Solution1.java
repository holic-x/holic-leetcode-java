package com.noob.algorithm.leetcode.q301_400.q337;


import com.noob.algorithm.base.dataStructure.tree.TreeNode;

/**
 * 🟡 337 打家劫舍III - https://leetcode.cn/problems/house-robber-iii/description/
 */
public class Solution1 {
    /**
     * 思路：基于深度优先遍历思路，遍历每个节点，确定偷窃方案
     * ① 偷 当前节点：则不能偷其子节点，只能偷其子节点的子节点
     * ② 不偷 当前节点：则考虑偷其子节点的方案
     */
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // ① 偷当前节点
        int robAmount1 = root.val;
        if (root.left != null) {
            robAmount1 += (rob(root.left.left) + rob(root.left.right));
        }
        if (root.right != null) {
            robAmount1 += (rob(root.right.left) + rob(root.right.right));
        }

        // ② 不偷当前节点
        int robAmount2 = rob(root.left) + rob(root.right);

        // 返回两种盗窃方案的最大值
        return Math.max(robAmount1, robAmount2);
    }
}
