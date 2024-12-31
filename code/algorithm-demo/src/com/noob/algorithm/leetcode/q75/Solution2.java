package com.noob.algorithm.leetcode.q75;

import java.util.ArrayList;
import java.util.List;

/**
 * 颜色分类
 */
public class Solution2 {

    // 冒泡排序（排序法）
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