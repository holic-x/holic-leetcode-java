package com.noob.algorithm.leetcode.q101_200.q150;

import java.util.Stack;

/**
 * 🟡 150 逆波兰表达式求值 - https://leetcode.cn/problems/evaluate-reverse-polish-notation/description/
 */
public class Solution1 {

    /**
     * 思路分析：
     * 基于栈辅助操作，栈中存储操作数，如果遇到操作符号则取出两个操作数进行处理(加减乘除)后再将结果入栈
     */
    public int evalRPN(String[] tokens) {
        // 构建栈辅助存储
        Stack<String> stack = new Stack<>();

        // 遍历tokens
        for (String token : tokens) {
            // 校验token
            if ("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)) {
                // 取出操作数和操作符号
                int num2 = Integer.valueOf(stack.pop());
                int num1 = Integer.valueOf(stack.pop());
                // 计算操作结果
                int tmpRes = 0;
                switch (token) {
                    case "+": {
                        tmpRes = num1 + num2;
                        break;
                    }
                    case "-": {
                        tmpRes = num1 - num2;
                        break;
                    }
                    case "*": {
                        tmpRes = num1 * num2;
                        break;
                    }
                    case "/": {
                        tmpRes = num1 / num2;
                        break;
                    }
                }
                stack.push(String.valueOf(tmpRes));
            } else {
                stack.push(token);
            }
        }

        // 最终栈留存元素即为结果
        return Integer.valueOf(stack.peek());
    }
}
