package com.noob.algorithm.leetcode.q201_300.q257;


import com.noob.algorithm.base.dataStructure.tree.TreeNode;

import java.util.*;

/**
 * 🟢 257.二叉树的所有路径 - https://leetcode.cn/problems/binary-tree-paths/
 */
public class Solution257_02 {

    /**
     * 思路分析：
     */
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<String> ans = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Queue<String> path = new LinkedList<>();
        path.offer(String.valueOf(root.val));

        // 校验队列
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                TreeNode node = queue.poll();
                String curPath = path.poll();

                // 判断是否为叶子节点，更新结果
                if (node.left == null && node.right == null) {
                    ans.add(curPath);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                    path.offer(curPath + "->" + node.left.val);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                    path.offer(curPath + "->" + node.right.val);
                }
            }

        }

        // 返回结果
        return ans;

    }


}
