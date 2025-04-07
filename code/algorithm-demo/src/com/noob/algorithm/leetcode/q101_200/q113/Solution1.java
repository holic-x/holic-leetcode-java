package com.noob.algorithm.leetcode.q101_200.q113;


import com.noob.algorithm.base.dataStructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 🟡 113 路径总和II - https://leetcode.cn/problems/path-sum-ii/description/
 */
public class Solution1 {

    // 存储结果集合
    List<List<Integer>> ans = new ArrayList<>();

    // 存储临时路径和该路径和
    List<Integer> curPath = new ArrayList<>();
    int curPathSum = 0;

    /**
     * 从根节点到叶子节点路径总和等于目标的路径
     *
     * @param root
     * @param targetSum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return new ArrayList<>();
        }

        // 处理节点
        curPath.add(root.val);
        curPathSum += root.val;

        // 调用回溯算法
        backTrack(root, targetSum);
        // 返回处理结果
        return ans;
    }


    // 回溯处理
    private void backTrack(TreeNode node, int targetSum) {
        // 递归出口
        if (node == null) {
            return;
        }
        // 判断是否为叶子节点
        if (node.left == null && node.right == null) {
            // 尝试收集叶子节点处的结果
            if (curPathSum == targetSum) {
                ans.add(new ArrayList<>(curPath)); // 收集路径结果
            }
            return;
        }

        // 递归处理左右子节点
        if (node.left != null) {
            curPath.add(node.left.val);
            curPathSum += node.left.val;
            backTrack(node.left, targetSum);
            curPath.remove(curPath.size() - 1);
            curPathSum -= node.left.val;
        }

        if (node.right != null) {
            curPath.add(node.right.val);
            curPathSum += node.right.val;
            backTrack(node.right, targetSum);
            curPath.remove(curPath.size() - 1);
            curPathSum -= node.right.val;
        }
    }

}
