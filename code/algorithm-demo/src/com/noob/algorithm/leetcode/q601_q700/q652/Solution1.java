package com.noob.algorithm.leetcode.q601_q700.q652;


import com.noob.algorithm.base.dataStructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 🟡 652 寻找重复的子树 - https://leetcode.cn/problems/find-duplicate-subtrees/description/
 */
public class Solution1 {

    // 用于存储子树的序列化表示及其出现的次数
    private Map<String, Integer> map = new HashMap<>();
    // 用于存储重复的子树
    private List<TreeNode> result = new ArrayList<>();

    /**
     * 思路分析：子树重复表示这两个节点及其子节点是完全相同的
     * 遍历每个节点，如果找到两个节点值相同的节点，则进一步递归判断其子结构是否完全一致
     */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        // 序列化子树
        serialize(root);

        // 返回结果
        return result;
    }

    // 序列化子树:返回子树的序列化字符串
    private String serialize(TreeNode node) {
        if (node == null) {
            return "#"; // 占位符
        }

        // 序列化当前子树（三元组概念，序列化当前节点，用节点值+其左右子节点序列化值来表示）
        String serial = node.val + "," + serialize(node.left) + "," + serialize(node.right);

        // 记录序列化结果出现的次数
        map.put(serial, map.getOrDefault(serial, 0) + 1);

        // 如果某个序列化结果出现两次，说明这个子树是重复的
        if (map.get(serial) == 2) {
            result.add(node);
        }

        return serial;
    }


    /**
     * todo 相同的树概念（辅助方法）❌❌❌❌❌
     * 判断两棵子树是否为相同的树:
     * 根据p、q的值来进行分类讨论，递归讨论子节点的情况
     */
    private boolean isSame(TreeNode p, TreeNode q) {
        // ① p、q均为null
        if (p == null && q == null) {
            return true;
        }

        // ② p、q中只有一个不为null
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }

        // ③ p、q均不为null，判断值和左右节点的情况
        return isSame(p.left, q.left) && isSame(p.right, q.right) && p.val == q.val;
    }

}
