package com.noob.algorithm.leetcode.q501_600.q567;

import java.util.ArrayList;
import java.util.List;

/**
 * 🟡 567.字符串的排列 - https://leetcode.cn/problems/permutation-in-string/description/
 */
public class Solution1 {

    /**
     * 判断s2是否包含s1的排列（即判断s1的排列是否为s2的子串）
     * 思路：获取s1的排列，随后校验每个排列是否为s2的子串（s2是否包含该排列字符串）
     * - ❌ 超时（此处计算长字符串的全排列序列会导致超时）
     */
    public boolean checkInclusion(String s1, String s2) {
        // 获取s1的全排列
        backTrack(s1.toCharArray(), 0);
        // 校验s2中是否包含其全排列
        for (String str : list) {
            if (s2.contains(str)) {
                return true;
            }
        }
        // 不包含
        return false;
    }


    List<String> list = new ArrayList<>(); // 定义列表存储全排列数据集合
    StringBuffer buffer = new StringBuffer(); // 存储当前排列序列

    // 递归获取字符串s1的全排列
    private void backTrack(char[] chs, int idx) {
        if (buffer.length() == chs.length) {
            list.add(buffer.toString());
            return;
        }

        // 回溯处理
        for (int i = idx; i < chs.length; i++) {
            // 交换位置
            swap(chs, i, idx);
            buffer.append(chs[idx]);
            backTrack(chs, idx + 1);
            swap(chs, i, idx);
            buffer.deleteCharAt(buffer.length() - 1);
        }
    }

    // 交换位置
    private void swap(char[] chs, int i, int j) {
        char temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
    }

}
