package com.noob.algorithm.leetcode.q001_100.q074;

/**
 * 🟡 74.搜索二维矩阵检索 - https://leetcode.cn/problems/search-a-2d-matrix/
 */
class Solution3 {

    /**
     * 思路3: 一次二分查找（逐行检索，一行中按照二分查找法进行定位）
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            // 校验每行的二分检索结果
            int findRow = binarySearch(matrix[i],target);
            // 二分检索成功返回true
            if (findRow != -1) {
                return true;
            }
        }
        return false;
    }

    /**
     * 定义二分查找方法（针对一维数组）
     */
    public int binarySearch(int[] row, int target) {
        int left = 0, right = row.length - 1;
        while (left <= right) {
            // 定义中点位置
            int mid = left + (right - left) / 2;
            // 与target进行比较
            if(row[mid] == target) {
                return mid;
            }else if(target < row[mid]) {
                right = mid - 1;
            }else if(target > row[mid]) {
                left = mid + 1;
            }
        }
        // 无匹配元素返回-1（如果是要返回下一个插入位置则return left或者right+1）
        return -1;
    }
}