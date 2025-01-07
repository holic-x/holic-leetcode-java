package com.noob.algorithm.leetcode.q001_100.q034;

/**
 * 🟡 034.在排序数组中查找元素的第一个和最后一个位置 - https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
 * todo 边界问题待处理......
 *
 * 问题分析：
 * 出现边界问题在于数组元素存在重复元素，因此获取得到的mid不一定是最左或者最右的target（nums长度不定，target个数不定，因此拿到的mid位置不定，
 * 如果单纯通过二分检索的方法正序、逆序拿到mid位置不一定是第一个或者最后一个target，因此得到的结果就出错了
 */
public class Solution2Error {

    // 二分查找法：正向一次二分查找左边界、反向一次二分查找右边界
    public int[] searchRange(int[] nums, int target) {
        // 获取左边界
        int leftIndex = binarySearch(nums, target);

        // 反转数组
        int[] reverseNums = new int[nums.length];
        int idx = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            reverseNums[idx++] = nums[i];
        }
        // 获取右边界
        int rightIndex = binarySearch(reverseNums, target);

        if (leftIndex != -1 && rightIndex != -1) {
            return new int[]{leftIndex - 1, nums.length - rightIndex + 1};
        } else {
            return new int[]{-1, -1};
        }
    }

    public int binarySearch(int[] nums, int target) {
        // 定义左右指针
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            // 定义中间节点位置
            int mid = left + (right - left) / 2;
            // 校验target
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            }
        }
        // 如果target不存在返回-1（如果是要返回下一个可插入位置则是return left）
        return -1;
    }

}
