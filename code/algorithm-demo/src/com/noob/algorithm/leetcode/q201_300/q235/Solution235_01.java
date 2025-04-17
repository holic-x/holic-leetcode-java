package com.noob.algorithm.leetcode.q201_300.q235;


import com.noob.algorithm.base.dataStructure.tree.TreeNode;

/**
 * 🟡 235 二叉搜索树的最近公共祖先 - https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
 */
public class Solution235_01 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p, q);
    }

    /**
     * 思路分析：自顶向下寻找的满足在[pVal,qVal]区间（p、q大小未确定，也可能是[qVal,pVal]）的第1个节点即为公共节点
     */
    private TreeNode dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null || p == node || q == node) {
            return node;
        }

        // 判断节点值和限定区间值的关系
        int nodeVal = node.val,pVal = p.val,qVal = q.val;

        // 寻找在[pVal,qVal]或[qVal,pVal]）的第1个节点
        if ((nodeVal >= pVal && nodeVal <= qVal) || (nodeVal <= pVal && nodeVal >= qVal)) {
            return node;
        } else if (nodeVal < pVal || nodeVal < qVal) {
            // 需要往右递归方能接近区间
            return dfs(node.right, p, q);
        } else if (nodeVal > pVal || nodeVal > qVal) {
            // 需要往左递归方能接近区间
            return dfs(node.left, p, q);
        }
        // 没有找到
        return null;

    }

}
