package com.noob.algorithm.leetcode.q601_q700.q662;


import com.noob.algorithm.base.dataStructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 🟡 662 二叉树的最大宽度 - https://leetcode.cn/problems/maximum-width-of-binary-tree/description/
 */
public class Solution1 {

    /**
     * 树的 最大宽度 是所有层中最大的 宽度
     * 每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度
     * 将这个二叉树视作与满二叉树结构相同，两端点间会出现一些延伸到这一层的 null 节点，这些 null 节点也计入长度
     */
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 构建队列辅助遍历（BFS）
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            // 分层遍历
            int curSize = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < curSize; i++) {
                TreeNode curNode = queue.poll();

                // 处理节点
                tmp.add(curNode != null ? curNode.val : -1); // 如果节点为null则用-1进行标记

                // 将空节点也纳入遍历范畴
                if (curNode != null) {
                    queue.offer(curNode.left);
                    queue.offer(curNode.right);
                } else {
                    // null 节点，需要入队两个null节点以确保占位距离正确
                    queue.offer(null);
                    queue.offer(null);
                }
            }
            // 当层遍历完成，填充ans
            ans.add(new ArrayList<>(tmp));

            // 检查队列是否全为null（可以提前终止，避免无限循环）
            boolean allNull = true;
            for (TreeNode node : queue) {
                if (node != null) {
                    allNull = false;
                    break;
                }
            }
            if (allNull) break;
        }

        // 处理获取到的ans信息，计算每一层的最大宽度（左侧非-1的值 与右侧非-1的值的索引差）
        int maxWidth = 1; // 至少根节点宽度为1
        for (List<Integer> tmp : ans) {
            // 从左往右寻找非-1
            int leftIdx = 0;
            while (tmp.get(leftIdx) == -1 && leftIdx < tmp.size() - 1) {
                leftIdx++;
            }

            // 从右往左寻找非-1
            int rightIdx = tmp.size() - 1;
            while (tmp.get(rightIdx) == -1 && rightIdx > 0) {
                rightIdx--;
            }
            // 更新最大宽度
            maxWidth = Math.max(maxWidth, rightIdx - leftIdx + 1);
        }

        // 返回结果
        return maxWidth;
    }
}
