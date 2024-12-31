package com.noob.algorithm.leetcode.q54;

import java.util.ArrayList;
import java.util.List;

/**
 * 54.螺旋矩阵
 * 思路：四指针依次循环读取
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        // 定义结果集合
        List<Integer> list = new ArrayList<Integer>();

        // 矩阵大小(m*n)[[a,b,c],[a,b,c]] => 3*2
        int m = matrix[0].length, n = matrix.length;

        // 定义4个边界指针并初始化
        int left = 0, right = m - 1, top = 0, bottom = n - 1;

        // 循环遍历4个方向，当指针相遇时候遍历停止
        while(left <= right && top <= bottom) { // 或者是list.size < m * n(因为res.size()==m×n`表示已经将当前矩阵所有元素塞入结果集了)
            // 从左往右循环一遍（行不变），遍历完成top边界下移
            for(int i=left;i<=right;i++){
                list.add(matrix[top][i]);
            }
            top++;// top边界下移

            // 从上往下循环一遍（列不变），遍历完成right边界左移
            for(int i=top;i<=bottom;i++){
                list.add(matrix[i][right]);
            }
            right--;

            // 从右往左循环一遍（行不变），遍历完成左边界右移
            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    list.add(matrix[bottom][i]);
                }
            }
            bottom--;

            // 从下往上循环一遍（行不变），遍历完成左边界右移
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    list.add(matrix[i][left]);
                }
            }
            left++;
        }

        // 返回结果集
        return list;

    }
}