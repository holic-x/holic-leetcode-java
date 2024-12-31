package com.noob.algorithm.leetcode.q74;

/**
 * 74.搜索二维矩阵检索
 * 思路2：将二维数组坐标转化为一维数组坐标，然后使用二分法
 */
class Solution2 {
    public boolean searchMatrix(int[][] matrix, int target) {

        int left = 0, right = (matrix.length * matrix[0].length) - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int midX = mid / matrix[0].length;
            int midY = mid % matrix[0].length;
            if (matrix[midX][midY] == target) {
                return true;
            } else if (matrix[midX][midY] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}