package com.noob.algorithm.leetcode.q73;

/**
 * 73.矩阵置零
 * 思路：标记置0操作
 */
public class Solution {

    public void setZeroes(int[][] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        // 定义置零的行、列标记（一维数组）
        boolean[] row = new boolean[rowLen];
        boolean[] col = new boolean[colLen];

        // 循环遍历矩阵，校验元素是否为0，为0则进行标记
        for(int i=0;i<rowLen;i++) {
            for(int j=0;j<colLen;j++) {
                if(matrix[i][j]==0) {
                    // 将对应行、列进行标记
                    row[i]=col[j]=true;
                }
            }
        }

        // 再次循环遍历矩阵，根据标记进行置零
        for(int i=0;i<rowLen;i++) {
            for(int j=0;j<colLen;j++) {
                if(row[i] || col[j]) {
                    matrix[i][j]=0;
                }
            }
        }
    }
}
