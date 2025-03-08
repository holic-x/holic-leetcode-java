package com.noob.algorithm.leetcode.q101_200.q151;


/**
 * 🟡 151 反转字符串中的单词 - https://leetcode.cn/problems/reverse-words-in-a-string/description/
 */
public class Solution3 {

    /**
     * eg：s = "the sky is blue " 反转后："blue is sky the"
     * 思路：字符串切割（split） + 反转（reverse）+ 拼接（join）
     */
    public String reverseWords(String s) {
        // ① 首尾去除空格
        s = s.trim();
        // ② 字符串切割
        String[] strs = s.split("\\s+"); //  s.split(" ") 单个空格切分
        // ③  反转(不借助API，通过双指针法自定义反转)
        reverse(strs);
        // ④ 拼接
        String res = String.join(" ", strs);
        // 返回结果
        return res;
    }

    // 自定义反转法
    private void reverse(String[] strs) {
        int left = 0, right = strs.length - 1;
        while (left < right) {
            String temp = strs[left];
            strs[left] = strs[right];
            strs[right] = temp;
            // 指针移动
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Solution3 s = new Solution3();
        System.out.println(s.reverseWords("the sky is blue "));
    }
}
