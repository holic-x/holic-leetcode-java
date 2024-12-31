package com.noob.algorithm.leetcode.q34;

/**
 * 34.在排序数组中查找元素的第一个和最后一个位置
 */
public class Solution {

    // 暴力法：循环遍历数组，一次进行校验
    public int[] searchRange(int[] nums, int target) {
        // 定义结果集(开始索引,结束索引)
        int[] res = {-1,-1};
        // 定义target在数组中的匹配个数(计数器)
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if(count == 0){
                    // 表示第一个检索到的匹配元素，将其加入结果集
                    res[0] = i;
                }
                count++;
            }
        }
        // 最终封装结果集并返回
        if(res[0] != -1){
            res[1] = res[0] + count -1;
        }
        return res;
    }

}
