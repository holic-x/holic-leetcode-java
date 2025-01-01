package com.noob.algorithm.base.util;

import java.util.List;

/**
 * 数组打印工具类
 */
public class PrintUtil {

    public static void print(int[] dp) {
        for (int i = 0; i < dp.length; i++) {
            System.out.print("[" + dp[i] + "]" + "-");
        }
        System.out.println();
    }

    public static void printMatrix(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print("[" + dp[i][j] + "]" + "-");
            }
            System.out.println(); // 换行
        }
    }

    /**
     * 图打印（邻接矩阵输出）
     *
     * @param graph
     */
    public static void printGraphMatrix(int[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < graph[i].length - 1; j++) {
                sb.append(graph[i][j]).append(" "); // 行内以空格进行间隔
            }
            sb.append(graph[i][graph[i].length - 1]); // 补上最后一位
            System.out.println("【" + i + "】" + sb);
        }
    }

    /**
     * 图打印（邻接表输出）
     *
     * @param graph
     */
    public static void printGraphTable(List<List<Integer>> graph) {
        for (int i = 0; i < graph.size(); i++) {
            StringBuffer sb = new StringBuffer();
            if (!graph.get(i).isEmpty()) {
                for (int j = 0; j < graph.get(i).size() - 1; j++) {
                    sb.append(graph.get(i).get(j)).append(" "); // 行内以空格进行间隔
                }
                sb.append(graph.get(i).get(graph.get(i).size() - 1)); // 补上最后一位
            }
            System.out.println("【" + i + "】" + sb);
        }
    }
}
