package com.noob.algorithm.other;

/**
 * 时间复杂度测试样例
 * 常见类型的时间复杂度样例测试
 */
public class TimeComplexityDemo {

    public static void main(String[] args) {
        TimeComplexityDemo tcd = new TimeComplexityDemo();
        // 常数阶
        System.out.println(tcd.constant(10));

        // 线性阶
        System.out.println(tcd.linear(10));
        System.out.println(tcd.arrayTraversal(new int[]{1,2,3,4,5}));

        // 平方阶
        System.out.println(tcd.quadratic(10));
        System.out.println(tcd.bubbleSort(new int[]{10,2,34,24,5})); // 冒泡排序样例

        // 指数阶（细胞分裂样例）
        System.out.println(tcd.exponential(30));
        System.out.println(tcd.expRecurStack(30));
        System.out.println(tcd.expRecur(30)); // n越大 执行时间越久

        // 对数阶（与指数阶相反）
        System.out.println(tcd.logarithmic(30));
        System.out.println(tcd.logRecur(30));

        // 线性对数阶
        System.out.println(tcd.linearLogRecur(10));
    }

    /* 常数阶 */
    int constant(int n) {
        int count = 0;
        int size = 100000;
        for (int i = 0; i < size; i++)
            count++;
        return count;
    }

    /* 线性阶 */
    // 此处变量n为输入数据大小
    int linear(int n) {
        int count = 0;
        for (int i = 0; i < n; i++)
            count++;
        return count;
    }

    /* 线性阶（遍历数组） */
    // 此处数组nums的长度为输入数据大小
    int arrayTraversal(int[] nums) {
        int count = 0;
        // 循环次数与数组长度成正比
        for (int num : nums) {
            count++;
        }
        return count;
    }

    /* 平方阶 */
    int quadratic(int n) {
        int count = 0;
        // 循环次数与数据大小 n 成平方关系
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count++;
            }
        }
        return count;
    }

    /* 平方阶（冒泡排序） */
    int bubbleSort(int[] nums) {
        int count = 0; // 计数器
        // 外循环：未排序区间为 [0, i]
        for (int i = nums.length - 1; i > 0; i--) {
            // 内循环：将未排序区间 [0, i] 中的最大元素交换至该区间的最右端
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    // 交换 nums[j] 与 nums[j + 1]
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                    count += 3; // 元素交换包含 3 个单元操作
                }
            }
        }
        return count;
    }

    /* 指数阶（循环实现） */
    int exponential(int n) {
        int count = 0, base = 1;
        // 细胞每轮一分为二，形成数列 1, 2, 4, 8, ..., 2^(n-1)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < base; j++) {
                count++;
            }
            base *= 2;
        }
        // count = 1 + 2 + 4 + 8 + .. + 2^(n-1) = 2^n - 1
        return count;
    }

    /* 指数阶（递归实现）调用栈 */
    int expRecurStack(int n) {
        // 终止条件
        if (n == 1)
            return 1;
        // 递
        int res  = expRecurStack(n-1);

        // 归
        // count = 1 + 2 + 4 + 8 + .. + 2^(n-1) = 2^n - 1
        return (int) (res + Math.pow(2,n-1));
    }

    /* 指数阶（递归实现） */
    int expRecur(int n) {
        // 终止条件
        if (n == 1)
            return 1;
        return expRecur(n - 1) + expRecur(n - 1) + 1;
    }

    /* 对数阶（循环实现） */
    // 设输入数据大小为 n ，由于每轮缩减到一半，因此循环次数是 log2 n ，即 2^n 的反函数
    int logarithmic(int n) {
        int count = 0;
        while (n > 1) {
            n = n / 2;
            count++;
        }
        return count;
    }

    /* 对数阶（递归实现） */
    int logRecur(int n) {
        if (n <= 1)
            return 0;
        return logRecur(n / 2) + 1;
    }

    /* 线性对数阶 */
    int linearLogRecur(int n) {
        if (n <= 1)
            return 1;
        int count = linearLogRecur(n / 2) + linearLogRecur(n / 2);
        for (int i = 0; i < n; i++) {
            count++;
        }
        return count;
    }

}
