package com.noob.algorithm.leetcode.q101_200.q145;


import com.noob.algorithm.base.dataStructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 🟢 145 二叉树的后序遍历
 */
public class Solution145_02 {

    /**
     * 后序遍历：LRD  迭代法
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }

        // 定义结果集
        List<Integer> ans = new ArrayList<>();

        // 定义栈辅助遍历
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            ans.add(node.val);
            if(node.left!=null){
                stack.push(node.left);
            }
            if(node.right!=null){
                stack.push(node.right);
            }
        }

        // 返回反向列表
        Collections.reverse(ans);

        return ans;
    }

}
