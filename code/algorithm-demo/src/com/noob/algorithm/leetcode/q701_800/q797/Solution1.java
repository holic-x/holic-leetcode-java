package com.noob.algorithm.leetcode.q701_800.q797;

import java.util.ArrayList;
import java.util.List;

/**
 * 🟡 797 所有可能的路径 - https://leetcode.cn/problems/all-paths-from-source-to-target/description/
 */
public class Solution1 {

    List<List<Integer>> res = new ArrayList<>(); // 存储结果集
    List<Integer> path = new ArrayList<>(); // 存储路径

    /**
     * 图的搜索（二维矩阵） - 有向无环图的搜索
     */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        path.add(0);
        dfs(graph, 0, graph.length - 1); // 节点区间[0,n-1]
        return res;
    }


    // DFS检索(x(当前遍历节点)->n(终点))
    private void dfs(int[][] graph, int x, int n) {
        // 递归出口：遍历节点x走到节点n，说明遍历到终点，找到一条可达路径
        if (x == n) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 回溯处理
        for (int i : graph[x]) {
            // 遍历节点i连接的所有节点
            path.add(i); // 加入节点
            dfs(graph, i, n); // 递归
            path.remove(path.size() - 1); // 恢复现场
        }
    }

}
