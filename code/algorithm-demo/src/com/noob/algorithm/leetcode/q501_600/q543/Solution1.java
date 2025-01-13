package com.noob.algorithm.leetcode.q501_600.q543;


import com.noob.algorithm.base.dataStructure.tree.TreeNode;

/**
 * 🟢 543.二叉树直径 - https://leetcode.cn/problems/diameter-of-binary-tree/description/
 */
public class Solution1 {

    // 定义直径
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return diameter;
    }

    // 定义计算树的最大深度方法
    public int depth(TreeNode node){
        if(node == null){
            return 0;
        }
        // 计算左子树
        int leftDepth = depth(node.left);
        // 计算右子树深度
        int rightDepth = depth(node.right);
        // 更新最大值(经过当前的最长直径即为左、右子树的深度，在递归求左右子树的深度的同时更新最大执行)
        diameter = Math.max(diameter, leftDepth + rightDepth);
        // 返回子树深度
        return Math.max(leftDepth, rightDepth) + 1;
    }

}
