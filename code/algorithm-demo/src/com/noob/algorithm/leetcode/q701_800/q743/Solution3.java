package com.noob.algorithm.leetcode.q701_800.q743;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 🟡 743 网络延迟时间 - https://leetcode.cn/problems/network-delay-time/description/
 */
public class Solution3 {

    int INF = Integer.MAX_VALUE / 2; // 设置为最大值，或者比题目设定大大些均可（满足通过用例的前提下）

    static class Edge {
        public int u;
        public int v;
        public int w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    /**
     * @param times [u,v,w] 有向边及边值关系
     * @param n     顶点个数(节点标记是1-n)
     * @param k     起点 K
     * @return
     */
    public int networkDelayTime(int[][] times, int n, int k) {
        // ① 处理边数据，将其转化为邻接表
        List<List<Edge>> grid = new ArrayList<>(n + 1);
        for (int i = 0; i < n + 1; i++) {
            grid.add(new ArrayList<>());
        }
        // 处理边数据
        for (int[] edge : times) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            grid.get(u).add(new Edge(u, v, w));
        }

        // ② 调用spfa算法获取源点到任意点的最短距离
        int[] minDist = spfa(grid, n, k);

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

    // bellman_ford 算法 优化版本 SPFA 算法
    private int[] spfa(List<List<Edge>> grid, int n, int source) {
        // 维护一个minDist表示源点到节点i的最短距离
        int[] minDist = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // 初始化（此处根据源点校验，源点到源点自身的距离设置为0,他节点的最短距离默认设置为范围内的最大值）
            minDist[i] = (i == source) ? 0 : INF;
        }

        // 定义队列维护上一次松弛操作更新的节点
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source); // 初始化源点入队

        // 只对上一次松弛操作更新后的节点关联的边进行松弛操作（相当于过滤掉其他无效松弛）
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int i = 1; i < n; i++) {
                for (Edge next : grid.get(u)) {
                    int v = next.v;
                    int w = next.w;
                    if (minDist[u] != INF && minDist[u] + w < minDist[v]) {
                        minDist[v] = minDist[u] + w;
                        if (!queue.contains(v)) {
                            queue.offer(v); // 将更新的节点加入队列（如果已经加入的节点不重复加入）
                        }
                    }
                }
            }
        }

        // 返回构建的数组
        return minDist;
    }

}
