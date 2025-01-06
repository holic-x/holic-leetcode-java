package com.noob.algorithm.leetcode.q136;

import java.util.HashSet;
import java.util.Set;

/**
 * 🟢 136.只出现一次的数字 - https://leetcode.cn/problems/single-number/
 * 暴力思路：
 * 计数法：遍历数组，统计数组元素出现次数，然后遍历统计数据获取到出现此处为1的元素
 * 标记法：遍历数组，如果发现数据在集合中存在（说明存在重复），则从集合中移除这个数据，如果数据不存在则新加入集合，最终集合中留下来的就是只出现一次的元素
 */
public class Solution3 {

    // 思路3：异或操作（0的特殊性）
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}