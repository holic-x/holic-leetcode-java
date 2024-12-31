package com.noob.algorithm.base;

/**
 * 斐波那契数列算法
 */
public class FibonacciDemo {
    // 递归解法
    public int fibonacci01(int n) {
        // 递归出口
        if (n == 0 || n == 1) {
            return n;
        }
        // 执行递归
        return fibonacci01(n - 1) + fibonacci01(n - 2);
    }

    // 动态规划
    public int[] fibonacci02(int n) {
        // 定义数组记录前面的结果
        int[] res = new int[n];
        // 初始化结果集
        res[0] = 0;
        res[1] = 1;
        for (int i = 2; i < n; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        // 返回最终的结果(整个斐波那契数列，如果返回对应位置的数字则根据下标索引定位即可)
        return res;
    }

    public static void main(String[] args) {
        System.out.println("1.递归方式：");
        for (int i = 0; i < 10; i++) {
            System.out.print(new FibonacciDemo().fibonacci01(i) + "-");
        }
        System.out.println("\n2.动态规划：");
        int[] res = new FibonacciDemo().fibonacci02(10);
        for (int tmp : res) {
            System.out.print(tmp + "-");
        }
    }
}
