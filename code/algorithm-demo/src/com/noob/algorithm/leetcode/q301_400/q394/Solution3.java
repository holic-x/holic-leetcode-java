package com.noob.algorithm.leetcode.q301_400.q394;

import java.util.Stack;

/**
 * 🟡 394 字符串解码 - https://leetcode.cn/problems/decode-string/
 */
public class Solution3 {

    /**
     * 思路分析：3[a]2[bc] => aaa bc bc
     */
    public String decodeString(String s) {

        // 构建栈辅助遍历(分别压入重复次数和对照的重复字符串)
        Stack<Integer> cntStack = new Stack<>();
        Stack<String> strStack = new Stack<>();

        // 存储临时变量(临时变量用于记录当前正在处理的数字、字符串)
        int repeatNum = 0;
        StringBuffer repeatStr = new StringBuffer();

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) { // 数字校验：x >= '0' && x <= '9'
                // 处理连续数字
                repeatNum = repeatNum * 10 + (ch - '0'); // 注意char类型和int的转化
            } else if (Character.isLetter(ch)) {
                // 处理连续字母
                repeatStr.append(ch);
            } else if ('[' == ch) {
                // 分别将重复次数和对应的字符串压栈，并重置临时变量
                cntStack.push(repeatNum);
                strStack.push(repeatStr.toString());
                // 重置临时变量，用作下一组处理
                repeatNum = 0;
                repeatStr = new StringBuffer();
            } else if (']' == ch) {
                // 分别取出栈顶元素，做repeat处理，并封装处理临时处理结果，将得到的临时结果作为repeatStr（处理嵌套情况）
                int curRepeatNum = cntStack.pop(); // 获取重复次数
                StringBuffer temp = new StringBuffer(strStack.pop()); // 获取待执行重复的字符串
                for (int i = 0; i < curRepeatNum; i++) {
                    temp.append(repeatStr); // 拼接处理
                }
                repeatStr = temp; // 获取新的临时处理字符串
            } else {
                // 其他字符正常入栈
                repeatStr.append(ch);
            }
        }

        // 返回结果
        return repeatStr.toString();
    }

}
