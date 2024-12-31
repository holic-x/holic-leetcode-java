package com.noob.algorithm.base.tree;


/**
 * 二叉树基本操作
 */
public class TreeBaseDemo {
    /**
     * initTreeNode：初始化二叉树
     */
    public static TreeNode initTreeNode(){
        // 定义二叉树节点
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);

        // 构建各个节点的关系（构建节点间的引用关系）
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;

        // 返回根节点
        return root;
    }


    /**
     * 作节点：新增节点、删除节点
     * @return
     */
    public static TreeNode operTreeNode(){
        /**
         * initTreeNode：初始化二叉树
         */
        // 定义二叉树节点
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        // 构建各个节点的关系（构建节点间的引用关系）
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        /**
         * 操作节点：新增节点、删除节点
         */
        // 创建新节点
        TreeNode P = new TreeNode(7);
        // 将P节点插入n1和n2之间
        node1.left = P;
        P.left = node2;
        // 删除P节点
        node1.left = node2;

        // 返回根节点
        return node1;
    }


    public static void main(String[] args) {

    }

}


/**
 * 二叉树节点定义
 */
class TreeNode {

    // 定义节点值
    int val;
    // 定义左节点
    TreeNode left;
    // 定义右节点
    TreeNode right;
    // 构造函数
    public TreeNode(int val) {
        this.val = val;
    }

}

