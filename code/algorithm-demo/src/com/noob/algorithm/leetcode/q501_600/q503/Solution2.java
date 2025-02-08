package com.noob.algorithm.leetcode.q501_600.q503;

import java.util.Arrays;
import java.util.Stack;

/**
 * 🟡 503 下一个更大元素II - https://leetcode.cn/problems/next-greater-element-ii/description/
 */
public class Solution2 {

    /**
     * 思路分析：多次循环，巧用下标取余
     */
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>(); // 栈顶->栈底（单调递增，存储索引）
        st.push(0); // 初始化
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        // 遍历数组（此处遍历2遍数组）
        for (int i = 0; i < 2 * n; i++) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i % n]) {
                ans[st.peek()] = nums[i % n];
                st.pop();
            }
            st.push(i % n);
        }
        // 返回结果
        return Arrays.copyOfRange(ans, 0, n);
    }

}
