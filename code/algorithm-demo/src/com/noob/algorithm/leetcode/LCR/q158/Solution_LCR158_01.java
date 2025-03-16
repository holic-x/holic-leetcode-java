package com.noob.algorithm.leetcode.LCR.q158;

import java.util.HashMap;
import java.util.Map;

/**
 * 🟢 LCR 158 库存管理II - https://leetcode.cn/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/description/
 */
public class Solution_LCR158_01 {

    /**
     * 思路：记录每个商品ID的出现次数，返回cnt>n/2的商品ID
     */
    public int inventoryManagement(int[] stock) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int id : stock) {
            map.put(id, map.getOrDefault(id, 0) + 1);
        }
        // 遍历map，获取cnt > n/2 的商品ID
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > stock.length / 2) {
                return entry.getKey();
            }
        }
        return -1;
    }

}
