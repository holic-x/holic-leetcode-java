package com.noob.algorithm.leetcode.q101_200.q136;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 🟢 136.只出现一次的数字 - https://leetcode.cn/problems/single-number/
 * 暴力思路：
 * 计数法：遍历数组，统计数组元素出现次数，然后遍历统计数据获取到出现此处为1的元素
 * 标记法：遍历数组，如果发现数据在集合中存在（说明存在重复），则从集合中移除这个数据，如果数据不存在则新加入集合，最终集合中留下来的就是只出现一次的元素
 */
public class Solution2 {

    // 思路2：标记法(去重法)
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            // 判断当前数据是否存在在集合中
            if (set.contains(num)) {
                // 从集合中移除重复的元素
                set.remove(num);
            } else {
                // 如果数据不存在，将当前节点加入集合
                set.add(num);
            }
        }
        // 最终集合中剩下的元素就是不重复的那个
        return set.iterator().next();
    }

}