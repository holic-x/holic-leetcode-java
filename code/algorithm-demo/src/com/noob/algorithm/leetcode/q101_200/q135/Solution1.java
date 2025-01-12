package com.noob.algorithm.leetcode.q101_200.q135;

/**
 * 🔴 135 分发糖果 - https://leetcode.cn/problems/candy/description/
 */
public class Solution1 {

    /**
     * 两次遍历：动态规划 + 贪心算法
     * 思路：如果直接考虑两边两边的因素影响就会顾此失彼，因此此处拆分左右两边来分析，最终选择max{left,right}即可满足同时兼顾两侧的情况下的最少分派糖果数
     */
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n]; // left[i] 表示基于左边小朋友的评分情况考虑所需要派发给第i个小朋友的最少糖果数量
        left[0] = 1; // 第1个小朋友至少派发1个
        for (int i = 1; i < n; i++) { // 从左到右开始遍历
            // 判断相邻两个小朋友的评分关系
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1; // 如果右侧的小朋友评分比其左侧小朋友评分高则至少比其多1个
            } else {
                left[i] = 1; // 如果右侧的小朋友评分比其左侧小朋友评分低则可以给他派1个糖果即可满足条件
            }
        }

        int[] right = new int[n];
        right[n - 1] = 1; // 最后1个小朋友至少派发1个
        for (int i = n - 2; i >= 0; i--) { // 从右到左开始遍历
            // 判断相邻两个小朋友的评分关系
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1; // 如果左侧的小朋友评分比其右小朋友评分高则至少比其多1个
            } else {
                right[i] = 1; // 如果左侧的小朋友评分比其右侧小朋友评分低则可以给他派1个糖果即可满足条件
            }
        }

        // 汇聚左右规则综合结果
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.max(left[i], right[i]);
        }

        // 返回结果
        return res;
    }

}
