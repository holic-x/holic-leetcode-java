package com.noob.algorithm.leetcode.q001_100.q078;

import java.util.ArrayList;
import java.util.List;

/**
 * 🟡 78.子集 - https://leetcode.cn/problems/subsets/description/
 */
public class Solution1 {

    /**
     * 核心：循环遍历数组元素，每遍历一个数字，就基于当前子集追加当前数字构成新的子集，进而进入下一个数字遍历，以此类推直到所有的数字遍历完成
     */
    public List<List<Integer>> subsets(int[] nums) {
        // 定义结果集合
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<>()); // 初始化加入空集（空集也是子集的一部分）
        // 依次遍历数字
        for (int i = 0; i < nums.length; i++) {
            // 计算当前子集大小，遍历每个子集，将元素进行追加并生成新的子集
            int size = res.size(); // 当前子集数
            for (int j = 0; j < size; j++) {
                List<Integer> temp = new ArrayList<>(res.get(j)); // copy一份子集
                temp.add(nums[i]); // 追加元素，生成新的子集
                res.add(temp); // 追加新子集
            }
        }
        return res;
    }

}
