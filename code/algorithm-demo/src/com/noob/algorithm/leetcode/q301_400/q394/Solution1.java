package com.noob.algorithm.leetcode.q301_400.q394;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 🟡 394.字符串解码 - https://leetcode.cn/problems/decode-string/
 */
public class Solution1 {


    /**
     * 栈思路：数字、[、字母依次进栈（这是一组待repeat的数据，以[进行分割），遇到]则出栈
     * 不足：对于嵌套的情况，这种思路还需进一步完善，无法处理嵌套的场景
     */
    public String decodeString(String s) {
        // 定义辅助栈存储数据
        Deque stack = new LinkedList();
        // 定义当前重复的字符串值和个数
        StringBuffer curNum = new StringBuffer();
        StringBuffer curString = new StringBuffer();
        // 定义结果
        StringBuffer res = new StringBuffer();
        // 遍历字符串
        for (char c : s.toCharArray()) {
            // 如果是数字、[、字母依次入栈
            if (c > '0' && c <= '9') {
                stack.push(c);
            } else if (Character.isLetter(c)) { // c>'a'&&c<'z'
                stack.push(c);
            } else if (c == '[') {
                stack.push('[');
            } else if (c == ']') {
                // 依次出栈，处理数据
                while (!"[".equals(String.valueOf(stack.peek()))) { // 此处需要将对象转化为字符串进行比较处理
                    // System.out.println("[".equals(stack.peek()));
                    // System.out.println("cur c:" + stack.peek());
                    // 字符依次出栈
                    curString.append(stack.pop()); // 此处出栈产生的字符出对比原有是逆序的
                }
                // "[" 字符出栈
                stack.pop();
                // 数字出栈（直到遇到非数字）
                while (stack.peek() != null && (Character) stack.peek() > '0' && (Character) stack.peek() < '9') {// while(!stack.isEmpty()) 需注意嵌套的情况
                    // 数字依次出栈
                    curNum.append(stack.pop());
                }
                // 处理重复序列，更新序列结果（需将数字和字符串进行反转，获取正确的值）
                res.append(genStr(Integer.valueOf(reverseString(curNum.toString())), reverseString(curString.toString())));
                // 重置临时值
                curNum = new StringBuffer();
                curString = new StringBuffer();
            }
        }

        // 返回最终结果
        return res.toString();
    }

    // 反转序列
    private String reverseString(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    // 根据重复次数和字符串生成字符序列
    private String genStr(int num, String s) {
        StringBuffer newStr = new StringBuffer();
        for (int i = 0; i < num; i++) {
            newStr.append(s);
        }
        return newStr.toString();
    }

}
