package com.noob.algorithm.leetcode.q104;


import com.noob.algorithm.base.dataStructure.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 🟢 104.二叉树的最大深度 - https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/
 */
public class Solution1 {

    // 算法入口
    public int maxDepth(TreeNode root) {
        // root null 校验
        if (root == null) {
            return 0;
        }

        return maxDepthBFS(root);
    }

    /**
     * 思路：广度优先遍历思路
     */
    private int maxDepthBFS(TreeNode root) {
        // 定义节点深度
        int depth = 0;

        // 定义队列做遍历辅助
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // 初始化队列

        while (!queue.isEmpty()) {
            // 记录当前层的节点个数
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left); // 存入左节点
                }
                if (node.right != null) {
                    queue.offer(node.right);// 存入右边节点
                }
                size--;
            }
            depth++;
        }
        return depth;
    }

}
