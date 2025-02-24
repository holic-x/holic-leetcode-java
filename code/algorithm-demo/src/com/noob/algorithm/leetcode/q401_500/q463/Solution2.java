package com.noob.algorithm.leetcode.q401_500.q463;

/**
 * 🟢 463 岛屿的周长 - https://leetcode.cn/problems/island-perimeter/description/
 */
public class Solution2 {

    static int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    /**
     * getCnt 用于统计每个岛屿"陆地"的周长（邻接海域、邻接边界）
     *
     * @param graph 邻接矩阵
     * @param x,y   当前遍历节点坐标
     */
    public static int getCnt(int[][] graph, int x, int y) {
        if (graph[x][y] != 1) {
            return 0; // 如果为非陆地，不执行任何操作
        }
        int curCnt = 0;
        // 分别从4个方向出发，校验当前节点邻接的4个方向的情况
        for (int i = 0; i < 4; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];

            // 如果邻接节点越界，则累加周长
            if (nextX < 0 || nextX >= graph.length || nextY < 0 || nextY >= graph[0].length) {
                curCnt++;
                continue; // 跳过
            }
            // 如果邻接海域，则累加周长
            if (graph[nextX][nextY] == 0) {
                curCnt++;
            }
        }
        // 返回当前陆地的边长计算情况
        return curCnt;
    }

    public int islandPerimeter(int[][] grid) {
        int totalPerimeter = 0;
        // 遍历每个可能的岛屿起点
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                totalPerimeter += getCnt(grid, i, j); // 累加每个节点的校验结果（在方法内部进行统一处理）
            }
        }
        // 返回岛屿总周长
        return totalPerimeter;
    }

}
