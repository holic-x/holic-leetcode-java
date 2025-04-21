package com.noob.algorithm.leetcode.q001_100.q059;


/**
 * 🟡 059 螺旋矩阵II - https://leetcode.cn/problems/spiral-matrix-ii/
 */
public class Solution059_01 {
    /**
     * 思路分析：
     * 分别往四个方向顺序遍历元素并填充
     */
    public int[][] generateMatrix(int n) {
        // 定义二维矩阵matrix[][]
        int[][] matrix = new int[n][n];

        // 定义计数器
        int cnt = 1;

        // 定义4个方向的指针分别用于控制遍历方向的范围(左右范围:[0,n-1],上下范围:[0,n-1])
        int top = 0, bottom = n - 1, left = 0, right = n - 1;

        while (top <= bottom && left <= right) {
            // ① 从左到右遍历
            for (int j = left; j <= right; j++) {
                matrix[top][j] = cnt;
                cnt++;
            }
            top++;


            // ② 从上到下遍历
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = cnt;
                cnt++;
            }
            right--;

            // ③ 从右到左遍历
            if (left <= right) {
                for (int j = right; j >= left; j--) {
                    matrix[bottom][j] = cnt;
                    cnt++;
                }
                bottom--;
            }

            // ④ 从下到上遍历
            if (top <= bottom) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = cnt;
                    cnt++;
                }
                left++;
            }
        }

        // 返回处理结果
        return matrix;
    }
}
