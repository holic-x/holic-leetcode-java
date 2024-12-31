package com.noob.algorithm.leetcode.q74;

/**
 * 74.搜索二维矩阵检索
 * 思路1：暴力检索（迭代二维矩阵）
 */
class Solution1 {
    // 暴力检索
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j=0;j<matrix[i].length;j++) {
                if(matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}