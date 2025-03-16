package com.noob.algorithm.leetcode.q101_200.q162;

/**
 * 🟡 162 寻找峰值 - https://leetcode.cn/problems/find-peak-element/description/
 */
public class Solution1 {

    /**
     * 峰值元素：严格大于左右相邻值的元素；如果数组中包含多个峰值，则返回任意一个峰值的位置
     */
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        long INF = Long.MIN_VALUE; // 扩大测试覆盖范围，此处用long类型
        // 填充首尾数组
        long[] arr = new long[n + 2];
        arr[0] = INF;
        arr[n + 1] = INF;
        // 初始化数组
        // System.arraycopy(nums, 0, arr, 1, n);  数组复制
        for (int i = 0; i < nums.length; i++) {
            arr[i + 1] = nums[i];
        }
        // 遍历数组校验峰值
        for (int i = 1; i <= n; i++) {
            // 校验是否满足峰值，满足则返回
            if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                return i - 1; // 返回的索引应为原来的索引位置，所以此处应该为i-1
            }
        }
        // 没有满足的峰值
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
    }

}
