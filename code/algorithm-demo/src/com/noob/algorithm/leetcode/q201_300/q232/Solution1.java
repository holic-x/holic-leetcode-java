package com.noob.algorithm.leetcode.q201_300.q232;

import java.util.Stack;

/**
 * 🟢 232 用栈实现队列 - https://leetcode.cn/problems/implement-queue-using-stacks/description/
 */
public class Solution1 {

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1); // [1]
        queue.push(2); // [1 2]
        queue.peek(); // [1 2] - 1
        queue.pop(); // [2] - 1
        queue.empty(); // [2]
    }

}


class MyQueue {

    // 双栈实现队列
    Stack<Integer> inputStack; // 输入栈
    Stack<Integer> outputStack; // 输出栈

    public MyQueue() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

    // 新增元素
    public void push(int x) {
        inputStack.push(x);
    }

    // 弹出元素
    public int pop() {
        // 校验输出栈中是否存在元素，如果不存在则从输入栈中更新后弹出
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
        return outputStack.pop();
    }

    // 获取元素但不弹出
    public int peek() {
        // 校验输出栈中是否存在元素，如果不存在则从输入栈中更新后弹出
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
        return outputStack.peek();
    }

    // 校验队列是否为空（只有两个栈都为空时才为空）
    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }

}
