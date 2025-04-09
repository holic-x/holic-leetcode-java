package com.noob.algorithm.leetcode.q001_100.q080;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 🟡 080 删除有序数组中的重复项II - https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/
 */
public class Solution1 {
    /**
     * 思路：计数法
     */
    public int removeDuplicates(int[] nums) {
        // 统计数组元素出现次数
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> ans = new ArrayList<>();
        // 遍历map
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int cnt = entry.getValue() > 2 ? 2 : entry.getValue(); // 大于2的出现次数只取2
            for (int i = 0; i < cnt; i++) {
                ans.add(entry.getKey()); // 收集结果
            }
        }
        // 最终转化为数组
        int[] ansArr = ans.stream().mapToInt(Integer::intValue).toArray();
        for (int i = 0; i < ansArr.length; i++) {
            nums[i] = ansArr[i];
        }
        return ansArr.length;
    }
}
