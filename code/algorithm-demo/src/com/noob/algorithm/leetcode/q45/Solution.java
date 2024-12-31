package com.noob.algorithm.leetcode.q45;

/**
 * 55.跳跃游戏II
 */
public class Solution {

    public int jump(int[] nums) {
        int ans = 0; // 跳槽次数
        int curUnlock = 0; // 当前你的水平能入职的最高公司级别
        int maxUnlock = 0; //当前可选公司最多能帮你提到几级
        for (int i = 0; i < nums.length - 1; i++) { //从前向后遍历公司，最高级公司(nums.length-1)是目标，入职后不再跳槽，所以不用看，故遍历范围是左闭右开区间[0,nums.length-1)
            maxUnlock = Math.max(maxUnlock, i + nums[i]); //计算该公司最多能帮你提到几级(公司级别i+成长空间nums[i])，与之前的提级最高记录比较，打破记录则更新记录
            if (i == curUnlock) { // 把你当前水平级别能选的公司都看完了，你选择跳槽到记录中给你提级最多的公司，以解锁更高级公司的入职权限
                curUnlock = maxUnlock; // 你跳槽到了该公司，你的水平级别被提升了
                ans++; //这里记录你跳槽了一次
            }
        }
        return ans; //返回跳槽总次数
    }


    // 思路：todo 范围覆盖(部分用例未覆盖)
    public int jump1(int[] nums) {
        // 如果数组长度为1则不需要走
        if (nums != null && nums.length == 1) {
            return 0;
        }

        // 最大覆盖范围
        int cover = 0;
        // 记录步数
        int steps = 0;
        // 遍历每个节点，在覆盖范围内去更新最大的覆盖范围
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(cover, i + nums[i]); // 更新最大的覆盖范围
            steps++; // 步数+1
            // 覆盖范围是否大于终点下标，如果大则说明可达终点
            if (cover >= nums.length - 1) {
                return steps;
            }
        }
        return steps;
    }
}
