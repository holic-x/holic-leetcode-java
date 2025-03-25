package com.noob.algorithm.daily.codeTop;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 🟡 马戏团人塔 - https://leetcode.cn/problems/circus-tower-lcci/description/
 */
public class Solution_RS_1708 {

    class Person {
        public int height;
        public int weight;

        Person(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }
    }

    public int bestSeqAtIndex(int[] height, int[] weight) {
        int n = height.length;
        Person[] people = new Person[n];
        // ① 数据整合：创建人员数组（也可以用二维数组标识{{height,weight}}）
        for (int i = 0; i < n; i++) {
            people[i] = new Person(height[i], weight[i]);
        }


        // ② 按照身高进行升序排序，如果身高相同则根据体重降序
        Arrays.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.height == p2.height ? p2.weight - p1.weight : p1.height - p2.height;
            }
        });

        // ③ 提取排序后的体重数组,转化为寻找最长递增子序列
        int[] afterSortWeight = new int[n];
        for (int i = 0; i < n; i++) {
            afterSortWeight[i] = people[i].weight;
        }

        return findMaxIncreaseSeq(afterSortWeight);
    }

    // 寻找最长递增子序列
    private int findMaxIncreaseSeq(int[] nums) {
        int n = nums.length;
        // 1.dp 定义：dp[i] 表示以i位置元素结尾的最长递增序列长度
        int[] dp = new int[n];

        /**
         * 2.dp 递推
         * dp[i] i位置元素可以拼接在[0,i)范围的元素位置j后面则需满足nums[j]<nums[i]即可
         */

        // 3.dp 初始化（元素自身为一个递增子序列）
        Arrays.fill(dp, 1);

        // 4.dp 构建
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // 更新
            maxLen = Math.max(maxLen, dp[i]);
        }

        // 返回结果
        return maxLen;
    }

}
