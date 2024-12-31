package com.noob.algorithm.leetcode.q20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20.有效的括号
 * 思路：栈（存储匹配的左括号，左括号压栈）
 */
public class Solution {


    // 思路：替换法
    public boolean isValid02(String s) {
        /**
         * 既然括号不能嵌套出现，那么只需要依次去除成对的括号，看最终是否剩余元素
         * 由于并不知道哪些括号包含其他括号，因此每次去除都直接覆盖所有情况，去掉成对的括号，然后校验剩余的括号是否可以组成成对的括号进行移除
         * 以此类推
          */

        while(s.contains("[]")||s.contains("{}")||s.contains("()")){
            s = s.replace("[]","");
            s = s.replace("{}","");
            s = s.replace("()","");
        }
        // 最终返回空字符串则说明字符串有效
        return s.equals("");
    }

    // 思路：栈操作
    public boolean isValid01(String s) {
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
