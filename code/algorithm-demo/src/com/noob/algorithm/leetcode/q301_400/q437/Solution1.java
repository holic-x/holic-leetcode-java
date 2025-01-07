package com.noob.algorithm.leetcode.q301_400.q437;


import com.noob.algorithm.base.dataStructure.tree.TreeNode;

/**
 * 🟡 437.路径总和III - https://leetcode.cn/problems/path-sum-iii/description/
 */
public class Solution1 {

    /**
     * 思路：双递归思路
     */
    public int pathSum(TreeNode root, int targetSum) {
        // 1.穷举法概念：将当前节点的可能路径拆分为三部分进行计算：当前节点的路径穷举+左子树的路径穷举+右子树的路径穷举
        if (root == null) {
            return 0;
        }
        int res = 0;
        int cur = rootSum(root, targetSum);
        int left = pathSum(root.left, targetSum);
        int right = pathSum(root.right, targetSum);
        res += cur + left + right;
        return res;
    }

    private int rootSum(TreeNode node, int targetSum) {
        int res = 0;

        if (node == null) {
            return 0;
        }

        int val = node.val;
        // 特殊情况考虑（如果当前节点值等于targetSum，则其本身就是一条满足条件的路径）
        if (val == targetSum) {
            res++;
        }

        // 递归计算左右子树
        res += rootSum(node.left, targetSum - val) + rootSum(node.right, targetSum - val);// 此处设定target-val，表示向下传递的子树需要满足的路径和

        // 返回结果
        return res;
    }


}

