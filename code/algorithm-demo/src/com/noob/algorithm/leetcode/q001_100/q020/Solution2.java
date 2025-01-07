package com.noob.algorithm.leetcode.q001_100.q020;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 🟢 20.有效的括号 - https://leetcode.cn/problems/valid-parentheses/
 * 思路：栈（存储匹配的左括号，左括号压栈）
 */
public class Solution2 {

    // 思路：栈操作
    public boolean isValid(String s) {
        // 定义Map存储成对的括号映射(Map<右括号,左括号>)
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        // 定义栈进行辅助
        Stack<Character> stack = new Stack<Character>();
        // 循环遍历字符串进行校验（如果不在key集合中则执行入栈操作（说明是左括号，进行压栈），如果在key集合中则进行出栈并校验括号是否匹配）
        for(char c : s.toCharArray()) {
            if(map.containsKey(c)) {
                // 校验出栈操作(如果栈为空或者校验第一个出栈的括号校验不匹配(确保括号顺序)，则说明字符串无效)
                if(stack.isEmpty() || stack.peek() != map.get(c)) { // peek()方法 查看栈顶元素而不移除
                    return false;
                }
                // 执行出栈操作
                stack.pop(); // pop方法移除并返回栈顶元素
            }else{
                // 非右括号（左括号入栈）
                stack.push(c);
            }
        }
        // 校验最终stack中的元素，如果还存在元素则说明不匹配
        return stack.isEmpty();
    }
}
