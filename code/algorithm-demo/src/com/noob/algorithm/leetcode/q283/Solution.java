package com.noob.algorithm.leetcode.q283;

import java.util.Arrays;

/**
 * 283.移动零
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        // 循环遍历，依次进行覆盖（指针记录当前覆盖的位置，指针后面的用0补齐）
        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                // 非0，覆盖
                nums[current] = nums[i];
                // 当前覆盖位置后移
                current++;
            }
        }
        // 从当前指针位置补0
        for(int i=current;i<nums.length;i++){
            nums[i]=0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        new Solution().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
