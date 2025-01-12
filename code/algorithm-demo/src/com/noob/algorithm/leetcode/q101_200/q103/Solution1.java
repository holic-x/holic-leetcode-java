package com.noob.algorithm.leetcode.q101_200.q103;

import com.noob.algorithm.base.dataStructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 🟡 103 二叉树的锯齿形层序遍历 - https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/description/
 */
public class Solution1 {

    /**
     * 锯齿形层序遍历：先从左往右、后从右往左
     * - 此处遍历顺序的处理在载入当层元素集合的时候处理（正序尾插、逆序头插）
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>(); // 定义结果集

        // 定义遍历方向
        boolean leftToRight = true; // 初始化从左往右的方向进行遍历

        // 构建辅助队列进行遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int curSize = queue.size(); // 当层元素个数
            List<Integer> curList = new ArrayList<>(); // 记录当层元素
            for (int i = 0; i < curSize; i++) {
                // 取出节点，按照指定方向进行遍历
                TreeNode node = queue.poll();

                // 根据遍历方向决定顺序
                if (leftToRight) {
                    // 从左到右遍历
                    curList.add(node.val);
                } else {
                    // 从右到左遍历（头插）
                    curList.add(0, node.val);
                }

                // 子节点入队
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            // 载入结果集
            res.add(curList);

            // 当层遍历完成，改变遍历方向
            leftToRight = !leftToRight;

        }

        // 返回遍历结果
        return res;
    }

}
