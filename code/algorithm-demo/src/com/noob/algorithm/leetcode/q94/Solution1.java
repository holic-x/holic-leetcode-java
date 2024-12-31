package com.noob.algorithm.leetcode.q94;


import com.noob.algorithm.leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历（递归法）
 */
public class Solution1
{

    /**
     * 二叉树的中序遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // 定义集合存储遍历序列
        List<Integer> list = new ArrayList<Integer>();
        list = inorderHelper(root,list);
        return list;

    }

    /**
     * 定义中序遍历辅助方法
     */
    public List<Integer> inorderHelper(TreeNode root,List<Integer> list){
        // 定义节点指针
        TreeNode cur = root;
        // 判断是否为null（不为null则继续遍历子节点）
        if (cur != null) {
            // 中序遍历次序：left->root->right
            inorderHelper(cur.left,list);
            list.add(cur.val); // 遍历节点（将节点值加入列表）
            inorderHelper(cur.right,list);
        }
        // 返回遍历后的序列
        return list;
    }

}
