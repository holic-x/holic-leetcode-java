package com.noob.algorithm.leetcode.q701_800.q743;

import java.util.Arrays;

/**
 * 🟡 743 网络延迟时间 - https://leetcode.cn/problems/network-delay-time/description/
 */
public class Solution1 {

    int INF = Integer.MAX_VALUE / 2; // 设置为最大值，或者比题目设定大大些均可（满足通过用例的前提下）

    /**
     * @param times [u,v,w] 有向边及边值关系
     * @param n     顶点个数(节点标记是1-n)
     * @param k     起点 K
     * @return
     */
    public int networkDelayTime(int[][] times, int n, int k) {
        // ① 处理边数据，将其转化为邻接矩阵
        int[][] grid = new int[n + 1][n + 1];
        // 初始化所有矩阵边权值为(可以用 -1 表示不可达 || 或者设定一个最大值边界进行处理)
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(grid[i], INF);
        }
        // 处理边数据
        for (int[] edge : times) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            grid[u][v] = w;
        }

        // ② 调用dijkstra算法获取源点到任意点的最短距离
        int[] minDist = dijkstra(grid, n, k);

        // 此处获取所有节点接收到信号的时间应该是minDist的最大值（而不是到达某个节点的延迟时间累加）
        int max = 0;
        for (int i = 0; i < minDist.length; i++) {
            if (minDist[i] == INF) {
                return -1; // 源点不可达i
            }
            max = Math.max(max, minDist[i]);
        }
        // 返回结果
        return max;
    }

    // dijkstra
    private int[] dijkstra(int[][] grid, int n, int source) {
        // 维护一个minDist表示源点到节点i的最短距离
        int[] minDist = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // 初始化（此处根据源点校验，源点到源点自身的距离设置为0,他节点的最短距离默认设置为范围内的最大值）
            minDist[i] = (i == source) ? 0 : INF;
        }

        boolean[] visited = new boolean[n + 1]; // 存储节点的访问状态
        Arrays.fill(visited, false);

        // 遍历所有节点
        for (int i = 1; i <= n; i++) {
            // ① 从当前minDist中选出一个距离源点最近的未被访问的节点
            int cur = -1;
            int curVal = INF;
            for (int j = 1; j < minDist.length; j++) {
                // 如果节点还没被访问过，则尝试更新min（即选出一个minDist[j]最小的）
                if (!visited[j] && (cur == -1 || minDist[j] < curVal)) { // 如果是初始化状态或者出现更小的值则进行更新
                    cur = j;
                    curVal = minDist[j];
                }
            }

            // ② 将当前选中节点标记为已遍历（表示将其选中）
            visited[cur] = true;

            // ③ 更新当前未被处理节点到源点的最短距离（即原source->i的距离，确认是否存在source->cur->i的更短的路径）
            for (int k = 1; k < minDist.length; k++) {
                if (!visited[k] && grid[cur][k] != -1) {
                    minDist[k] = Math.min(minDist[k], minDist[cur] + grid[cur][k]);
                }
            }
        }

        // 返回构建的数组
        return minDist;
    }

}
