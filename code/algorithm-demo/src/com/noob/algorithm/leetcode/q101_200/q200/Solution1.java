package com.noob.algorithm.leetcode.q101_200.q200;

/**
 * 🟡 200 岛屿数量 - https://leetcode.cn/problems/number-of-islands/description/
 * - DFS 版本
 */
public class Solution1 {

    // 定义遍历的4个方向
    int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    /**
     * 思路分析：遍历每块未被访问过的陆地区域，基于该点作为起点对周边区域进行遍历渲染
     * - ① 计数：通过寻找一个岛屿起点，然后对其连接的周边区域进行渲染，一个起点就是对应一个岛屿
     * - ② 重复问题：因为在渲染的过程中只要找到1个起点会对已经遍历的区域进行比较，因此可以确保对于同一个岛屿不会被遍历多次
     */
    public int numIslands(char[][] grid) {
        int cnt = 0;
        // 遍历矩阵的每个区域，以陆地作为起点进行搜索
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 如果当前遍历区域为陆地，则进一步进行深度搜索（将与该陆地相连）的区域进行渲染
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    cnt++; // 岛屿面积+1
                }
            }
        }
        // 返回岛屿数量
        return cnt;
    }

    // DFS检索
    private void dfs(char[][] grid, int x, int y) {
        int m = grid.length, n = grid[0].length;
        // 如果节点越界、非陆地 或者当前区域已经被遍历过则退出
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == '0' || grid[x][y] == '2') {
            return;
        }

        // 更新当前节点遍历状态（标记未2表示该陆地已经被遍历过）
        if (grid[x][y] == '1') {
            grid[x][y] = '2';
        }

        // 处理节点：获取nextX、nextY
        for (int i = 0; i < 4; i++) { // 往4个方向进行检索
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];
            // 递归调用方法进行遍历
            dfs(grid, nextX, nextY);
        }
    }

}
