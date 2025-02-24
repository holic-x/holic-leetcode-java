package com.noob.algorithm.leetcode.q801_q900.q827;

import com.noob.algorithm.base.util.PrintUtil;

import java.util.Arrays;

/**
 * 🔴 827 最大人工岛 - https://leetcode.cn/problems/making-a-large-island/
 */
public class Solution1 {

    int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    int curArea = 0; // 当前遍历岛屿面积

    // DFS
    private void dfs(int[][] grid, int x, int y, boolean[][] visited) {
        int m = grid.length, n = grid[0].length;
        // 递归出口（节点越界或者非陆地、已遍历过的陆地）
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0 || visited[x][y]) {
            return;
        }

        // 处理当前陆地
        if (grid[x][y] == 1) {
            curArea++; // 岛屿面积+1
            visited[x][y] = true; // 标记节点为已遍历
        }

        // 递归处理其邻接节点
        for (int i = 0; i < 4; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];
            dfs(grid, nextX, nextY, visited);
        }
    }

    // 获取当前地图的最大岛屿面积
    public int getMaxIslandArea(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // 初始化visited
        boolean[][] visited = new boolean[m][n];
        for (boolean[] v : visited) {
            Arrays.fill(v, false);
        }

        int maxArea = 0;
        // 遍历每个节点
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                curArea = 0; // 重置岛屿面积计数器
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, visited); // 递归搜索 获取岛屿面积
                    maxArea = Math.max(maxArea, curArea); // 更新最大岛屿面积
                }
            }
        }
        return maxArea;
    }

    /**
     * 思路分析：
     * 1.地图更新：遍历每个海域，尝试将其改造成陆地，随后基于DFS获取更新后的地图每个岛屿的面积，获取最大值
     * 2.岛屿标记：
     * - 2.1 将每个岛屿的土地进行标记划分（例如岛屿1标记为1、岛屿2标记为2.....依次类推）
     * - 2.2 再次遍历标记后的岛屿，尝试将海域改造成陆地，通过判断其是否邻接岛屿来计算改造更新后的岛屿面积
     */
    public int largestIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // int maxArea = 0; // 获取改造后可构成的最大岛屿面积
        int maxArea = -1; // 如果没有海域可改造，那么原地图中的最大岛屿面积即所得
        // 遍历每一个海域，将其改造成陆地，获取更新后的地图中的最大岛屿面积
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    System.out.print("(" + i + "," + j + ")" + "节点改造前：");
                    PrintUtil.printMatrix(grid);
                    grid[i][j] = 1; // 将海域改造成陆地
                    maxArea = Math.max(maxArea, getMaxIslandArea(grid));
                    System.out.print("(" + i + "," + j + ")" + "节点改造后：");
                    PrintUtil.printMatrix(grid);
                    grid[i][j] = 0; // 恢复现场
                    System.out.println("**********************************");
                }
            }
        }
        // 返回改造后的最大岛屿面积
        return maxArea != -1 ? maxArea : m * n;
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[][] grid = new int[][]{{0, 0}, {0, 1}};
        int res = s.largestIsland(grid);
        System.out.println(res);
    }


}
