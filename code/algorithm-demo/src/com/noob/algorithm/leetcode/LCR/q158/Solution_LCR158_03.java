package com.noob.algorithm.leetcode.LCR.q158;

/**
 * 🟢 LCR 158 库存管理II - https://leetcode.cn/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/description/
 */
public class Solution_LCR158_03 {

    /**
     * 思路：摩尔投票法
     */
    public int inventoryManagement(int[] stock) {
        // 票数统计、众数
        int votes = 0, x = 0;
        // 遍历数组元素
        for (int num : stock) {
            // 如果票数为0，则假设当前x为众数，随后再根据x==num来判断票数加减
            if (votes == 0) {
                x = num;
            }
            votes += (x == num) ? 1 : -1; // x==num,则投当前众数1票，否则扣减1票
        }
        // 返回结果
        return x; // 最后一轮选出的即为众数
    }

}
