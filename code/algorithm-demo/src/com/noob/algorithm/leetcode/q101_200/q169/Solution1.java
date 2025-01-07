package com.noob.algorithm.leetcode.q101_200.q169;

import java.util.HashMap;
import java.util.Iterator;

/**
 * 🟢 169.多数元素 - https://leetcode.cn/problems/majority-element/description/
 */
class Solution1 {
    // 计数法
    public int majorityElement(int[] nums) {

        // 存储元素出现次数
        HashMap<Integer, Integer> map = new HashMap();

        // 存储满足条件的元素(此处题目返回是1个那就不用集合)

        // 统计元素出现次数
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                // 如果存在，计数+1
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        // 返回元素出现次数大于n/2的元素
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            int key = iterator.next();
            if (map.get(key) > nums.length / 2) {
                return key;
            }
        }

        return 0;
    }

}