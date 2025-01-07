package com.noob.algorithm.leetcode.q101_200.q118;

import java.util.ArrayList;
import java.util.List;

/**
 * 🟢 118.杨辉三角 - https://leetcode.cn/problems/pascals-triangle/description/
 */
public class Solution2 {

    // 方式2：直接遍历封装结果集
    public List<List<Integer>> generate(int numRows) {
        // 构建一个二维数组(这个二维概念不一定要数组，也可以基于List<List<Integer>>构建)存储元素(n*n)
        List<List<Integer>> res = new ArrayList<>();

        // 存储数据
        for (int i = 0; i < numRows; i++) { // 外层循环
            // 初始化临时列表存储当前行生成的数据
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j <= i; j++) { // 内存循环：该行元素个数受限于当前行数
                // 首尾元素置为1，其他中间元素满足c[i][j]=c[i-1][j-1]+c[i-1][j]
                if (j == 0 || i == j) {
                    // 首尾元素置为1（在该行追加元素）
                    temp.add(1);
                } else {
                    // 其他元素满足当前元素=左上方+正上方的元素之和
                    temp.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            // 将当前行加入结果集
            res.add(temp);
        }
        // 返回结果集合
        return res;
    }

}
