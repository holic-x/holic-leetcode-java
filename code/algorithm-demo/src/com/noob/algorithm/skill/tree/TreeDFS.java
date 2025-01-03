package com.noob.algorithm.skill.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 深度优先遍历（前序、中序、后序）
 * 所谓前、中、后的顺序可以理解为root根节点在这个顺序中的位置（左节点优先于右节点遍历）
 * 前序：root->left->right
 * 中序：left->root->right
 * 后序：left->right->root
 */
public class TreeDFS {

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

    // 前序遍历
    public static List<Integer> preOrder(TreeNode root,List<Integer> list){
        // 判断当前节点是否为空
        if(root == null){
            return list;
        }
        // root->left->right
        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
        return list;
    }

    // 中序遍历
    public static List<Integer> midOrder(TreeNode root,List<Integer> list){
        // 判断当前节点是否为空
        if(root == null){
            return list;
        }
        // left->root->right
        midOrder(root.left, list);
        list.add(root.val);
        midOrder(root.right, list);
        return list;
    }

    // 后序遍历
    public static List<Integer> postOrder(TreeNode root,List<Integer> list){
        // 判断当前节点是否为空
        if(root == null){
            return list;
        }
        // left->right->root
        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.val);
        return list;
    }

    public static void main(String[] args) {
        TreeDFS treeBFS = new TreeDFS();
        // 初始化二叉树
        TreeNode root = treeBFS.initTreeNode();

        // 定义存储的序列集合
        List<Integer> list = new ArrayList<>();

        // 执行先序遍历
        System.out.println("执行先序遍历:");
        list = treeBFS.preOrder(root,list);
        list.stream().forEach(System.out::println);

        // 执行中序遍历
        System.out.println("执行中序遍历:");
        list.clear();
        list = treeBFS.midOrder(root,list);
        list.stream().forEach(System.out::println);

        // 执行后续遍历
        System.out.println("执行后续遍历:");
        list.clear();
        list = treeBFS.postOrder(root,list);
        list.stream().forEach(System.out::println);
    }
}
