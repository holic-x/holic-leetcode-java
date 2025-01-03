package com.noob.algorithm.leetcode.q039;

import java.util.ArrayList;
import java.util.List;

/**
 * 🟡 39.组合总和 - https://leetcode.cn/problems/combination-sum/description/
 */
public class Solution1 {

    private List<List<Integer>> ans = new ArrayList<>();
    private List path = new ArrayList<>();
    private int[] candidates;
    private int target;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        dfs(0, 0); // 初始化从0开始，sum初始化为0
        return ans;
    }

    // 深度优先遍历思路，查找满足条件的路径
    private void dfs(int start, int sum) {
        // 如果指定和等于目标值，则加入结果集
        if (sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        // 如果指定和大于目标值则剪断
        if (sum > target) {
            return;
        }

        // 如果指定和小于目标值，则继续深度遍历、回溯
        for (int i = start; i < candidates.length; i++) {
            path.add(candidates[i]); // 将当前位置遍历元素加入路径
            dfs(i, sum + candidates[i]); // 深度遍历
            path.remove(path.size() - 1); // 回溯
        }
    }

}
