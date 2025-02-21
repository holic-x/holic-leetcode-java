package com.noob.algorithm.leetcode.q601_q700.q695;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 🟡 695 岛屿的最大面积 - https://leetcode.cn/problems/max-area-of-island/description/
 * - BFS 版本
 */
public class Solution2 {

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
                    bfs(grid, i, j); // 递归搜索计算岛屿区域面积
                    maxArea = Math.max(maxArea, curArea); // 更新最大岛屿面积
                }
            }
        }
        // 返回结果
        return maxArea;
    }

    private void bfs(int[][] grid, int x, int y) {
        int m = grid.length, n = grid[0].length;
        // 构建队列辅助遍历
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(x, y)); // 初始化队列
        grid[x][y] = 2; // 只要加入队列就立刻进行标记
        curArea++; // 岛屿陆地面积+1

        // 队列不为空，遍历节点
        while (!queue.isEmpty()) {
            // 取出当前节点
            Pair cur = queue.poll();
            int curX = cur.x;
            int curY = cur.y;
            // 往4个方向进行BFS检索
            for (int i = 0; i < 4; i++) {
                // 计算下一个相邻的节点坐标
                int nextX = curX + dir[i][0];
                int nextY = curY + dir[i][1];
                // 校验节点坐标是否有效（无效/越界则跳过）
                if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) {
                    continue; // 节点无效，跳过
                }
                // 判断下一个节点是否为未被遍历过的陆地，是则进行标记并加入队列
                if (grid[nextX][nextY] == 1) {
                    grid[nextX][nextY] = 2; // 标记当前陆地为已遍历（只要加入队列就立刻进行标记）
                    curArea++; // 岛屿陆地面积+1
                    queue.offer(new Pair(nextX, nextY)); // 加入队列
                }
            }
        }
    }

    // 自定义节点类
    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
