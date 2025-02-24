package com.noob.algorithm.leetcode.q001_100.q084;

import java.util.Stack;

/**
 * 🔴 084 柱状图中最大的图形 - https://leetcode.cn/problems/largest-rectangle-in-histogram/description/
 */
public class Solution1 {

    /**
     * 思路分析：单调栈
     * - ① 单调栈存储什么内容？=>元素索引下标
     * - ② 单调栈元素顺序？=> 栈顶到栈底（降序：从大到小）
     * - ③ 遍历栈顶元素h[top]和当前遍历元素h[i]
     * - a. h[top] < h[i] 入栈
     * - b. h[top] = h[i] 入栈
     * - c. h[top] > h[i] 依次弹出栈顶元素并处理，直到不满足条件
     * - - - 分别得到左右边界和高度，以计算矩形面积（第1个栈顶元素为高度、第2个栈顶元素左边界、当前遍历索引为右边界）
     * - - - area = w*h = (right-left+1) * h[mid];
     */
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int maxArea = 0;

        // 构建新数组（对height[]首位补位，简化边界讨论）
        int[] newH = new int[n + 2];
        System.arraycopy(heights, 0, newH, 1, n);
        newH[0] = 0;
        newH[newH.length - 1] = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(0); // 初始化栈

        // 遍历元素
        for (int i = 1; i < newH.length; i++) {
            if (newH[stack.peek()] <= newH[i]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && newH[stack.peek()] > newH[i]) {
                    int midIdx = stack.pop();
                    int leftIdx = stack.peek();
                    int rightIdx = i;
                    int w = rightIdx - leftIdx - 1;
                    int h = newH[midIdx];
                    maxArea = Math.max(maxArea, w * h);
                }
                // 元素入栈
                stack.push(i);
            }
        }
        // 返回可构成的最大矩形面积
        return maxArea;
    }
}
