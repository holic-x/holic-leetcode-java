package com.noob.algorithm.leetcode.q101_200.q200;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 🟡 200 岛屿数量 - https://leetcode.cn/problems/number-of-islands/description/
 * - BFS 版本
 */
public class Solution2 {

    // 自定义坐标类
    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // 定义遍历的4个方向
    int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    /**
     * 思路分析：通过队列辅助遍历,遍历每个可能的岛屿起点，基于该起点搜索其关联的区域并标记
     */
    public int numIslands(char[][] grid) {
        int cnt = 0;

        // 遍历每个可能的岛屿起点（没有被遍历过的陆地）
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j); // 调用BFS进行搜索，渲染与该陆地相连的区域
                    cnt++; // 岛屿+1
                }
            }
        }

        // 返回岛屿数量
        return cnt;
    }

    // BFS 检索(表示以(x,y)为起点进行广搜：只有没有被遍历过的陆地节点才需要进行广搜，避免重复搜索)
    private void bfs(char[][] grid, int x, int y) {
        int m = grid.length, n = grid[0].length;
        // 定义Queue辅助图遍历
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(x, y)); // 初始化队列
        grid[x][y] = '2'; // 只要加入队列就立刻进行标记

        // 当队列不为空，遍历节点
        while (!queue.isEmpty()) {
            // 取出当前节点
            Pair cur = queue.poll();
            int curX = cur.x;
            int curY = cur.y;
            // 往当前节点的4个方向进行遍历
            for (int i = 0; i < 4; i++) {
                // 获取当前节点的下一个坐标
                int nextX = curX + dir[i][0];
                int nextY = curY + dir[i][1];
                // 将节点加入队列（加入队列前进行节点校验和标记，避免不同方向的重复检索）
                if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) {
                    continue; // 当前节点越界，跳过
                }
                // 如果当前节点为没有被标记（遍历）过的陆地，则将其进行标记并加入队列
                if (grid[nextX][nextY] == '1') { // '2'表示陆地被遍历过的标记
                    grid[nextX][nextY] = '2'; // 只要加入队列就立刻进行标记
                    queue.offer(new Pair(nextX, nextY));
                }
            }
        }
    }

}
