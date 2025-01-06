package com.noob.algorithm.leetcode.q074;

/**
 * 🟡 74.搜索二维矩阵检索 - https://leetcode.cn/problems/search-a-2d-matrix/
 */
class Solution2 {

    /**
     * 思路2：将二维数组坐标转化为一维数组坐标，然后使用二分法
     */
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