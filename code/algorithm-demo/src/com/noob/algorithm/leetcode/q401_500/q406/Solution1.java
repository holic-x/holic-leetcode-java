package com.noob.algorithm.leetcode.q401_500.q406;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 🟡 406 根据身高重建队列 - https://leetcode.cn/problems/queue-reconstruction-by-height/description/
 */
public class Solution1 {

    /**
     * 思路分析：
     * ① 按照people[0]身高从高到低、people[1]从小到大进行排序
     * ② 遍历排序后的people数组，根据前面有几个比当前位置高的数值作为idx（索引）插入数据
     */
    public int[][] reconstructQueue(int[][] people) {
        // 构建优先队列：按照people[0]身高从高到低、people[1]从小到大进行排序
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o1[1] : o2[0] - o1[0];
            }
        });

        // 遍历排序后的数组元素，根据前面有几个比当前位置高的数值作为idx（索引）插入数据
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            list.add(people[i][1], people[i]); // 将元素插入指定索引位置
        }

        // 返回结果
        return list.toArray(new int[people.length][]);
    }

}
