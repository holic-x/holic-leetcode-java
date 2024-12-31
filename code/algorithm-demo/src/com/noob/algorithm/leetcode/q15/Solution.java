package com.noob.algorithm.leetcode.q15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * 核心：找出符合条件的三元组
 */
public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        // 定义结果集
        List<List<Integer>> result = new ArrayList<>();
        // 对数据进行排序
        Arrays.sort(nums);
        // 循环遍历进行校验
        for (int i = 0; i < nums.length; i++) {
            // 定义双指针
            int p = i + 1, q = nums.length - 1;
            // 双指针相遇则本次遍历结束
            while (p < q) {
                // 校验sum值
                int sum = nums[i] + nums[p] + nums[q];
                if (sum == 0) {
                    // 满足条件则加入结果集 result.add(Arrays.asList(nums[i], nums[p], nums[q]));
                    // 去重操作
                    List<Integer> target = Arrays.asList(nums[i], nums[p], nums[q]);
                    if(!result.contains(target)) {
                        result.add(target);
                    }
                    // 移动双指针
                    p++;
                    q--;
                } else if (sum < 0) {
                    // 向右移动p指针，让p变大，让sum趋于0
                    p++;
                } else if (sum > 0) {
                    // 向左移动q指针，让q变小，让sum趋于0
                    q--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        Solution solution = new Solution();
        System.out.println(solution.threeSum(nums));
    }

}
