package com.noob.algorithm.leetcode.q001_100.q017;

import java.util.*;

/**
 * 🟡 017.电话号码的字母组合 - https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/
 * 思路：队列法
 */
public class Solution2 {

    // 定义Map哈希表存储数字和对应字母
    Map<Character, String> phoneMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        // 如果digits为空直接返回空字符串
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        // digits 不为空
        List<String> res = new ArrayList<>();
        res.add(""); // 初始化空字符串入队
        for (int i = 0; i < digits.length(); i++) {
            // 获取当前元素及对应的字母序列
            String letters = phoneMap.get(digits.charAt(i));
            // 获取当前集合的大小（集合大小在后续循环操作过程中入队会变化，此处先记录当次循环结果集的大小）
            int resSize = res.size();
            // 将对应字母依次入队（在原有结果集基础上进行拼接）
            for (int j = 0; j < resSize; j++) {
                String s = res.remove(0); // 取出队首元素，然后依次和对应的字母序列进行拼接并将产生的结果入队
                for (int k = 0; k < letters.length(); k++) {
                    res.add(s + letters.charAt(k));
                }
            }
        }
        // 返回结果集
        return res;
    }
}
