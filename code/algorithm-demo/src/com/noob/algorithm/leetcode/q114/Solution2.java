package com.noob.algorithm.leetcode.q114;


import com.noob.algorithm.leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 114.二叉树展开为链表
 */
public class Solution2 {


    public void flatten(TreeNode root) {

        List<TreeNode> list = new ArrayList<>();
        // 获取先序遍历的节点信息
        list = preOrderHelper(root,list);

        // 重新链接节点关系
//        for (int i = 0; i < list.size(); i++) {
//            TreeNode node = list.get(i);
//            node.left = null; // 节点左节点置空
//            node.right = list.get(i + 1); // 节点右节点为下一个顺序
//        }

    }

    public List<TreeNode> preOrderHelper(TreeNode node,List<TreeNode> list) {

        // 先序遍历
        if(node == null){
            return list;
        }

        // 先序遍历（root、left、right）
        list.add(node);
        preOrderHelper(node.left,list);
        preOrderHelper(node.right,list);

        // 返回结果集
        return list;
    }


}

