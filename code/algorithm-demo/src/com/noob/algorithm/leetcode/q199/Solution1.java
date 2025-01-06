package com.noob.algorithm.leetcode.q199;


import com.noob.algorithm.base.dataStructure.tree.TreeNode;

import java.util.*;

/**
 * 199.二叉树的右视图
 */
public class Solution1 {

    public List<Integer> rightSideView(TreeNode root) {
        // 定义结果集
        List<Integer> res= new ArrayList<>();

        // NULL判断(根节点为null则返回空集合)
        if(root==null){
            return res;
        }

        // 定义辅助队列
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root); // 初始化队列

        // 依次遍历队列
        while (!queue.isEmpty()) {
            // 取节点依次出队（按照分层记录）
            int size = queue.size(); // 存储每层的节点个数
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll(); // 出队（读取节点）
                // 判断当前节点是否为当前层的最后一个节点
                if(i==size-1){
                    res.add(node.val); // 说明是符合右子树视图的条件
                }
                // 将当前节点的左右节点加入列表，等待下次循环
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
        }
        // 返回结果集
        return res;
    }


}


