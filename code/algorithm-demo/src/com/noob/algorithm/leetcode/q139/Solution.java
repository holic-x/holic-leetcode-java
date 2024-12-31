package com.noob.algorithm.leetcode.q139;

import java.util.Arrays;
import java.util.List;

/**
 * 139.单词拆分
 */
public class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        // 1.确定dp数组(dp[k]表示0-k的位置可以被拆分)
        boolean[] dp = new boolean[s.length() + 1];

        // 2.状态转移方程（如果dp[k]可以被拆分，则dp[j]也可以被拆分，且从j+1到K的位置也能被拆分）

        // 3.初始化dp(dp[0]为true，其余元素设为false)
        Arrays.fill(dp, false);
        dp[0] = true;

        // 4.敲定循环（外层背包，内层物品）
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // 如果dp[k]可以被拆分，则dp[j]也可以被拆分，且从j+1到i的位置也能被拆分
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }

        // 返回结果
        return dp[s.length()];
    }
}
