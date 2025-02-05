package com.noob.algorithm.leetcode.q601_q700.q647;

/**
 * 🟡 647 回文子串 - https://leetcode.cn/problems/palindromic-substrings/description/
 */
public class Solution2 {

    /**
     * 思路分析: 动态规划思路（判断某一区间字符串是否为回文字符串）
     */
    public int countSubstrings(String s) {
        int n = s.length();
        // 1.dp 定义：dp[i][j] 表示 [i,j] 区间为回文字符串，根据区间间隔来进行推导
        boolean[][] dp = new boolean[n][n];

        /**
         * 2.dp 递推: 根据s[i]==s[j]是否成立分情况讨论
         * s[i]!=s[j]: 肯定为非回文
         * s[i]==s[j]: 根据区间的相对位置分情况讨论
         * - ① i==j：s[i]==s[j]肯定成立 =》dp[i][j]=true
         * - ② i-j==1(间隔1位,例如aa形式) =》dp[i][j] = true
         * - ③ i-j>1(间隔1位+，例如aba形式)，则取决于 [i+1,j-1]区间也是否满足回文 =》dp[i][j] = dp[i+1][j-1]
         */

        // 3.dp 初始化（元素自身为1个回文字符串，其余初始化为0）
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // dp[i][j] = (i == j) ? 1 : 0;
                dp[i][j] = (i == j) ? true : false;
            }
        }

        // 4.dp 构建
        int cnt = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) { // 区间[i,j]
                if (s.charAt(i) == s.charAt(j)) {
                    if (i == j || j - i == 1) { // 情况①②
                        dp[i][j] = true;
                        cnt++; // 回文计数+1
                    } else if (j - i > 1) {
                        dp[i][j] = dp[i + 1][j - 1]; // 情况③
                        cnt = dp[i][j] ? cnt + 1 : cnt; // 判断回文计数+1
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }

        // 返回结果
        return cnt;
    }


}
