package com.noob.algorithm.base.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 数组打印工具类
 */
public class PrintArrUtil<T> {

    // 数组打印
    public void print(T[] dp) {
        for (int i = 0; i < dp.length; i++) {
            System.out.print("[" + dp[i] + "]" + "-");
        }
        System.out.println();
    }


    // 二维数组打印
    public void printMatrix(T[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print("[" + dp[i][j] + "]" + "-");
            }
            System.out.println(); // 换行
        }
    }

}
