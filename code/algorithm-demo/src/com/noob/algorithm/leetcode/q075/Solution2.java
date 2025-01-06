package com.noob.algorithm.leetcode.q075;

/**
 * 🟡 075 颜色分类 - https://leetcode.cn/problems/sort-colors/description/
 */
public class Solution2 {

    /**
     * 思路：排序思路（红白蓝：分别对应0 1 2），此处采用冒泡排序（排序法）
     */
    public void sortColors(int[] nums) {
       for(int i=0;i<nums.length;i++) {
           for(int j=i+1;j<nums.length;j++) {
               if(nums[i]>nums[j]) {
                   // 交换元素
                   int temp = nums[i];
                   nums[i] = nums[j];
                   nums[j] = temp;
               }
           }
       }
    }

}