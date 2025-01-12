package com.noob.algorithm.leetcode.q701_800.q763;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 🟡763 划分字母区间 - https://leetcode.cn/problems/partition-labels/
 */
public class Solution1 {

    /**
     * 思路分析：关注【每个字母最多出现在一个片段中】这个切割条件
     * - ① 可能的切割位置：每个字母的最后一次出现的位置
     * - ② 实际的切割位置：已出现的字母序列中的最后一次出现的位置的最大值，当遍历到这个位置可以进行切割（可以确保字母只在当前片段中出现）
     */
    public List<Integer> partitionLabels(String s) {
        // 第1次遍历：统计每个字母字符的最后一次的出现位置
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        List<Integer> res = new ArrayList<>();

        // 第2次遍历：寻找实际的切割位置
        //  int maxIdx = -1; // 存储已出现的字母序列中最后一次出现的位置的最大值
        int maxIdx = 0; // 存储已出现的字母序列中最后一次出现的位置的最大值
        int preCutIdx = -1; // 记录上一次的切割位置，用于划分切割区域
        for (int i = 0; i < s.length(); i++) {
            // 更新已出现的字母的出现位置的最大值
            maxIdx = Math.max(maxIdx, map.get(s.charAt(i)));
            if (i == maxIdx) {
                // 如果遍历到当前的最大切割位置，则进行切割操作
                res.add(maxIdx - preCutIdx);
                preCutIdx = i;
            }
//            // 更新已出现的字母的出现位置的最大值
//            maxIdx = Math.max(maxIdx, map.get(s.charAt(i)));
        }

        // 返回结果
        return res;
    }
}
