package com.noob.algorithm.base;

/**
 * 递归 样例
 */
public class RecursionDemo {

    public static void main(String[] args) {
        RecursionDemo rd = new RecursionDemo();
        // 1.调用栈：普通递归方式
        System.out.println(rd.recur(10));
        // 2.尾递归：尾递归方式（优化空间效率）
        System.out.println(rd.tailRecur(10,0));
        // 3.递归树
        System.out.println(rd.fib(5));
    }

    /* 递归(普通递归) */
    // 1+2+3+....+n
    int recur(int n) {
        // 终止条件
        if (n == 1)
            return 1;
        // 递：递归调用
        int res = recur(n - 1);
        // 归：返回结果
        return n + res;
    }

    /* 尾递归（优化空间效率） */
    int tailRecur(int n, int res) {
        // 终止条件
        if (n == 0)
            return res;
        // 尾递归调用
        return tailRecur(n - 1, res + n);
    }

    /* 斐波那契数列：递归 */
    int fib(int n) {
        // 终止条件 f(1) = 0, f(2) = 1
        if (n == 1 || n == 2)
            return n - 1;
        // 递归调用 f(n) = f(n-1) + f(n-2)
        int res = fib(n - 1) + fib(n - 2);
        // 返回结果 f(n)
        return res;
    }
}
