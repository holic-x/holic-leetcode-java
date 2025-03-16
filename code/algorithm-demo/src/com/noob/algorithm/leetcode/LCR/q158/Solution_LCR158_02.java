package com.noob.algorithm.leetcode.LCR.q158;

import java.util.Arrays;

/**
 * 🟢 LCR 158 库存管理II - https://leetcode.cn/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/description/
 */
public class Solution_LCR158_02 {

    /**
     * 思路：数组排序思路，返回中点位置的元素即为众数
     */
    public int inventoryManagement(int[] stock) {
        Arrays.sort(stock);
        return stock[stock.length/2];
    }

}
