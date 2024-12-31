package com.noob.algorithm.leetcode.q739;

/**
 * 739.每日温度
 */
public class Solution1
{
    // 思路：暴力双层循环+计数
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        // 循环数组元素，看后面比它大的下一个元素出现在哪个位置
        for(int i = 0; i < temperatures.length; i++){
            for(int j = i+1; j < temperatures.length; j++){
                if(temperatures[j] > temperatures[i]){
                    res[i] = j-i;
                    // 找到第一个比它高的气温即可退出当前循环
                    break;
                }
            }
        }
        // 返回结果
        return res;
    }
}
