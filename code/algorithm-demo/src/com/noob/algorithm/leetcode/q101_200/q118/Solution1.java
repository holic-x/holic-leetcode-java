package com.noob.algorithm.leetcode.q101_200.q118;

import java.util.ArrayList;
import java.util.List;

/**
 * 🟢 118.杨辉三角 - https://leetcode.cn/problems/pascals-triangle/description/
 */
public class Solution1 {

    // 方式1：二维数组转化
    public List<List<Integer>> generate(int numRows) {
        // 构建一个二维数组(这个二维概念不一定要数组，也可以基于List<List<Integer>>构建)存储元素(n*n)
        int[][] arr = new int[numRows + 1][numRows + 1];
        arr[0][0] = 1; // 初始化第0行
        arr[1][0] = 1; // 初始化第1行
        arr[1][1] = 1;
        // 遍历二维数组依次存储数据
        for (int i = 2; i <= numRows; i++) {
            for (int j = 0; j <= numRows; j++) {
                // 首尾元素置为1，其他中间元素满足c[i][j]=c[i-1][j-1]+c[i-1][j]
                if (j == 0 || i == j) {
                    // 首为元素置为1
                    arr[i][j] = 1;
                } else {
                    // 其他元素满足当前元素=左上方+正上方的元素之和
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                }
            }
        }
        // 遍历二维数组，返回封装结果
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < numRows; j++) {
                // temp.add(arr[i][j]); // 需要去除掉默认的0元素
                if (arr[i][j] != 0) {
                    temp.add(arr[i][j]);
                }
            }
            res.add(temp);
        }
        // 返回结果集合
        return res;
    }
}
