package com.noob.algorithm.leetcode.q001_100.q058;

import java.util.ArrayList;
import java.util.List;

/**
 * 🟢 058 最后一个单词的长度 - https://leetcode.cn/problems/length-of-last-word/description/
 */
public class Solution1 {

    /**
     * 思路分析：自定义字符串切割方法
     */
    public int lengthOfLastWord(String s) {
        // 去除首尾空格
        s = s.trim();
        // 切割字符串
        List<String> ans = new ArrayList<>(); // 存储切割的字符串
        StringBuffer word = new StringBuffer();// 临时存储切割的单词
        // 遍历字符串s，判断切割位置
        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch)) {
                // 如果为字母，则加入word
                word.append(ch);
            } else if (ch == ' ' && !word.toString().isEmpty()) { // 注意连续空格的问题，只有word不为空才加入结果集合
                // 如果是空格，则需进行截断
                ans.add(word.toString());
                word = new StringBuffer(); // 重置word
            }
        }
        // 需要将最后一个word加入集合
        ans.add(word.toString());

        // 返回最后一个单词的长度
        // return word.length();
        return ans.isEmpty() ? 0 : ans.get(ans.size() - 1).length();
    }
}
