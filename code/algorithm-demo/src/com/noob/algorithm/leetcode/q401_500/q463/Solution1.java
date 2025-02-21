package com.noob.algorithm.leetcode.q401_500.q463;

/**
 * 🟢 463 岛屿的周长 - https://leetcode.cn/problems/island-perimeter/description/
 */
public class Solution1 {

    int curPerimeter = 0;

    int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int islandPerimeter(int[][] grid) {
        int totalPerimeter = 0;
        // 遍历每个可能的岛屿起点
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                curPerimeter = 0; // 重置岛屿周长计数
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    totalPerimeter += curPerimeter; // 累计各岛屿周长
                }
            }
        }
        // 返回岛屿总周长
        return totalPerimeter;
    }

    // DFS 思路
    private void dfs(int[][] grid, int x, int y) {
        int m = grid.length, n = grid[0].length;
        // 节点越界|非陆地|已遍历的陆地 则退出搜索
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != 1) { // grid[x][y] == 0 || grid[x][y] == 2
            return;
        }

        // 标记节点
        if (grid[x][y] == 1) {
            // 处理当前陆地周长：判断其四周的接触情况（如果当前区域接触边缘或水域（即其邻接节点越界或者为水域）则需计算边长）
            for (int i = 0; i < 4; i++) {
                int nextX = x + dir[i][0];
                int nextY = y + dir[i][1];
                if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) {
                    // 如果邻接节点越界（说明接触边缘），则需计算周长
                    curPerimeter++;
                }else if (grid[nextX][nextY] == 0) {
                    // 如果邻接节点为水域，则需计算周长
                    curPerimeter++;
                }
            }
            // 标记节点已处理
            grid[x][y] = 2;
        }

        // 递归处理下一节点
        for (int i = 0; i < 4; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];
            dfs(grid, nextX, nextY);
        }

    }
}
