package com.noob.algorithm.leetcode.q101_200.q101;


import com.noob.algorithm.base.dataStructure.tree.TreeNode;

import java.util.LinkedList;

/**
 * 🟢 101 对称二叉树 - https://leetcode.cn/problems/symmetric-tree/description/
 */
public class Solution3 {

    /**
     * 判断节点是否为轴对称，则其左右子树要对称
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        // 调用bfs方法校验
        return bfs(root.left, root.right);
    }

    /**
     * 递归处理:校验两个子树是否轴对称
     * 相当于同时遍历两棵子树，校验遍历的序列是否完全一致
     * 可以用双队列或者单队列方式
     */
    private boolean bfs(TreeNode p, TreeNode q) {
        // 定义单队列模式处理
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);

        // 遍历队列，每次取出两个节点进行校验（此处注意空节点对应位置也要进行默认填充，避免因位置问题导致错误判断）
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();

            // 根据node1、node2 分情况讨论
            // ① node1、node2均为null（null），符合条件，放行
            if (node1 == null && node2 == null) {
                continue; // 对称，放行
            }

            // ② node1、node2其中一个为null
            if ((node1 != null && node2 == null) || (node1 == null && node2 != null)) {
                return false; // 不对称
            }

            // ③ node1、node2 均不为null
            if (node1 != null && node2 != null) {
                // 校验节点值和子树的对称情况（校验值，择选将子树加入队列）
                if (node1.val != node2.val) {
                    return false; // 不对称
                }
                // 值相同，将左右子树相关节点加入队列，等待下一轮比较
                // node1.left 与 node2.right 一组比较
                queue.offer(node1.left);
                queue.offer(node2.right);
                // p.right 与 q.left 一组比较
                queue.offer(node1.right);
                queue.offer(node2.left);
            }
        }
        // 校验通过
        return true;
    }

}
