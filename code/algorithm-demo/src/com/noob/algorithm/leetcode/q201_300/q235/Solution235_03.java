package com.noob.algorithm.leetcode.q201_300.q235;


import com.noob.algorithm.base.dataStructure.tree.TreeNode;

/**
 * 🟡 235 二叉搜索树的最近公共祖先 - https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
 */
public class Solution235_03 {

    /**
     * 思路分析：通用解法（递归遍历校验每个节点，判断是不是最近公共祖先）
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root,p,q);
    }

    public TreeNode dfs(TreeNode node, TreeNode p, TreeNode q) {
        // 递归出口
        if (node == null || node == p || node == q) {
            return node;
        }

        // 其他情况，递归从左右子树找
        TreeNode findLeft = dfs(node.left, p, q);
        TreeNode findRight = dfs(node.right, p, q);

        // 根据左右子树的查找情况分情况讨论
        if (findLeft == null && findRight == null) {
            return null; // 左右子树都没找到
        }

        // 左右子树中只有一个找到，返回找到的那个子树
        if ((findLeft == null && findRight != null) || (findLeft != null && findRight == null)) {
            return findLeft != null ? findLeft : findRight;
        }

        // 左右子树都找到，则返回当前节点
        return node;
    }

}
