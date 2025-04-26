package com.noob.algorithm.leetcode.q201_300.q235;


import com.noob.algorithm.base.dataStructure.tree.TreeNode;

/**
 * 🟡 235 二叉搜索树的最近公共祖先 - https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
 */
public class Solution235_02 {

    /**
     * 思路分析：迭代法
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        TreeNode cur = root;
        while (cur != null) {
            // 判断当前节点值与p、q的关系
            int curVal = cur.val;
            if (curVal < p.val && curVal < q.val) {
                // 当前节点均小于p、q的值，则往右子树方向走
                cur = cur.right;
            } else if (curVal > p.val && curVal > q.val) {
                // 当前节点均大于于p、q的值，则往左子树方向走
                cur = cur.left;
            } else {
                return cur; // 找到目标值（满足在指定区间范围）
            }
        }

        // 没有找到目标
        return null;

    }


}
