package com.noob.algorithm.leetcode.q301_400.q392;

/**
 * 🟢 392 判断子序列 - https://leetcode.cn/problems/is-subsequence/description/
 */
public class Solution2 {
    /**
     * 思路：动态规划思路
     */
    public boolean isSubsequence(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        // 1.dp 定义：dp[i][j] 表示以下标i-1结尾的字符串s、以下标j-1结尾的字符串t 两者相同子序列长度为dp[i][j]
        int[][] dp = new int[sLen + 1][tLen + 1];

        /**
         * 判断s是否为t的子序列
         * 2.dp 递推：根据当前字符是否匹配进行判断
         * s[i-1]=t[j-1]: 字符匹配，相同子序列长度+1 => dp[i][j] = dp[i-1][j-1] + 1;
         * s[i-1]!=t[j-1]: 字符不匹配，则dp[i][j]取决于s[i-1]与t[j-2]的比较结果（相当于t要删除一位元素） => dp[i][j] = dp[i][j-1]
         */

        // 3.dp 初始化
        // 初始化首行
        for (int j = 0; j < tLen; j++) {
            dp[0][j] = 0;
        }
        // 初始化首列
        for (int i = 0; i < sLen; i++) {
            dp[i][0] = 0;
        }

        // 4.dp 构建
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= tLen; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        // 返回结果
        return dp[sLen][tLen] == s.length();
    }
}
