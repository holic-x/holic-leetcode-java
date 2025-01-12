package com.noob.algorithm.leetcode.q001_100.q008;


/**
 * 🟡 008 字符串转整数（atoi） - https://leetcode.cn/problems/string-to-integer-atoi/
 */
public class Solution2 {

    /**
     * 四种字符的处理：
     * ① 空格：去掉首部空格
     * ② 符号：定义变量存储符号位（3种：正、负、无符号）
     * ③ 非数字字符：直接返回
     * ④ 数字字符：将数字字符转化为数字（ascii码转化），随后拼接数字
     */
    public int myAtoi(String s) {
        // ① 处理前后空格
        s = s.trim(); // 借助String方法处理空格
        if (s.equals("")) {
            return 0; // 去重后的字符串为空则直接返回
        }

        // ② 校验符号
        int sign = 1; // 定义符号位
        int start = 0; // 字符校验的开始位置，需排除符号位的影响（如果存在符号位则字符判断从第2个位置开始，如果不存在则是从第1个位置开始）
        long res = 0; // 定义整数结果，通过遍历更新

        if (s.charAt(start) == '-') {
            sign = -1;
            start = 1; // 存在符号位，下一个遍历元素从第2个位置开始
        } else if (s.charAt(start) == '+') {
            sign = 1;
            start = 1; // 存在符号位，下一个遍历元素从第2个位置开始
        }

        // 遍历元素
        for (int i = start; i < s.length(); i++) {
            // 校验字符是否为数字字符或者字母字符
            char curCh = s.charAt(i);
            if (!Character.isDigit(curCh)) {
                break; // 遇到非数字字符(字母字符或者其他符号)直接退出
            } else if (Character.isDigit(curCh)) {
                // 将数字字符转化为数字并拼接
                res = res * 10 + (curCh - '0');
                // 校验值是否超出Integer值域，如果超出则直接返回(判断值域有两种，一种判断值大小，另一种则是判断数字位数是否超出Integer的限定)
                if (res * sign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
                if (res * sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            }
        }

        return (int) res * sign;
    }

}
