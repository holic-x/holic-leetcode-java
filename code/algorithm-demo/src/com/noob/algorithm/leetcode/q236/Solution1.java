package com.noob.algorithm.leetcode.q236;


import com.noob.algorithm.base.dataStructure.tree.TreeNode;

/**
 * 🟡 236.二叉树的最近公共祖先 - https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/
 */
public class Solution1 {

    // 递归思路，如果在过程中找到满足条件的直接返回
    public TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
        // 递归退出条件
        if (node == null) {
            return null;
        }

        // 如果当前节点为p或q，则当前节点即为最小公共节点
        if (node == p || node == q) {
            return node;
        }

        // 将找公共路径的任务交给左右子树找
        TreeNode findLeft = lowestCommonAncestor(node.left, p, q);
        TreeNode findRight = lowestCommonAncestor(node.right, p, q);

        // 判断左右子树是否找到,然后分情况讨论
        if (findLeft != null && findRight != null) {
            // 左右子树都找到了，则说明公共节点就是当前节点
            return node;
        }
        if (findLeft != null) {
            // 只有左子树找到了
            return findLeft;
        }
        if (findRight != null) {
            // 只有右子树找到了
            return findRight;
        }

        // 如果左右子树都没有找到
        return null;
    }
}

