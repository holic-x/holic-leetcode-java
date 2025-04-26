package com.noob.algorithm.leetcode.q101_200.q145;


import com.noob.algorithm.base.dataStructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 🟢 145 二叉树的后序遍历
 */
public class Solution145_01 {

    /**
     * 后序遍历：LRD
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }

    private void dfs(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        dfs(node.left, list);
        dfs(node.right, list);
        list.add(node.val);
    }
}
