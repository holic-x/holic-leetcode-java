package com.noob.algorithm.leetcode.q101_200.q151;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 🟡 151 反转字符串中的单词 - https://leetcode.cn/problems/reverse-words-in-a-string/description/
 */
public class Solution2 {

    /**
     * eg：s = "the sky is blue " 反转后："blue is sky the"
     * 思路：字符串切割（split） + 反转（reverse）+ 拼接（join）
     */
    public String reverseWords(String s) {
        // ① 首尾去除空格
        s = s.trim();
        // ② 字符串切割
        String[] strs = s.split("\\s+"); //  s.split(" ") 单个空格切分
        // ③  反转
        List<String> list = Arrays.asList(strs);
        Collections.reverse(list);
        // ④ 拼接
        String res = String.join(" ", list);
        // 返回结果
        return res;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.reverseWords("the sky is blue "));
    }
}
