package com.noob.algorithm.leetcode.q101_200.q129;


import com.noob.algorithm.base.dataStructure.tree.TreeNode;

/**
 * 🟡 129-求根节点到叶子节点的数字之和 - https://leetcode.cn/problems/sum-root-to-leaf-numbers/
 */
public class Solution1 {

    public int sum = 0; // 定义每条路径构成的整数之和
    public StringBuffer path = new StringBuffer(); // 定义每条路径构成的整数

    /**
     * 根节点到每个叶子节点构成一个整数，求这些路径构成的整数集合之和
     */
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 初始化将根节点加入路径
        path.append(root.val);
        // 调用递归方法处理结果
        dfs(root);
        // 返回累加和
        return sum;
    }

    // 递归处理
    private void dfs(TreeNode node) {
        // 节点为null 退出
        if (node == null) {
            return;
        }

        // 如果到达叶子节点，收集路径和
        if (node.left == null && node.right == null) {
            sum += Integer.valueOf(path.toString());
            return;
        }

        // 分别递归左右子节点
        if (node.left != null) {
            path.append(node.left.val);
            dfs(node.left);
            path.deleteCharAt(path.length() - 1);
        }

        if (node.right != null) {
            path.append(node.right.val);
            dfs(node.right);
            path.deleteCharAt(path.length() - 1);
        }
    }

}
