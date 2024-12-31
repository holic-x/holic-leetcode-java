package com.noob.algorithm.leetcode.q001;

import java.util.HashMap;

/**
 * 🟢 1.两数之和
 * https://leetcode.cn/problems/two-sum/description/
 */
public class Solution2 {

    /**
     * 思路2：哈希表
     */
    public int[] twoSum(int[] nums, int target) {
        /**
         * 借助哈希表辅助遍历，遍历每个元素并加入哈希集合，遍历的同时校验每个元素是否满足`a+b=target`
         * 即对于每个元素a，校验在哈希集合中是否存在target-a，如果存在直接返回满足的一组数即可
         * 注意此处返回的结果为数组下标，因此此处应该用HashMap处理
         */
        HashMap<Integer, Integer> map = new HashMap<>(); // Map<val,index> / <数组元素,对应下标>
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            // 将遍历元素加入集合
            map.put(nums[i], i);
        }
        // 没有匹配到满足的条件
        return new int[0];
    }

}
