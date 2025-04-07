package com.noob.algorithm.leetcode.q901_q1000.q958;


import com.noob.algorithm.base.dataStructure.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 🟡 958 二叉树的完全性校验：https://leetcode.cn/problems/check-completeness-of-a-binary-tree/
 */
public class Solution2 {

    /**
     * 基于层序遍历思路：从上到下、从左到右，如果遍历到非空节点时发现前面已经出现过空节点则说明为非完全二叉树
     */
    public boolean isCompleteTree(TreeNode root) {

        // 构建队列辅助遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // 定义空节点标识
        boolean seenNull = false; // 表示空节点是否出现过

        // 遍历队列，处理节点数据
        while (!queue.isEmpty()) {
            // 取出节点
            TreeNode node = queue.poll();

            // 校验节点
            if (node == null) {
                seenNull = true;
            } else {
                if (seenNull) {
                    return false; // 出现空节点时，前面已经出现过空节点，说明不满足完全二叉树特性
                }
                // 处理左右子节点
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        // 所有节点校验通过
        return true;
    }
}
