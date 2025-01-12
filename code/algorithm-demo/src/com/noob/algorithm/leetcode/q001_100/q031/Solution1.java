package com.noob.algorithm.leetcode.q001_100.q031;

import java.util.Arrays;

/**
 * 🟡 31.下一个排列 - https://leetcode.cn/problems/next-permutation/
 */
public class Solution1 {

    public void nextPermutation(int[] nums) {

        // 定义序列标识，是否存在下一个序列
        boolean flag = false;

        // 1.确定可变大的交换位置（逆序找到第一个降序序列）
        int swapIndex = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            // 判断 i 与 i-1 是否出现降序，如果出现则说明此处i-1位置可以进行交换
            if (nums[i] > nums[i - 1]) {
                swapIndex = i - 1; // 此处为避免混乱，可记录可交换的位置swapIndex（即为对应i-1的位置）
                // 找到第一个降序序列就跳出循环，否则会影响执行流程（或者直接将后面的步骤放在这里执行）
                flag = true; // 表示存在可交换位置
                break;
            }
        }
        // 如果存在可交换位置
        if (flag) {
            // 2.对swapIndex之后的序列进行遍历，获取到尽可能小的大数进行交换（先升序排序，随后找到第一个比swapIndex大的数即可）
            Arrays.sort(nums, swapIndex + 1, nums.length);
            for (int j = swapIndex; j < nums.length; j++) {
                if (nums[j] > nums[swapIndex]) {
                    // 将当前两个元素进行交换
                    int temp = nums[swapIndex];
                    nums[swapIndex] = nums[j];
                    nums[j] = temp;
                    // 操作完成跳出循环
                    break;
                }
            }
            // 3.再次对交换位置后面的序列进行排序
            Arrays.sort(nums, swapIndex + 1, nums.length);
        } else {
            // 不存在下一个更大的序列，需重排为最小序列
            Arrays.sort(nums);
        }
    }

}
