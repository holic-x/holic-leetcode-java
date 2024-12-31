package com.noob.algorithm.leetcode.q34;

import java.util.Arrays;

/**
 * 34.在排序数组中查找元素的第一个和最后一个位置
 * todo 边界问题待处理......
 */
public class Solution1 {

    // 二分查找法：正向一次二分查找左边界、反向一次二分查找有边界
    public int[] searchRange(int[] nums, int target) {
        // 获取左边界
        int leftIndex = binarySearch1(nums,target);

        // 反转数组
        int[] reverseNums = new int[nums.length];
        int index=0;
        for(int i=nums.length-1;i>0;i--){
            reverseNums[index++]=nums[i];
        }
        // 获取右边界
        int rightIndex = binarySearch1(reverseNums,target);

        if(leftIndex != -1 && rightIndex != -1){
            return new int[]{leftIndex-1, nums.length-rightIndex+1};
        }else{
            return new int[]{-1, -1};
        }
    }

    public int binarySearch1(int[] nums, int target) {
        // 定义左右指针
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            // 定义中间节点位置
            int mid = left + (right - left) / 2;
            // 校验target
            if (nums[mid] == target) {
                return mid;
            }else if(target < nums[mid]){
                right = mid - 1;
            }else if(target > nums[mid]){
                left = mid + 1;
            }
        }
        // 如果target不存在返回-1（如果是要返回下一个可插入位置则是return left）
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        Solution1 solution1 = new Solution1();
        Arrays.stream(solution1.searchRange(nums, 8)).forEach(System.out::println);
    }

}
