package com.noob.algorithm.leetcode.q287;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 🟡 287.寻找重复数 - https://leetcode.cn/problems/find-the-duplicate-number/description/
 */
public class Solution1 {

    // 思路：绝对值概念：暴力循环（双层循环依次比较元素，有点类似冒泡的方向）
    public int findDuplicate5(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

    // 集合判断（list、hashset）或者校验集合中元素是否存在
    public int findDuplicate4(int[] nums) {
        /*
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(list.contains(nums[i])) {
                return nums[i];
            }
            list.add(nums[i]);
        }
        return -1;
         */
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {  // 类似的，有set.contains(nums[i]);
                return nums[i];
            }
        }
        return -1;
    }

    // 计数：使用集合存储元素出现个数，遍历过程中判断次数是否大于1
    public int findDuplicate3(int[] nums) {
        // 定义数组存储元素出现个数，其中下标为对应元素
        int[] count = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            // 校验是否值是否大于1
            if (++count[nums[i]] > 1) { // 等价于count[nums[i]]++,if(count[nums[i]]>1){...}
                return nums[i];
            }
        }
        return -1;
    }

    // 排序：对数组元素进行排序，依次比较相邻两个元素是否相同，如果相同则说明有重复
    public int findDuplicate2(int[] nums) {
        // 排序
        Arrays.sort(nums);
        // 检验数组相邻两个元素是否相同
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * 绝对值概念：由于nums取值在[1,n]，取值均为正整数、且不重复，因此可以用绝对值思路
     * 将-1*Math.abs*(num[index])标记为数组元素，如果nums[index]已经为负数，则说明已经出现过了
     */
    public int findDuplicate1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]);
            // 判断是否小于0
            if (nums[index] < 0) {
                return index;
            } else {
                nums[index] = -1 * nums[index]; // 标记数组元素
            }
        }
        return 0;
    }

}
