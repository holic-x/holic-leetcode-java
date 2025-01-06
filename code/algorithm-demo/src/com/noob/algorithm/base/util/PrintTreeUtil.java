package com.noob.algorithm.base.util;

import com.noob.algorithm.base.dataStructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 树打印 相关工具类
 */
public class PrintTreeUtil {

    /**
     * 基于层序遍历打印节点
     */
    public static void printTreeByBfs(TreeNode root) {
        if (root == null) {
            return;
        }

        List<String> res = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        res.add(String.valueOf(root.val));

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            // res.add(node.val); queue不能存入null，此处转化为对子节点进行null判断并处理，提前处理null节点
            if (node.left != null) {
                queue.offer(node.left);
                res.add(String.valueOf(node.left.val));
            } else {
                res.add(null); // 对null节点处理
            }
            if (node.right != null) {
                queue.offer(node.right);
                res.add(String.valueOf(node.right.val));
            } else {
                res.add(null); // 对null节点处理
            }
        }

        // 打印遍历序列
        PrintListUtil<String> printListUtil = new PrintListUtil<>();
        printListUtil.print(res);
    }

}
