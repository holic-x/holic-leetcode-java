package com.noob.algorithm.leetcode.q078;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 🟡 78.子集 - https://leetcode.cn/problems/subsets/description/
 */
public class Solution2 {

    List<List<Integer>> res = new ArrayList<>(); // 定义当前结果集
    List<Integer> curPath = new ArrayList<>(); // 定义当前路径

    /**
     * 思路：回溯法
     */
    public List<List<Integer>> subsets(int[] nums) {
        // 排序
        Arrays.sort(nums);
        // 调用回溯算法
        backTrack(nums, 0);
        // 返回结果集
        return res;
    }

    public void backTrack(int[] nums, int index) {
        // 递归出口
        if (index > nums.length) {
            return;
        }

        // 对于每一个节点需要记录
        res.add(new ArrayList<>(curPath));

        // 递归回溯处理
        for (int i = index; i < nums.length; i++) {
            // 选择节点
            curPath.add(nums[i]);
            backTrack(nums, i + 1);
            curPath.remove(curPath.size() - 1);
        }
    }
}
