package com.noob.algorithm.leetcode.q001_100.q003;

import java.util.HashSet;

/**
 * 🟡 003 无重复最长子串
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 * 思路：滑动窗口
 * 使用一个HashSet来实现滑动窗口，用来检查重复字符。 维护开始和结束两个索引，默认都是从0开始，然后随着循环【向右移动结束索引】，遇到不是重复字符则放入窗里，遇到重复字符则【向右侧移动开始索引】，最终得到结果
 */
public class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        // 定义结果
        int res = 0;

        // 定义左右指针，初始化从0开始
        int left = 0,right = 0;

        // 定义用于判断重复的Set集合（窗口）（因为要获取的是长度，所以不用考虑集合元素的有序性）
        HashSet<Character> set = new HashSet<Character>();

        int n = s.length();
        while (left < n && right < n) {
            // 判断当前窗口是否满足要求，进而决定指针移动位置
            if(!set.contains(s.charAt(right))) {
                // 更新窗口，将right指针右移
                set.add(s.charAt(right++));
            }else{
                // 存在重复元素，直接移除（此处只考虑窗口元素个数，不考虑有序性），并将left指针右移
                set.remove(s.charAt(left++));
            }
            // 更新当前窗口的最大值
            res = Math.max(res, set.size());
        }
        return res;
    }
}
