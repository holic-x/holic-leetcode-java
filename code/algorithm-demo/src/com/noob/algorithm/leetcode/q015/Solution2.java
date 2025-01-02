package com.noob.algorithm.leetcode.q015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 🟡 015 三数之和
 * https://leetcode.cn/problems/3sum/description/
 */
public class Solution2 {

    /**
     * 核心：双指针思路，找出符合条件的三元组（固定一位，双指针移动寻找匹配元素组合）
     * 算法优化：剪枝、去重处理
     */
    public List<List<Integer>> threeSum(int[] nums) {
        // 定义结果集
        List<List<Integer>> result = new ArrayList<>();
        // 对数据进行排序
        Arrays.sort(nums);
        // 循环遍历进行校验（[x,y,z]）
        for (int i = 0; i < nums.length; i++) {
            // 剪枝处理
            if (nums[i] > 0) {
                continue; // 如果选定的x都大于0，则排序后后面的构成会越来越大，更加不可能构成三元组，直接剪枝
            }
            // 去重校验
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue; // 排序后的序列中当选定一个数，则其三元组是敲定下来的，对于连续重复出现的元素进行去重处理，直接剪枝
            }

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
                    result.add(target); // 此处在校验过程中进行去重剪枝，平替contains操作
                    // 移动双指针
                    p++;
                    q--;

                    // 本次操作处理完成，去重操作（检验是否出现连续的y、z）
                    while (p < q && nums[p - 1] == nums[p]) p++;
                    while (p < q && nums[q] == nums[q + 1]) q--;
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

}
