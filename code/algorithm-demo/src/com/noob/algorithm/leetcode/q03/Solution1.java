package com.noob.algorithm.leetcode.q03;

import java.util.HashSet;

/**
 * 003 无重复最长子串
 * 思路1：暴力拆解法
 */
public class Solution1 {

    /**
     * 核心思路：循环遍历字符串，每次选定一个字符和子串进行比较，记录最长子串值
     */
    public int lengthOfLongestSubstring(String s) {
        // 定义结果
        int res = 0;

        int n = s.length();
        for(int i = 0; i < n; i++){
            // 依次判断子串中是否包含当前字符（子串的起点是从i开始，终点为j）
            for(int j = i + 1 ; j <= n; j++){
                // 判断子串是否包含重复字符，不包含则比较子串长度，选择最大值(需注意，此处的子串应为（i，j）这个范围的字符串，而非（j，n）)
                if(!judgeContainRepeatCharacter(s.substring(i,j))){
                    res = Math.max(res,j-i);
                }
            }
        }

        // 返回结果
        return res;
    }

    /**
     * 判断子串是否包含重复字符，可以通过Set集合（Set存储无序、不重复元素）
     */
    public boolean judgeContainRepeatCharacter(String subStr) {
        HashSet<Character> set = new HashSet<Character>();
        for(int i = 0; i < subStr.length(); i++){
            char c = subStr.charAt(i);
            if(set.contains(c)){
                return true;
            }
            set.add(c);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        String s1 = "abcabcbb";
        System.out.println(solution.lengthOfLongestSubstring(s1));

        String s2 = "bbbbbb";
        System.out.println(solution.lengthOfLongestSubstring(s2));

        String s3 = "pwwkew";
        System.out.println(solution.lengthOfLongestSubstring(s3));

        String s4 = "  ";
        System.out.println(solution.lengthOfLongestSubstring(s4));

        String s5 = "";
        System.out.println(solution.lengthOfLongestSubstring(s5));

        String s6 = " ";
        System.out.println(solution.lengthOfLongestSubstring(s6));
    }
}
