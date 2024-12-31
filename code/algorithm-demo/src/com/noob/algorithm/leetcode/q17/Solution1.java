package com.noob.algorithm.leetcode.q17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17.电话号码的字母组合
 * 思路：回溯法
 */
public class Solution1 {

    // 定义Map哈希表存储数字和对应字母
    Map<Character, String> phoneMap = new HashMap<Character,String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    // 定义结果集和临时存储的结果字符串
    List<String> res = new ArrayList<>();
    StringBuffer buffer = new StringBuffer();

    // 定义回溯方法
    public void backtrack(String digits, int index) {
        if (index == digits.length()) { // 如果处理完所有的数字，则将当前的字母组合加入到结果集合中
            res.add(buffer.toString()); // 添加满足的序列
        }
        else {
            // 获取当前数字对应的字母序列
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            // 遍历所有字母，对每一个字母，递归找出剩余数字的所有字母组合
            for (int i = 0; i < letters.length(); i++) {
                buffer.append(letters.charAt(i)); // 将当前字母添加到当前的字母组合中
                backtrack( digits, index+1);// 递归找出剩余数字的所有字母组合
                buffer.deleteCharAt(index);// 回溯，删除当前字母，便于尝试下一个字母
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        // 判断数组是否为空,数组为空直接返回空结果集
        if(digits.isEmpty()) {
            return res;
        }
        // 数组不为空，执行回溯
        backtrack(digits, 0);
        return res;
    }

    public static void main(String[] args) {
        String digits = "23";
        Solution1 solution = new Solution1();
        System.out.println(solution.letterCombinations(digits));

    }
}
