package com.noob.algorithm.leetcode.q501_600.q556;

import java.util.Arrays;

/**
 * 🟡 556 下一个更大元素 III - https://leetcode.cn/problems/next-greater-element-iii/description/
 */
public class Solution1 {

    /**
     * 思路分析：
     * ① 从后往前找到第1个下降的数字位置i
     * ② 在i的右边找到比n[i]大的最小数字（可以先对指定区域进行升序排序，随后选择最小的n[j]）
     * ③ 交换n[i]与n[j]
     * ④ 对i位置后面的序列进行再次排序(从小到大)
     */
    public int nextGreaterElement(int n) {
        // 将数字n转化为字符数组
        char[] digits = String.valueOf(n).toCharArray();
        int len = digits.length;
        // ① 逆序寻找第一个下降的数字位置i
        int swapIndex = -1;
        for (int i = len - 2; i >= 0; i--) {
            if (digits[i] < digits[i + 1]) {
                swapIndex = i;
                break;
            }
        }

        // 如果不存在有效的swapIndex，则说明已经是最大排列
        if (swapIndex == -1) {
            return -1;
        }

        // ② 在swapIndex右边找到比它大的最小数字
        Arrays.sort(digits, swapIndex + 1, len); // 从右边位置开始排序
        for (int j = swapIndex + 1; j < len; j++) {
            if (digits[j] > digits[swapIndex]) {
                // ③ 交换位置
                char temp = digits[j];
                digits[j] = digits[swapIndex];
                digits[swapIndex] = temp;
                break;
            }
        }

        // ③ 再次对swapIndex右边的元素进行排列
        Arrays.sort(digits, swapIndex + 1, len);

        // 将字符数组转换回整数
        long result = Long.parseLong(new String(digits));
        // 检查是否超出 32 位整数范围
        return result > Integer.MAX_VALUE ? -1 : (int) result;
    }

}
