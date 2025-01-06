package com.noob.algorithm.leetcode.q98;


import com.noob.algorithm.base.dataStructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 98.二叉搜索树验证
 */
public class Solution1 {

    public boolean isValidBST(TreeNode root) {
        // 二叉搜索树的中序遍历是升序的，因此可以基于此先得到二叉搜索树的中序遍历序列，然后校验升序性
        List<Integer> list = toBFS(root);
        // 校验list的升序性(相邻两个元素依次比较)
        for(int i=0;i<list.size();i++){
           for(int j=i+1;j<list.size();j++){
               if(list.get(i)>=list.get(j)){ // 需注意数组元素重复的情况，二叉搜索树不允许出现重复值
                   return false;
               }
           }
        }
        return true;
    }

    public  List<Integer> toBFS(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        list = bfs(root,list);
        return list;
    }

    public List<Integer> bfs(TreeNode node,List<Integer> list) {
        // 判断node是否为null,为null不执行操作
        if(node == null){
            return list;
        }
        // 中序遍历：left、root，right
        bfs(node.left,list); // 左节点
        list.add(node.val);
        bfs(node.right,list);// 右节点
        // 返回list
        return list;
    }


}

