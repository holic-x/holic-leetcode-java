package com.noob.algorithm.leetcode.q1101_q1200.q1192;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 🔴 1192 查找集群内的关键连接 - https://leetcode.cn/problems/critical-connections-in-a-network/description/
 */
public class Solution1 {

    private int time = 0;

    /**
     *
     * @param n 节点个数
     * @param connections 连接情况（边[0,1]表示节点0与节点1之间存在边）
     */
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // ① 构建邻接表(List<List<Integer>> graph || List<Integer>[] graph)
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (List<Integer> connection : connections) {
            int u = connection.get(0);
            int v = connection.get(1);
            graph[u].add(v);
            graph[v].add(u);
        }

        // 初始化核心数组
        int[] disc = new int[n]; // 每个节点的访问顺序
        int[] low = new int[n]; // 通过回边能够到达的最小访问顺序
        int[] parent = new int[n]; // 每个节点的父节点
        Arrays.fill(disc, -1);
        Arrays.fill(parent, -1);

        // 定义结果集
        List<List<Integer>> result = new ArrayList<>();

        // DFS遍历
        for (int i = 0; i < n; i++) {
            if (disc[i] == -1) {
                dfs(i, disc, low, parent, graph, result);
            }
        }

        return result;
    }

    private void dfs(int u, int[] disc, int[] low, int[] parent, List<Integer>[] graph, List<List<Integer>> result) {
        disc[u] = low[u] = ++time;

        for (int v : graph[u]) {
            if (disc[v] == -1) { // 如果v未被访问过
                parent[v] = u;
                dfs(v, disc, low, parent, graph, result);

                // 更新low[u]
                low[u] = Math.min(low[u], low[v]);

                // 判断是否是桥
                if (low[v] > disc[u]) {
                    result.add(Arrays.asList(u, v));
                }
            } else if (v != parent[u]) { // 如果v已被访问过且不是u的父节点
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

}
