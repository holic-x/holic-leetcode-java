package com.noob.algorithm.leetcode.q201_300.q224;

import java.util.Stack;

/**
 * 🔴 224 基本计算器.https://leetcode.cn/problems/basic-calculator/
 */
public class Solution1 {

    /**
     * 给定一个字符串表达式 s ，实现一个基本计算器来计算并返回它的值
     */
    public int calculate(String s) {
        // 构建栈辅助存储(操作数和操作符号:操作数用Integer表示，操作符号用+1、-1表示，统一入栈格式)
        Stack<Integer> stack = new Stack<Integer>();

        int tmpRes = 0, sign = 1; // tmpRes 表示表达式计算的临时结果，sign 表示当前的操作符号

        // 遍历字符串
        char[] sArr = s.toCharArray();
        int len = sArr.length;
        for (int i = 0; i < len; i++) {
            char curCh = sArr[i];
            // 根据数字、操作符、括号（左右括号）分类讨论
            if (Character.isDigit(curCh)) {
                int curVal = curCh - '0'; // 需要将字符转数字
                // 如果是数字，则需判断其后一位是否存在（直到遇到非数字），组成一个完整的数字
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    // 拼接更新当前的数字
                    curVal = curVal * 10 + (s.charAt(i + 1) - '0'); // Integer.valueOf(s.charAt(i + 1) - '0') 等价于 `s.charAt(i + 1) - '0'`
                    // 计算完成，i 继续往前
                    i++;
                }
                // 将结果进行累加
                tmpRes += sign * curVal; // 表示加上当前数字或者减去当前数字（sign为1表示加、sign为-1表示减）
            } else if (curCh == '+' || curCh == '-') {
                // 如果是操作符号则更新sign
                sign = (curCh == '+' ? 1 : -1);
            } else if (curCh == '(' || curCh == ')') {
                // 如果是左括号或者右括号则分情况讨论
                if (curCh == '(') {
                    // 将当前操作临时结果和符号入栈
                    stack.push(tmpRes);
                    stack.push(sign);
                    // 重置表达式计算结果和符号
                    tmpRes = 0;
                    sign = 1;
                } else if (curCh == ')') {
                    // 从栈中取出操作符号和上一个操作表达式结果与当前的tmpRes做计算
                    int prevSign = stack.pop();
                    int prevNum = stack.pop();
                    tmpRes = prevNum + prevSign * tmpRes;
                }
            }
        }
        // 返回结果
        return tmpRes;
    }

}
