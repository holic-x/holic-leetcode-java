package com.noob.algorithm.leetcode.q001_100.q075;

import java.util.ArrayList;
import java.util.List;

/**
 * 🟡 075 颜色分类 - https://leetcode.cn/problems/sort-colors/description/
 */
public class Solution1 {

    /**
     * 思路：分类法（将每个小球存储到指定的分类集合，随后重新载入nums）
     */
    public void sortColors(int[] nums) {
        List<Integer> red = new ArrayList<Integer>();
        List<Integer> white = new ArrayList<Integer>();
        List<Integer> blue = new ArrayList<Integer>();

        // 步骤1：遍历数组，存储各个颜色的小球到指定集合
        for (int num : nums) {
            switch (num) {
                case 0: {
                    red.add(num);
                    break;
                }
                case 1: {
                    white.add(num);
                    break;
                }
                case 2: {
                    blue.add(num);
                    break;
                }
            }
        }

        // 步骤2：合并最终的集合
        red.addAll(white);
        red.addAll(blue);
        for (int i = 0; i < red.size(); i++) {
            nums[i] = red.get(i);
        }
    }
}