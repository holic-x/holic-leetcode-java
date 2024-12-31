package com.noob.algorithm.leetcode.q35;

/**
 * 35.二分查找（搜索插入位置）
 */
public class Solution {

    /**
     * 双指针
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        // 调用二分法进行检索，如果目标值不存在于数组，则返回将会被按顺序插入的位置

        // 定义左右区间指针
        int start = 0, end = nums.length - 1;
        // 当两个指针相遇循环结束
        while(start <= end) {
            // 定义中位数指针
            int mid = (start + end ) / 2;
            if(target == nums[mid]) {
                // 如果目标值存在则直接返回
                return mid;
            }else if(target<nums[mid]) {
                // 如果目标在左区间，调整end指针
                end = mid - 1;
            }else if(target>nums[mid]){
                // 如果目标在右区间，调整start指针
                start = mid + 1;
            }
        }
        // 如果目标不存在，返回目标按顺序插入的位置（可结合画图理解）
        return start;
    }

}