package com.noob.algorithm.leetcode.q601_q700.q695;

/**
 * 🟡 695 岛屿的最大面积 - https://leetcode.cn/problems/max-area-of-island/description/
 * - DFS 版本
 */
public class Solution1 {

    int curArea = 0; // 记录当前遍历岛屿的面积

    // 方向定义
    int[][] dir = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        // 遍历每个可能的岛屿起点
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 重置岛屿区间计数
                curArea = 0;
                // 如果当前区域为未被遍历过的陆地，则其可能作为岛屿区间
                if (grid[i][j] == 1) {
                    // 递归搜索计算岛屿区域面积
                    dfs(grid, i, j);
                    // 更新最大岛屿面积
                    maxArea = Math.max(maxArea, curArea);
                }
            }
        }
        // 返回结果
        return maxArea;
    }

    private void dfs(int[][] grid, int x, int y) {
        int m = grid.length, n = grid[0].length;
        // 递归出口（x、y越界 || 非陆地（标记为0） || 已经被遍历过的陆地（标记为2），退出检索）
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0 || grid[x][y] == 2) {
            return;
        }

        // 处理节点，将当前陆地区域标记为已被遍历
        if (grid[x][y] == 1) {
            grid[x][y] = 2;
            curArea++; // 当前岛屿面积+1
        }

        // 递归检索关联的区域
        for (int i = 0; i < 4; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];
            // 递归搜索下个节点
            dfs(grid, nextX, nextY);
        }
    }

}
