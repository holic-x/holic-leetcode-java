package com.noob.algorithm.leetcode.q102;


import com.noob.algorithm.leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 102.二叉树的层次遍历
 */
public class Solution1 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        // 定义结果集
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if (root == null) {
            return new ArrayList<>();
        }

        // 定义队列进行辅助操作
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root); // 初始化队列

        // 当队列不为空则迭代队列
        while (!queue.isEmpty()) {
            // 记录当前队列节点（分层遍历）
            int n = queue.size();
            List<Integer> curList = new ArrayList<>();
            while (n > 0) {
                // 节点依次出队处理，并将其左右节点加入队列等待下层处理
                TreeNode cur = queue.poll();
                curList.add(cur.val); // 将节点值存入遍历序列
                // 判断当前节点是否存在左右节点
                if (cur.left != null) {
                    queue.offer(cur.left); // 左节点入队处理
                }
                if (cur.right != null) {
                    queue.offer(cur.right); // 右节点入队处理
                }
                n--;
            }
            // 完成一层遍历，将列表加入结果集
            res.add(curList);
        }
        return res;
    }

}

