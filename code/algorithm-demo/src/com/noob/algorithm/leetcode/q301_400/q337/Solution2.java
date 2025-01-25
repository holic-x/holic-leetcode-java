package com.noob.algorithm.leetcode.q301_400.q337;


import com.noob.algorithm.base.dataStructure.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 🟡 337 打家劫舍III - https://leetcode.cn/problems/house-robber-iii/description/
 */
public class Solution2 {

    private Map<TreeNode, Integer> map = new HashMap<>();

    /**
     * 思路：基于深度优先遍历思路，遍历每个节点，确定偷窃方案
     * ① 偷 当前节点：则不能偷其子节点，只能偷其子节点的子节点
     * ② 不偷 当前节点：则考虑偷其子节点的方案
     * 优化：记忆化推导（针对已经遍历过的节点则可以直接返回，而不需要重复计算）
     */
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 如果节点已经计算过则直接返回，不需要重复计算
        if (map.containsKey(root)) {
            return map.get(root);
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

        int maxAmount = Math.max(robAmount1, robAmount2);

        // 记录当前节点
        map.put(root, maxAmount);

        // 返回两种盗窃方案的最大值
        return maxAmount;
    }
}
