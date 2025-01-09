package com.noob.algorithm.leetcode.q401_500.q452;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 🟡 452 用最少数量的箭引爆气球 - https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/description/
 */
public class Solution1 {

    /**
     * 思路分析：根据右区间进行排序，每次选择右端点进行射击（尽可能覆盖更多区间）
     */
    public int findMinArrowShots(int[][] points) {

        // 对区间按照右端点进行排序
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]; // 按照右端点进行排序，如果右端点相同则根据左端点从小到大进行排序
            }
        });

        // 初始化射击点和射击弓箭数
        int shotIdx = points[0][1]; // 选择第1个区间的右端点作为射击点
        int cnt = 1; // 初始化射击1次
        // 遍历区间，校验当前选择射击点是否覆盖了该区间，如果覆盖则跳过，如果没有覆盖则需再次选择新的射击点
        for (int i = 1; i < points.length; i++) {
            if (shotIdx >= points[i][0]) { // 基于前面的排序，shotIdx<=right是成立的所以此处可以不用校验shotIdx<=points[i][1](shotIdx >= points[i][0] && shotIdx<=points[i][1])
                continue; // 已覆盖，继续下一个射击区域判断
            } else {
                // 选择当前区间的右端点作为新的射击点(shotIdx<left,当前射击点无法无法这个区间)
                shotIdx = points[i][1];
                cnt++;
            }
        }
        // 返回射击数量
        return cnt;
    }

}
