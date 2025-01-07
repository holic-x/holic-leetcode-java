package com.noob.algorithm.leetcode.q001_100.q039;

import java.util.ArrayList;
import java.util.List;

/**
 * 🟡 39.组合总和 - https://leetcode.cn/problems/combination-sum/description/
 */
public class Solution2 {

    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    private int pathSum = 0; // 当前路径选中节点和

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTrack(candidates, target, 0); // 初始化从0开始，sum初始化为0
        return ans;
    }

    // 回溯算法
    private void backTrack(int[] candidates, int target, int index) {
        // 如果指定和等于目标值，则加入结果集
        if (pathSum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        // 如果指定和大于目标值则剪断
        if (pathSum > target) {
            return;
        }

        // 如果指定和小于目标值，则继续深度遍历、回溯
        for (int i = index; i < candidates.length; i++) {
            path.add(candidates[i]); // 将当前位置遍历元素加入路径
            pathSum += candidates[i];
            backTrack(candidates, target, i);
            path.remove(path.size() - 1); // 恢复现场
            pathSum -= candidates[i];
        }
    }

}
