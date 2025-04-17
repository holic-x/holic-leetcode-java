package com.noob.algorithm.leetcode.q1301_q1400.q1382;


import com.noob.algorithm.base.dataStructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 🟡 1382 将二叉树搜索树变平衡 - https://leetcode.cn/problems/balance-a-binary-search-tree/description/
 */
public class Solution1382_01 {

    public TreeNode balanceBST(TreeNode root) {
        // 调用方法构建二叉树
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        TreeNode node = buildHelper(list.stream().mapToInt(Integer::intValue).toArray(), 0, list.size() - 1);
        return node;
    }

    // 遍历二叉搜索树获取有序序列
    private void dfs(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        // 中序遍历
        dfs(node.left, list);
        list.add(node.val);
        dfs(node.right, list);
    }


    // 定义构造二叉树的辅助方法
    private TreeNode buildHelper(int[] nums, int left, int right) {
        // 递归出口
        if (left > right) {
            return null;
        }

        // 取中点
        int mid = left + (right - left) / 2;

        // 构造节点
        TreeNode node = new TreeNode(nums[mid]);

        // 构造节点的左右子树
        node.left = buildHelper(nums, left, mid - 1);
        node.right = buildHelper(nums, mid + 1, right);

        // 返回构建的节点
        return node;
    }
}
