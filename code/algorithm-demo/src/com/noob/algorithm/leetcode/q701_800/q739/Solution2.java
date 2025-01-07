package com.noob.algorithm.leetcode.q701_800.q739;

import java.util.Stack;

/**
 * 739.每日温度
 */
public class Solution2
{
    // 思路：单调递减栈
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];

        // 定义辅助单调递减栈
        Stack<Integer> stack = new Stack<Integer>();

        // 循环数组元素，看后面比它大的下一个元素出现在哪个位置
        for(int i = 0; i < temperatures.length; i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                // 当出现比当前栈顶元素要大的元素(top<cur)则需将top弹出,直到不满足条件，并将cur索引入栈，更新res
                int preIndex = stack.pop();
                res[preIndex] = i - preIndex;
            }
            // 如果栈为空或者栈顶元素指向索引位置比当前元素小则直接将元素索引入栈
            stack.push(i);
        }
        // 返回结果
        return res;
    }
}
