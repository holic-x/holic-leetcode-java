package com.noob.algorithm.leetcode.q1001_q1100.q1005;

import java.util.Arrays;

/**
 * 🟢 1005 K 次取反后最大化的数组和 - https://leetcode.cn/problems/maximize-sum-of-array-after-k-negations/description/
 */
public class Solution1 {

    /**
     * 重复k次将某个元素nums[i]变成其相反数-nums[i]
     * 思路：排序 + 负数取反（如果有剩余k则选择更新后的数组的最小正数进行一正一负消耗）
     */
    public int largestSumAfterKNegations(int[] nums, int k) {
        // 对数组元素进行从小到大排序
        Arrays.sort(nums);
        // 遍历并处理元素
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (k > 0 && nums[i] < 0) { // k有剩余，且元素为负数则可直接进行取反
                nums[i] *= -1;
                k--;
            }
            res += nums[i]; // 累计数组元素和
        }
        // 如果k有剩余则需要继续执行（选择更新后的数组的最小元素进行一正一负消耗）
        Arrays.sort(nums); // 对更新后的数组再次进行排序
        if (k > 0) {
            if (k % 2 == 1) { // 奇数（需减去2个nums[0]）
                res = res - 2 * nums[0];
            } else if (k % 2 == 0) { // 偶数（一正一负抵消）
                return res;
            }
        }

        // 返回处理结果
        return res;
    }

}
