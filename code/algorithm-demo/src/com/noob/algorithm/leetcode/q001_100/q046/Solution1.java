package com.noob.algorithm.leetcode.q001_100.q046;

import java.util.ArrayList;
import java.util.List;

/**
 * 🟡 46.全排列 - https://leetcode.cn/problems/permutations/
 */
public class Solution1 {

    // 定义返回结果
    List<List<Integer>> res = new ArrayList<List<Integer>>();

    // 暴力思路：多层嵌套
    public List<List<Integer>> permute(int[] nums) {
        // 调用递归方法进行全排列（此处先将nums转化为List便于处理）
        List<Integer> numsList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            numsList.add(nums[i]);
        }
        // 调用递归方法进行全排列
        dfs(numsList,0);
        // 返回结果
        return res;
    }

    // 定义两个元素交换的方法
    public void swap(List<Integer> nums, int i, int j) {
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }

    // 定义dfs遍历方式
    public void dfs(List<Integer> nums, int x) {
        // 递归出口，遍历到数组尾部结束
        if (x == nums.size() - 1) {
            res.add(new ArrayList<>(nums)); // 添加排列方案(此处需new一个，否则添加的是引用)
            return; // 退出当前方法
        }
        // 执行操作
        for (int i = x; i < nums.size(); i++) {
            // 核心操作：交换（将nums[i]固定在x的位置）、进行全排列算法、复原（通过再次交换，还原成原来的数组便于下一次进行排列）
            swap(nums, i, x); // 交换
            dfs(nums, x + 1); // 进行全排列算法
            swap(nums, i,x); // 复原
        }
    }

}
