package com.noob.algorithm.leetcode.q301_400.q392;

/**
 * 🟢 392 判断子序列 - https://leetcode.cn/problems/is-subsequence/description/
 */
public class Solution1 {

    /**
     * 给定字符串s、t，判断s是否为t的子序列（即t通过删除部分字符是否可以得到s）
     * 思路：双指针遍历比较思路
     */
    public boolean isSubsequence(String s, String t) {
        int sLen = s.length(), tLen = t.length();

        // 定义双指针分别用于遍历两个字符串
        int sPointer = 0, tPointer = 0;

        while (sPointer < sLen && tPointer < tLen) {
            // 判断当前指针指向字符是否相同，相同则双指针继续前进
            if (s.charAt(sPointer) == t.charAt(tPointer)) {
                sPointer++;
                tPointer++;
            } else {
                // 如果不相同，则tPointer继续寻找下一位
                tPointer++;
            }
        }
        // 判断s指针是否走到末尾(走到末尾则说明匹配)
        return sPointer == sLen;
    }
}
