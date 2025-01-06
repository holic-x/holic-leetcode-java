package com.noob.algorithm.leetcode.q230;


import com.noob.algorithm.base.dataStructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 🟡 230.二叉搜索树中第K小的元素
 * https://leetcode.cn/problems/kth-smallest-element-in-a-bst/description/
 */
public class Solution1 {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = toBFS(root);
        return list.get(k-1);
    }

    // 构建二叉搜索树的中序遍历序列
    public List<Integer> toBFS(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        list = bfs(root,list);
        return list;
    }

    public List<Integer> bfs(TreeNode node,List<Integer> list) {
        // 判断node是否为null(为null不执行任何操作，直接返回)
        if(node == null){
            return list;
        }
        // 中序遍历操作：left->root->right
        bfs(node.left,list); // 左节点
        list.add(node.val);  // root
        bfs(node.right,list);// 右节点
        // 返回列表（遍历序列）
        return list;
    }

}


