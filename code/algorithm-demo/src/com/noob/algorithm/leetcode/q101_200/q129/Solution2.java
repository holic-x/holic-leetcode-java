package com.noob.algorithm.leetcode.q101_200.q129;


import com.noob.algorithm.base.dataStructure.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 🟡 129-求根节点到叶子节点的数字之和 - https://leetcode.cn/problems/sum-root-to-leaf-numbers/
 */
public class Solution2 {

    /**
     * 根节点到每个叶子节点构成一个整数，求这些路径构成的整数集合之和
     */
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = 0;

        // 基于层序遍历的思路，定义两个队列，一个存储遍历节点，一个同步记录路径
        Queue<TreeNode> valQueue = new LinkedList<>();
        valQueue.offer(root);
        Queue<Integer> pathQueue = new LinkedList<>();
        pathQueue.offer(root.val);

        // 遍历队列(分层处理)
        while (!valQueue.isEmpty()) {
            int curSize = valQueue.size();
            for (int i = 0; i < curSize; i++) {
                // 取出节点
                TreeNode node = valQueue.poll();
                int curVal = pathQueue.poll();
                System.out.println("当前node:" + node.val + "  当前路径构成的整数值：" + curVal);

                // 结果处理（到达叶子节点处收集结果）
                if (node.left == null && node.right == null) {
                    sum += curVal;
                }

                // 处理左右子节点
                if (node.left != null) {
                    valQueue.offer(node.left);
                    pathQueue.offer(curVal * 10 + node.left.val);
                }
                if (node.right != null) {
                    valQueue.offer(node.right);
                    pathQueue.offer(curVal * 10 + node.right.val);
                }
            }
        }

        // 返回结果
        return sum;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;

        Solution2 s = new Solution2();
        s.sumNumbers(node1);
    }
}
