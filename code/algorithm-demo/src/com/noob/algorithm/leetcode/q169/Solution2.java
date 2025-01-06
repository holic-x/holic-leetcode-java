package com.noob.algorithm.leetcode.q169;

import java.util.HashMap;
import java.util.Iterator;

/**
 * 🟢 169.多数元素 - https://leetcode.cn/problems/majority-element/description/
 */
class Solution2 {

    // 计数法优化
    public int majorityElement(int[] nums) {

        // 存储元素出现次数
        HashMap<Integer, Integer> map = new HashMap();

        // 因为返回值只有一个int，因此此处可以理解为找"最大值"（出现次数最多的元素,注意此处是返回元素，而不是元素出现次数）
        HashMap<String, Integer> max = new HashMap(); // max 只存储一组数据（maxItem,出现次数）或者拆开来存储（maxItem：xxx，count：xxx）
        max.put("maxItem", nums[0]);
        max.put("count", 0);

        // 统计元素出现次数
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int val = map.get(nums[i]) + 1;
                // 如果存在，计数+1
                map.put(nums[i], val);
                if (val > max.get("count")) {
                    // 更新
                    max.put("maxItem", nums[i]);
                    max.put("count", val);
                }
            } else {
                map.put(nums[i], 1);
            }
        }

        return max.get("maxItem");
    }

}