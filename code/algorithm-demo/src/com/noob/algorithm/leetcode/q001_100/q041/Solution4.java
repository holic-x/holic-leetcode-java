package com.noob.algorithm.leetcode.q001_100.q041;

/**
 * 🔴 041 缺失的第1个正数 - https://leetcode.cn/problems/first-missing-positive/
 */
public class Solution4 {
    /**
     * 给定一个未排序的数组nums，找出其中没有出现的最小正整数（题目限定时间复杂度为O(n),且只能使用常数级别的空间）
     * 思路④：原地哈希
     */
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // 基于原地哈希设计的映射规则：将元素i(此处i表示元素值)映射到下标为i-1的位置上（i取值为[1,n]）

        // ① 遍历数组元素，将数组中的每个元素x映射到下标为x-1的位置上（交换）
        for (int i = 0; i < n; i++) {
            // 校验要处理的目标位置元素是否为当前元素（todo 先不考虑重复值的情况）
            /*
            处理版本（1） ❌ 下标越界，受到交换的联动影响
            // 当前位置i、元素nums[i]，目标位置nums[i]-1、目标位置元素nums[nums[i]-1]
            if (nums[i] - 1 >= 0) { // 下标有效的情况下进行交换
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[nums[i] - 1] = temp;
            }
             */

            /*
            处理版本（2） ❌ 没有兼容所有用例
            int curIdx = i, targetIdx = nums[i] - 1;
            if (targetIdx >= 0 && targetIdx < n) { // 下标有效的情况下进行交换
                int temp = nums[curIdx];
                nums[curIdx] = nums[targetIdx];
                nums[targetIdx] = temp;
            }
             */

            // 处理版本（3） ✅
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // 满足在指定范围内、并且没有放在正确的位置上，才交换
                // 例如：数值 3 应该放在索引 2 的位置上 （swap(nums, nums[i] - 1, i);）
                int curIdx = i, targetIdx = nums[i] - 1;
                int temp = nums[curIdx];
                nums[curIdx] = nums[targetIdx];
                nums[targetIdx] = temp;
            }
        }

        // ② 再次遍历数组，校验数组元素是否被放置在正确的位置(即满足映射关系，如果不满足则说明找到了这个位置缺失的正数)
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // 如果[1,n]集合中都覆盖了，那么返回n+1
        return n + 1;
    }

    public static void main(String[] args) {
        // int[] nums = new int[]{1,2,0};
        int[] nums = new int[]{3, 4, -1, 1};
        Solution4 s = new Solution4();
        System.out.println(s.firstMissingPositive(nums));
    }
}
