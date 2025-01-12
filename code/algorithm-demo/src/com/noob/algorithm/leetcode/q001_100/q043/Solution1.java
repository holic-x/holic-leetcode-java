package com.noob.algorithm.leetcode.q001_100.q043;

/**
 * 🟡 043 两个字符串相乘 - https://leetcode.cn/problems/multiply-strings/
 */
public class Solution1 {

    /**
     * 思路：竖式运算（num1作为基，遍历num2的每个数字与num1进行相乘并累加结果）
     * 这个过程中注意数字0的填充以及字符串相加处理
     */
    public String multiply(String num1, String num2) {
        String res = "";
        int n1 = num1.length(), n2 = num2.length();

        // 如果num1、num2中有一个为0，则乘积返回0
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        // 遍历nums2的每个字符进行相乘（逆序遍历处理，并在结果尾部补足0）
        for (int i = n2 - 1; i >= 0; i--) {
            // 处理当前相乘结果
            StringBuffer temp = new StringBuffer();
            // 对尾部补0
            for (int j = 0; j < n2 - i - 1; j++) {
                temp.append(0);
            }
            int curN2 = num2.charAt(i) - '0'; // 将当前遍历数字字符转为数字

            // nums2的第i位与num1相乘
            int carry = 0;
            for (int j = n1 - 1; j >= 0 || carry != 0; j--) {
                int x = (j >= 0) ? num1.charAt(j) - '0' : 0;
                int product = curN2 * x + carry;
                temp.append(product % 10);
                carry = product / 10;
            }
            // 累加结果（将当前结果与新计算的结果进行求和作为新结果：两个字符串相加）
            res = add(res, temp.reverse().toString()); // temp是正序补充元素，因此此处是返回逆序的字符串

        }
        // 返回结果
        return res;
    }


    /**
     * 两个字符串相加：需逆序相加处理
     */
    public String add(String num1, String num2) {
        int n1 = num1.length(), n2 = num2.length();
        StringBuffer res = new StringBuffer();
        int carry = 0;
        for (int i = n1 - 1, j = n2 - 1; i >= 0 || j >= 0 || carry != 0; i--, j--) {
            int val1 = (i >= 0 ? Integer.valueOf(num1.charAt(i) - '0') : 0);
            int val2 = (j >= 0 ? Integer.valueOf(num2.charAt(j) - '0') : 0);
            int sum = val1 + val2 + carry;
            res.append(sum % 10);
            carry = sum / 10;
        }
        // 返回结果
        return res.reverse().toString(); // 逆序处理（或者在添加结果的时候采用头插，此处就不用整体reverse）
    }

}
