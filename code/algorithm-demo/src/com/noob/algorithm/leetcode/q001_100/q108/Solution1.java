package com.noob.algorithm.leetcode.q001_100.q108;


import com.noob.algorithm.base.dataStructure.tree.TreeNode;

import java.util.*;

/**
 * 🟢 108.将有序数组转化为二叉搜索树 - https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/
 */
public class Solution1 {

    // 数组本身有序，将中点作为根节点，中点左侧的作为左子树、中点右侧的作为右子树
    public TreeNode sortedArrayToBST(int[] nums) {

        // 判断传入的nums长度是否为0，如果为0则不需要构建
        if (nums == null || nums.length == 0) {
            return null;
        }

        // 计算中点
        int mid = nums.length / 2;
        // 创建根节点进行存储
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid)); // 将数组左边的元素作为左节点
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid + 1, nums.length)); // 将数组右边的元素作为右节点
        // 返回root
        return root;
    }

}

