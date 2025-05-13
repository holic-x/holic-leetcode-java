package com.noob.algorithm.leetcode.q401_500.q404;


import com.noob.algorithm.base.dataStructure.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 🟢 404 左叶子之和 - https://leetcode.cn/problems/sum-of-left-leaves/description/
 */
public class Solution404_02 {

    /**
     * 思路分析：判断左子节点，且左子节点为叶子节点
     */
    public int sumOfLeftLeaves(TreeNode root) {

        if (root == null) {
            return 0;
        }

        // 迭代处理
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();
            if (node.left != null) {
                // 存在左子节点，且左子节点为叶子节点，则表示满足条件进行记录
                if (node.left.left == null && node.left.right == null) {
                    ans += node.left.val;
                }
            }

            // 将左、右子节点加入队列
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        // 返回结果
        return ans;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        Solution404_02 s = new Solution404_02();
        s.sumOfLeftLeaves(node);
    }

}
