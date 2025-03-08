package com.noob.algorithm.leetcode.q101_200.q101;


import com.noob.algorithm.base.dataStructure.tree.TreeNode;

/**
 * 🟢 101 对称二叉树 - https://leetcode.cn/problems/symmetric-tree/description/
 */
public class Solution2 {

    /**
     * 判断节点是否为轴对称，则其左右子树要对称
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        // 调用递归方法校验
        return dfs(root.left, root.right);
    }

    /**
     * 递归处理:校验两个子树是否轴对称
     * 根据p、q 的 null 讨论处理
     */
    private boolean dfs(TreeNode p, TreeNode q) {
        // ① p、q 均为null
        if (p == null && q == null) {
            return true; // 对称
        }

        // ② p、q 中只有一个为null
        if ((p == null && q != null) || (p != null && q == null)) {
            return false; // 不对称
        }

        // ③ p、q 均不为null，则需递归校验两个子树的左右子树是否是否对称
        if (p != null && q != null) {
            if (p.val != q.val) {
                return false; // p、q 节点的值不同，必定不对称
            } else {
                // p、q节点的值相同，则需递归校验子树
                boolean valid1 = dfs(p.left, q.right); // p的左子树与q的右子树
                boolean valid2 = dfs(p.right, q.left); // p的右子树与q的左子树
                return valid1 && valid2;
            }
        }

        // 其余情况默认返回false
        return false;
    }

}
