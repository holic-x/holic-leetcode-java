package com.noob.algorithm.leetcode.q301_400.q334;

/**
 * 🟡 334.递增的三元子序列 - https://leetcode.cn/problems/increasing-triplet-subsequence/description/
 */
public class Solution1 {

    /**
     * 判断这个数组中是否存在长度为 3 的递增子序列
     * 判断是否存在三元组：满足下标i<j<k,nums[i]<nums[j]<nums[k],存在则返回true、不存在则返回false
     */
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        // 数组邻界条件讨论
        if (n < 3) {
            return false;
        }
        // 维护遍历过程中三元组序列的第1个数和第2个数
        int first = nums[0], second = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            // 遍历过程中判断并更新first、second的值，并同步校验是否存在满足条件的三元组
            int curN = nums[i];
            if (curN > second) { // ① 讨论1：校验是否存在满足条件的三元组，存在则直接返回
                return true; // 存在满足条件的三元组
            } else if (curN > first) { // ② 讨论2：更新second
                second = first; // 更新
            } else { // ③ 讨论3：其他情况，更新first
                first = curN;
            }
        }
        return false;
    }

}
