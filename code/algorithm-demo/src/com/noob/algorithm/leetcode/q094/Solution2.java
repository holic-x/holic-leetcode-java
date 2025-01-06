package com.noob.algorithm.leetcode.q094;



import com.noob.algorithm.base.dataStructure.tree.TreeNode;

import java.util.*;

/**
 * 94.二叉树的中序遍历(迭代法)
 */
public class Solution2 {
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

}
