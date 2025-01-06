package com.noob.algorithm.base.util;

import com.noob.algorithm.base.dataStructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 树 操作相关工具类（构建二叉树、打印树）
 */
public class BinaryTreeUtil {

    /**
     * 根据限定的一维数组构建树（如果叶子结点为空则用null占位） todo null 待完善
     */
    public static TreeNode createBinaryTree(Integer[] nums) {
        int len = nums.length;
        if (len == 0) {
            return null;
        }

        // 借助队列辅助构建
        TreeNode root = new TreeNode(nums[0]);
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);

        int idx = 1; // idx 指代当前遍历的nums元素位置
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                // 取出元素，依次封装其左右子节点
                TreeNode node = queue.poll();
                if (node != null) {
                    // 处理左节点
                    if (idx >= len) {
                        break; // 如果元素全部遍历完成则直接跳出循环
                    }
                    node.left = new TreeNode(nums[idx] == null ? -1 : nums[idx]);
                    idx++;

                    // 处理右节点
                    if (idx >= len) {
                        break; // 如果元素全部遍历完成则直接跳出循环
                    }
                    node.right = new TreeNode(nums[idx] == null ? -1 : nums[idx]);
                    idx++;
                }

                // 将左右子节点分别入队
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        // 返回构建好的树
        return root;
    }

    /**
     * 递归构建树（dfs：DLR）
     */
    public static TreeNode createBinaryTreeByDfs(Integer[] nums) {
        return createBinaryTreeHelper(nums, 0);
    }

    /**
     * 递归构建树
     */
    private static TreeNode createBinaryTreeHelper(Integer[] nums, int idx) {
        if (idx >= nums.length) {
            return null;
        }

        // 构建节点
        if (nums[idx] == null) {
            return null;
        }

        TreeNode node = new TreeNode(nums[idx]);
        idx++;
        node.left = createBinaryTreeHelper(nums, idx);
        idx++;
        node.right = createBinaryTreeHelper(nums, idx);

        // 返回构建的节点
        return node;
    }


    /**
     * 基于层序遍历打印节点
     *
     * @param root
     */
    public void printTreeByBfs(TreeNode root) {
        if (root == null) {
            return;
        }

        List<Integer> res = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        PrintListUtil<Integer> printListUtil = new PrintListUtil<>();
        printListUtil.print(res);
    }


    public static void main(String[] args) {
        BinaryTreeUtil binaryTreeUtil = new BinaryTreeUtil();
        TreeNode root1 = binaryTreeUtil.createBinaryTree(new Integer[]{1, null, 2, 3});
        binaryTreeUtil.printTreeByBfs(root1);

        // 递归构建树
        TreeNode root2 = binaryTreeUtil.createBinaryTreeByDfs(new Integer[]{1, null, 2, 3});
        binaryTreeUtil.printTreeByBfs(root2);

    }

}
