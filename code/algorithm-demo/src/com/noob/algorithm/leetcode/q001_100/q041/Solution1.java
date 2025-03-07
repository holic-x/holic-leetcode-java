package com.noob.algorithm.leetcode.q001_100.q041;

import java.util.HashSet;
import java.util.Set;

/**
 * 🔴 041 缺失的第1个正数 - https://leetcode.cn/problems/first-missing-positive/
 */
public class Solution1 {
    /**
     * 给定一个未排序的数组nums，找出其中没有出现的最小正整数（题目限定时间复杂度为O(n),且只能使用常数级别的空间）
     * 思路①：哈希法
     */
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // 遍历nums，将所有数加入哈希集合
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
        }

        // 再次遍历集合，随后判断[1,n]区间内哪个数不在集合中（因为此处是确定了校验区间的遍历顺序，当找到第1个不在区间内的最小正整数则返回）
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        // [1,n]区间内都有值，则返回n+1
        return n + 1;
    }
}
