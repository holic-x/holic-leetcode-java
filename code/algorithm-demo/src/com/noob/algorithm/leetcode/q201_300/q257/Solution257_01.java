package com.noob.algorithm.leetcode.q201_300.q257;


import com.noob.algorithm.base.dataStructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 🟢 257.二叉树的所有路径 - https://leetcode.cn/problems/binary-tree-paths/
 */
public class Solution257_01 {

    // 定义列表存储路径结果
    List<String> ans = new ArrayList<>();
    List<String> path = new ArrayList<>(); // 存储当前路径结果

    /**
     * 思路分析：
     */
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        // 初始化root节点加入路径
        path.add(String.valueOf(root.val));

        // 递归处理
        dfs(root);

        return ans;
    }

    // 递归处理
    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        // 校验是否为叶子节点
        if (node.left == null && node.right == null) {
            String pathStr = String.join("->", path);
            ans.add(pathStr);
        }

        // 递归处理左、右子树
        if (node.left != null) {
            path.add(String.valueOf(node.left.val));
            dfs(node.left);
            path.remove(path.size() - 1);
        }

        if (node.right != null) {
            path.add(String.valueOf(node.right.val));
            dfs(node.right);
            path.remove(path.size() - 1);
        }

    }

}
