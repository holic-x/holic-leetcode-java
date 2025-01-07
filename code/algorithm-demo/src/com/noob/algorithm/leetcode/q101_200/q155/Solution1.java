package com.noob.algorithm.leetcode.q101_200.q155;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 🟡 155.最小栈 - https://leetcode.cn/problems/min-stack/description/
 */
public class Solution1 {

    public static void main(String[] args) {
        /*
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();  // --> 返回 -3.
        minStack.pop();
        minStack.top();     // --> 返回 0.
        minStack.getMin();  // --> 返回 -2.
         */

        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());  // --> 返回 -3.
        minStack.pop();
        System.out.println(minStack.top());  // --> 返回 0.
        System.out.println(minStack.getMin()); // --> 返回 -2.
    }

}

// 思路1：用单个栈完成，每次出栈入栈操作都在栈顶维护当前栈的最小值
// 思路2：借助辅助栈，每次出栈入栈操作都同步维护一个minStack存储当前栈stack对应的最小值
class MinStack {

    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    // 初始化堆栈对象
    public MinStack() {
        // 初始化
        stack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        // 初始化设置minStack为一个最大值
        minStack.push(Integer.MAX_VALUE);
    }

    // 将元素val推入堆栈
    public void push(int val) {
        // 入栈操作（校验最小值）
            /* 异常
            if(!minStack.isEmpty()) {
                // 同步维护辅助栈minStack
                if(val < minStack.peek()) {
                    minStack.pop(); // val更小，则更新minStack(先弹出栈顶元素，然后将相应的最小值入栈)
                    minStack.push(val);
                }
            }
             */
        minStack.push(Math.min(minStack.peek(), val));
        // 数据正常入栈
        stack.push(val);
    }

    // 删除堆栈顶部的元素
    public void pop() {
        // 出栈则正常同步弹出即可（因为在push的时候同步维护了相应的最小值）
        minStack.pop();
        stack.pop();
    }

    // 获取堆栈顶部的元素
    public int top() {
        // 返回栈顶元素
        return stack.peek();
    }

    // 获取堆栈中的最小元素
    public int getMin() {
        // 从辅助栈中同步获取
        return minStack.peek();
    }
}

