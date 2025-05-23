package com.noob.algorithm.leetcode.q001_100.q035;

/**
 * 🟢 035.二分查找（搜索插入位置） - https://leetcode.cn/problems/search-insert-position/description/
 */
public class Solution3 {

    /**
     * 思路3: 双指针、开区间（(start,end)）
     */
    public int searchInsert(int[] nums, int target) {
        // 调用二分法进行检索，如果目标值不存在于数组，则返回将会被按顺序插入的位置

        // 定义左右区间指针
        int start = -1, end = nums.length; // ① 开区间取值范围限定
        // 当两个指针相遇循环结束
        while (start + 1 < end) { // ② start从-1开始取值，且不能取到len，因此此处是<
            // 定义中位数指针
            int mid = (start + end) / 2;
            if (target == nums[mid]) {
                // 如果目标值存在则直接返回
                return mid;
            } else if (target < nums[mid]) {
                // 如果目标在左区间，调整end指针
                end = mid; // ③ 因为右侧取得是开区间，因此此处是mid
            } else if (target > nums[mid]) {
                // 如果目标在右区间，调整start指针
                start = mid; // ④ 因为左侧取得是开区间，因此此处是mid
            }
        }
        // 如果目标不存在，返回目标按顺序插入的位置（可结合画图理解）
        return end; // ⑤ 返回end位置
    }

}