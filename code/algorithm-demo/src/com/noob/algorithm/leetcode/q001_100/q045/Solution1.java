package com.noob.algorithm.leetcode.q001_100.q045;

/**
 * 🟡 045.跳跃游戏II - https://leetcode.cn/problems/jump-game-ii/
 */
public class Solution1 {

    public int jump(int[] nums) {
        int ans = 0; // 跳槽次数
        int curUnlock = 0; // 以当前水平能入职的最高公司级别
        int maxUnlock = 0; // 当前可选公司最多能帮助候选人提到几级
        for (int i = 0; i < nums.length - 1; i++) { // 从前向后遍历公司，最高级公司(nums.length-1)是目标，入职后不再跳槽，所以不用看，故遍历范围是左闭右开区间[0,nums.length-1)
            maxUnlock = Math.max(maxUnlock, i + nums[i]); // 遍历每个公司并计算该公司最多可以提到几级(公司级别i+成长空间nums[i])，与之前的提级最高记录比较，打破记录则更新记录
            if (i == curUnlock) { // 基于当前水平的可选公司，选择跳槽到记录中可以提级最多的公司，以解锁更高级公司的入职权限
                curUnlock = maxUnlock; // 跳槽到了该公司，水平级别被提升
                ans++; // 记录跳槽了一次
            }
        }
        return ans; // 返回跳槽总次数
    }

}
