package com.noob.algorithm.leetcode.q105;


import com.noob.algorithm.leetcode.structure.TreeNode;

/**
 * 105.从前序和中序遍历序列中构造二叉树
 */
public class Solution1 {


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = buildTreeHelper(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
        return root;
    }

    // 前序遍历序列、中序遍历序列、子树的前序左右边界（preLeft、preRight）、子树的中序左右边界（inLeft、inRight）
    public TreeNode buildTreeHelper(int[] preorder, int[] inorder,int preLeft,int preRight,int inLeft,int inRight) {
        // 基于前序遍历序列去构建，借助中序遍历序列确定左子树节点个数,如果左右边界相遇则结束
        if(preLeft>preRight){
            return null;
        }
        // 满足条件则递归构建子树（最终落实到创建节点）
        // 1.确定根节点（前序序列的第一个元素）
        TreeNode root = new TreeNode(preorder[preLeft]);
        // 2.计算左子树的元素长度（leftCount = pivot-inLeft）,其中pivot为根节点在中序遍历序列的下标索引（自定义工具方法获取）
        // int leftCount = getRootIndex(root.val,inorder) - inLeft ;
        int pivot = getRootIndex(root.val,inorder) ; // 如果此处对照图示则an按照图示的参数定义便于理解，避免混淆
        // 3.递归构建左右子树（结合图示设置值即可）
        root.left = buildTreeHelper(preorder,inorder,preLeft+1,preLeft+pivot-inLeft,inLeft,pivot-1);// 对应传入左子树的前序左右边界和中序左右边界
        root.right = buildTreeHelper(preorder,inorder,preLeft+pivot-inLeft+1,preRight,pivot+1,inRight);// 对应传入右子树的前序左右边界和中序左右边界
        // 返回创建的节点信息
        return root;
    }

    /**
     * 根据val值获取其在对应数组的下标位置
     * @param val
     * @return
     */
    private int getRootIndex(int val,int[] inorder){
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==val){
                return i;
            }
        }
        return -1;
    }

}
