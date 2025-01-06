package com.noob.algorithm.base.dataStructure.tree;

// 数据结构定义
/* 二叉树节点类 */
public class TreeNode {
    public int val;         // 节点值
    public TreeNode left;   // 左子节点引用
    public TreeNode right;  // 右子节点引用

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}