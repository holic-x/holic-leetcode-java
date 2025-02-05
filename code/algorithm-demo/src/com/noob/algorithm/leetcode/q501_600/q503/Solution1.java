package com.noob.algorithm.leetcode.q501_600.q503;

import java.util.Arrays;
import java.util.Stack;

/**
 * 🟡 503 下一个更大元素II - https://leetcode.cn/problems/next-greater-element-ii/description/
 */
public class Solution1 {

    /**
     * 思路分析：平展数组，转化为求一维数组的下一个更大的元素
     */
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        // ① 平展数组
        int[] dn = new int[2 * n];
        for (int i = 0; i < n; i++) {
            dn[i] = nums[i];
            dn[n + i] = nums[i];
        }
        // ② 求新数组dn中[0,n-1]范围的下一个更大的数
        Stack<Integer> st = new Stack<>(); // 栈顶->栈底（单调递增，存储索引）
        st.push(0); // 初始化
        int[] ans = new int[2 * n];
        Arrays.fill(ans, -1);
        for (int i = 0; i < dn.length; i++) {
            while (!st.isEmpty() && dn[st.peek()] < dn[i]) {
                ans[st.peek()] = dn[i];
                st.pop();
            }
            st.push(i);
        }
        // 返回结果
        return Arrays.copyOfRange(ans, 0, n);
    }

}
