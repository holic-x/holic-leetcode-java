package com.noob.algorithm.leetcode.q101_200.q151;


import java.util.Stack;

/**
 * 🟡 151 反转字符串中的单词 - https://leetcode.cn/problems/reverse-words-in-a-string/description/
 */
public class Solution4 {

    /**
     * eg：s = "the sky is blue " 反转后："blue is sky the"
     * 思路：自定义切割、反转逻辑
     * 借助StringBuffer存储每个word、借助栈存储每个word
     */
    public String reverseWords(String s) {
        // 取出首尾巴空格
        s = s.trim();

        // ① 处理单词
        // 定义栈存储word数据
        Stack<String> stack = new Stack<>();
        // 定义StringBuffer类型存储每个word（当遇到空格的时候则进行截断，注意排除首尾空格）
        StringBuffer word = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                // 遇到空格，截断字符串，将当前字符串入栈并重置buffer
                if (!"".equals(word.toString())) { // 注意此处是为了处理相邻字母有多个空格的情况（因为空格不会被加入word，因此如果遇到空格的时候word为空的话说明出现了连续空格）
                    stack.push(word.toString());
                    word = new StringBuffer();
                }
            } else {
                // 遇到非空格，正常拼接word
                word.append(s.charAt(i));
            }
        }
        // 将最后的缓冲区的word入栈
        stack.push(word.toString());

        // ② 处理stack中的结果
        StringBuffer res = new StringBuffer();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
            // 如果栈不为空(说明后面还有元素)，则添加拼接符
            if (!stack.isEmpty()) {
                res.append(" ");
            }
        }

        // 返回结果
        return res.toString();
    }


    public static void main(String[] args) {
        Solution4 s = new Solution4();
//        System.out.println(s.reverseWords("the sky is blue "));
        System.out.println(s.reverseWords("example   good a"));
    }
}
