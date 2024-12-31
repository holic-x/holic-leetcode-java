package com.noob.algorithm.leetcode.q189;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 189.轮转数组
 */
public class Solution1 {

    public void rotate(int[] nums, int k) {
        // 定义结果集（将数组转为List）
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());

        // 计算反转轮次
        k = k % nums.length;

        // 反转整个数组
        Collections.reverse(list);
        // 反转前K个数据
        Collections.reverse(list.subList(0, k));
        // 反转后N-K个数据
        Collections.reverse(list.subList(k, list.size()));

        // 输出结果
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        Solution1 solution = new Solution1();
        solution.rotate(nums, k);
    }

}
