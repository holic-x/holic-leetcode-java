package com.noob.algorithm.leetcode.q401_500.q496;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 🟢 496 下一个更大元素I - https://leetcode.cn/problems/next-greater-element-i/description/
 */
public class Solution1 {

    /**
     * 思路转化：
     * ① 找到nums1中每个元素在nums2的位置
     * ② 确定对应位置的下一个更大的元素值
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;

        // ① 将nums1放入map（<元素，索引>），便于遍历nums2时快速判断元素是否存在于nums1中，存在则封装结果
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len1; i++) {
            map.put(nums1[i], i);
        }

        int[] ans = new int[len1];
        Arrays.fill(ans, -1);
        // 遍历nums2，寻找每个元素的第1个比它大的元素，如果元素在map中存在则封装结果
        Stack<Integer> stack = new Stack<>(); // 栈顶->栈底 递增
        stack.push(0); // 初始化
        for (int i = 1; i < len2; i++) {
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                // 判断当前处理元素(top)在map是否存在，存在则封装
                if (map.containsKey(nums2[stack.peek()])) {
                    ans[map.get(nums2[stack.peek()])] = nums2[i];
                }
                stack.pop();
            }
            stack.push(i);
        }

        // 返回结果
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 1, 2};
        int[] nums2 = new int[]{1, 3, 4, 2};
        Solution496_02 solution = new Solution496_02();
        solution.nextGreaterElement(nums1, nums2);
    }

}
