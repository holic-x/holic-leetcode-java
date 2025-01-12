package com.noob.algorithm.leetcode.q401_500.q415;

/**
 * 🟢 415 字符串相加 - https://leetcode.cn/problems/add-strings/description/
 */
public class Solution2 {

    /**
     * 思路：不能使用任何内置处理大整数的库、也不能将字符串转化为整数，得到两者的和
     */
    public String addStrings(String num1, String num2) {
        // 定义结果处理字符串
        StringBuffer res = new StringBuffer();

        // 逆序遍历两个字符串，然后进行累加（注意处理进位的关系）
        int p1 = num1.length() - 1, p2 = num2.length() - 1;
        int carry = 0; // 初始化进位为0
        while (p1 >= 0 || p2 >= 0 || carry == 1) { // 因为循环内部对NPE做了处理，此处可以将carry的处理也载入循环判断就不需要处理尾巴了
            // 处理对应位置字符元素相加
            int val1 = p1 >= 0 ? num1.charAt(p1) - '0' : 0; // 此处注意字符和数字的转化
            int val2 = p2 >= 0 ? num2.charAt(p2) - '0' : 0;
            int r = val1 + val2 + carry;

            // 更新进位、填充结果
            res.append(r % 10);
            carry = r / 10;

            // 更新指针
            p1--;
            p2--;
        }

        // 返回结果
        return res.reverse().toString(); // 此处返回的是反转后的结果
    }
}
