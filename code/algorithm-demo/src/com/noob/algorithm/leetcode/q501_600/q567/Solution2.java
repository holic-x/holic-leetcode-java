package com.noob.algorithm.leetcode.q501_600.q567;

/**
 * 🟡 567.字符串的排列 - https://leetcode.cn/problems/permutation-in-string/description/
 */
public class Solution2 {

    /**
     * 判断s2是否包含s1的排列（即判断s1的排列是否为s2的子串）
     * 思路：通过话筒窗口win限定s2区域，判断窗口内的字符是否可以构成s1（也就是说win中的字符及其出现次数是否与s1的一致）
     * - ① 计算s1中字符及其出现次数
     * - ② 滑动固定窗口win，判断窗口内的字符是否可以构成s1
     */
    public boolean checkInclusion(String s1, String s2) {
        // ① 计算s1中的字符及其出现次数
        int[] cntS1 = new int[128];
        for (char ch : s1.toCharArray()) {
            cntS1[ch]++;
        }

        // ② 滑动固定大小的窗口win（长度为s1.len），判断窗口内的字符是否可以构成s1
        int len1 = s1.length(), len2 = s2.length();
        if (len2 < len1) {
            return false;
        }

        // 初始化窗口字符
        int[] cntWin = new int[128];
        for (int i = 0; i < len1; i++) {
            cntWin[s2.charAt(i)]++;
        }
        // 初始化校验1次
        if (isValid(cntS1, cntWin)) {
            return true; // 存在则直接返回
        }

        int left = 0; // 窗口左指针
        for (int right = len1; right < len2; right++) { // 窗口右指针
            // 移除左侧字符、移入右侧字符，然后校验
            cntWin[s2.charAt(left)]--;
            cntWin[s2.charAt(right)]++;
            if (isValid(cntS1, cntWin)) {
                return true; // 存在则直接返回
            }
            // 一次校验后，指针移动（left、right都要移动）
            left++;
        }

        // 不存在
        return false;
    }

    // 校验两个集合字符及其出现次数是否完全一致
    private boolean isValid(int[] cntS1, int[] cntWin) {
        for (int i = 'a'; i <= 'z'; i++) {
            if (cntS1[i] != cntWin[i]) {
                return false;
            }
        }

        for (int i = 'A'; i <= 'Z'; i++) {
            if (cntS1[i] != cntWin[i]) {
                return false;
            }
        }
        return true;
    }
}
