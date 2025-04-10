package com.noob.algorithm.leetcode.q001_100.q075;

import java.util.Map;
import java.util.TreeMap;

/**
 * 🟡 075 颜色分类 -  https://leetcode.cn/problems/sort-colors/description/
 */
public class Solution075_01 {

    /**
     * 红白蓝(0、1、2)三色，按照红白蓝颜色排序,让相同颜色的元素相邻
     * 思路：计数法
     */
    public void sortColors(int[] nums) {
        // 计数法
        Map<Integer, Integer> map = new TreeMap<>(); // 自然排序
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 遍历集合回填元素
        int cur = 0; // 填充指针
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int cnt = entry.getValue();
            while (cnt-- > 0) {
                nums[cur++] = entry.getKey();
            }
        }
    }
}
