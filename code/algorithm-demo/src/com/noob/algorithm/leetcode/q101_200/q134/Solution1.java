package com.noob.algorithm.leetcode.q101_200.q134;

/**
 * 🟡 134 加油站 - https://leetcode.cn/problems/gas-station/description/
 */
public class Solution1 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int startIdx = 0; // 当前选择出发的加油站起点
        int curGas = 0; // 走到某个位置的剩余油量
        int totalGas = 0; // 走到某个位置所需的总油量

        // 遍历每个加油站
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            // 计算当前油量是否满足走到下一个加油站
            totalGas = totalGas + (gas[i] - cost[i]);
            curGas = curGas + (gas[i] - cost[i]);
            // 判断当前油量是否足够支撑走到下一个加油站，如果不足则需选择下一个加油站作为起始站点
            if (curGas < 0) {
                // 当前剩余油量不足
                startIdx = i + 1;
                curGas = 0;
            }
        }

        return totalGas >= 0 ? startIdx : -1;
    }
}
