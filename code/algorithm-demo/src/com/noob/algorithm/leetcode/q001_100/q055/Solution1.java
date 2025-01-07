package com.noob.algorithm.leetcode.q001_100.q055;

/**
 * 🟡055.跳跃游戏 - https://leetcode.cn/problems/jump-game/
 */
public class Solution1 {

    // 思路：范围覆盖
    public boolean canJump(int[] nums) {
        // 校验特殊值，如果nums为1直接可达
        if (nums != null && nums.length == 1) {
            return true;
        }
        // 最大覆盖范围
        int cover = 0;
        // 遍历每个节点，在覆盖范围内去更新最大的覆盖范围
        for (int i = 0; i <= cover; i++) {
            // 更新最大的覆盖范围
            cover = Math.max(cover, i + nums[i]);
            // 覆盖范围是否大于终点下标，如果大则说明可达终点
            if (cover >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
