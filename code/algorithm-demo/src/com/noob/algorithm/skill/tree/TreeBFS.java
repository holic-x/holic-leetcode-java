package com.noob.algorithm.skill.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 层序遍历（广度优先遍历）
 */
public class TreeBFS {

    /**
     * initTreeNode：初始化二叉树
     */
    public static TreeNode initTreeNode(){
        // 定义二叉树节点
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        // 构建各个节点的关系（构建节点间的引用关系）
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        // 返回根节点
        return node1;
    }

    /**
     * BFS 广度优先遍历（层次遍历）
     * @param root
     * @return
     */
    public static List<Integer> printBFS(TreeNode root){
        // 初始化队列，加入根节点
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        // 初始化列表，用于保存遍历的序列
        List<Integer> list = new ArrayList<>();
        // 遍历队列中的节点（遍历某个节点执行出队，并判断其是否有左右节点，有则分别先后入队，以此类推进行遍历操作）
        while(!queue.isEmpty()){
            // 遍历当前节点，执行出队操作
            TreeNode node = queue.poll(); // 队列出队
            list.add(node.val); // 将其加入遍历序列（只有节点出队时才加入遍历序列）
            // 判断当前节点是否有左节点
            if(node.left != null){
                queue.add(node.left); // 存在左节点，则将其左节点入队
            }
            // 判断当前节点是否有右节点
            if(node.right != null){
                queue.add(node.right);// 存在右节点，则将其右节点入队
            }
        }
        // 返回遍历序列
        return list;
    }

    public static void main(String[] args) {
        TreeBFS treeBFS = new TreeBFS();
        // 初始化二叉树
        TreeNode root = treeBFS.initTreeNode();
        // 执行层次遍历
        List<Integer> list = treeBFS.printBFS(root);
        list.stream().forEach(System.out::println);
    }
}
