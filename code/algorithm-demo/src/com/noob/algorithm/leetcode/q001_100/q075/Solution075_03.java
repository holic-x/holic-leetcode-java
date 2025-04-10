package com.noob.algorithm.leetcode.q001_100.q075;

/**
 * 🟡 075 颜色分类 -  https://leetcode.cn/problems/sort-colors/description/
 */
public class Solution075_03 {

    /**
     * 红白蓝(0、1、2)三色，按照红白蓝颜色排序,让相同颜色的元素相邻
     * 思路：三指针
     */
    public void sortColors(int[] nums) {
        int cur = 0; // 指向当前遍历位置（负责处理1和交换后的新元素， 将元素分类到正确的区域）
        int left = 0; // 指向0的右边界（left左侧全是0）
        int right = nums.length - 1; // 指向2的左边界（right右侧全是2）
        while (cur <= right) { // 只需要遍历到right边界（因为在处理过程中right右侧已经排好）
            // 此处处理确保（left,right）的元素是1，也就是说如果遇到0或者2要进行交换并移动指针
            if (nums[cur] == 0) {
                swap(nums, cur, left); // 交换
                left++;
                cur++; // 交换后nums[cur]只能是0或1，可以直接移动
            } else if (nums[cur] == 2) {
                swap(nums, cur, right);
                right--; // 交换后nums[cur]可能是0、1、2，因此不能直接移动cur，还需再次检查
            } else {
                // 当前元素是1，直接跳过（在限定的(left,right)之间）
                cur++;
            }
        }
    }

    // 交换元素
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
