package com.noob.algorithm.leetcode.q001_100.q104;


import com.noob.algorithm.base.dataStructure.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 🟢 104.二叉树的最大深度 - https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/
 */
public class Solution2
{

    // 算法入口
    public int maxDepth(TreeNode root) {
        return maxDepthDFS(root);
    }

    /**
     * 思路：深度优先遍历思路（递归）
     */
    private int maxDepthDFS(TreeNode root) {
        // 递归访问到空节点的时候退出
        if(root == null) {
            return 0;
        }else{
            // 分别计算左右子树的深度
            int leftDepth = maxDepthDFS(root.left);
            int rightDepth = maxDepthDFS(root.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }

}
