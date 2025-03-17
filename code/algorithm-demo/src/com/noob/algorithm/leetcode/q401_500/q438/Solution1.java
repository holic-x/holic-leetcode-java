package com.noob.algorithm.leetcode.q401_500.q438;

import java.util.ArrayList;
import java.util.List;

/**
 * 🟡 438 找到字符串中的所有字母异位词 - https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/
 */
public class Solution1 {

    /**
     * 找到s中所有p的异位词的子串，返回子串的起始索引
     * 字母异位词的字符出现次数是一致的，基于此构建滑动窗口进行处理
     */
    public List<Integer> findAnagrams(String s, String p) {
        // 定义结果集
        List<Integer> ans = new ArrayList<>();

        int sLen = s.length(), pLen = p.length();
        // 如果长度不满足则说明无异位词子串
        if (sLen < pLen) {
            return new ArrayList<>();
        }
        // 定义数组计算窗口内、p字符串中的字母出现次数
        int[] pCnt = new int[128];
        int[] winCnt = new int[128];

        // 初始化计算指定范围内的字符出现次数
        // 初始化pCnt\winCnt
        for (int i = 0; i < pLen; i++) {
            pCnt[p.charAt(i)]++;
            winCnt[s.charAt(i)]++;
        }

        // 初始化校验异位词子串
        if (valid(pCnt, winCnt)) { // Arrays.equals(pCnt, winCnt)
            ans.add(0); // 初始化子串索引left位置为0，如果满足将其加入结果集
        }

        // 遍历字符串s
        int left = 0;
        for (int right = pLen; right < sLen; right++) {
            // 将right指向字符纳入窗口，移出left指向字符，校验异位词子串
            winCnt[s.charAt(right)]++;
            winCnt[s.charAt(left)]--;
            left++; // 指针移动
            // 校验异位词子串
            if (valid(pCnt, winCnt)) {
                ans.add(left); // 初始化子串索引left位置为0，如果满足将其加入结果集
            }
        }

        // 返回结果
        return ans;
    }

    // 校验异位词子串
    private boolean valid(int[] pCnt, int[] winCnt) {
        for (int i = 0; i < 128; i++) {
            if (pCnt[i] != winCnt[i]) {
                return false;
            }
        }
        return true;
    }
}
