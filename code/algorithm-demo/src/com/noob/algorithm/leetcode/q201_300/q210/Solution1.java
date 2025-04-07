package com.noob.algorithm.leetcode.q201_300.q210;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 🟡 210 课程表II - https://leetcode.cn/problems/course-schedule-ii/description/
 */
public class Solution1 {

    /**
     * 思路：拓扑排序思路
     * prerequisites[][] 表示选修a课程之前必须先选修b（即b->a存在边），n 门课程记录编号为[0,n-1]
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 定义数组分别用于记录每个节点的入度（节点编号与数组下标索引对照）
        int[] inDegrees = new int[numCourses];

        // 遍历边关系处理节点入度
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>()); // 初始化
        }

        // 处理入度
        for (int[] edge : prerequisites) {
            // u->v 存在边
            int u = edge[1];
            int v = edge[0];
            inDegrees[v]++; // 表示(u->v)的边关系，即节点v的入度+1
            graph.get(u).add(v); // 记录边关系（与节点u关联的节点v）
        }

        // 定义队列，用于存储入度为0的节点（每次取出入度为0的节点进行处理），此处初始化队列
        Queue<Integer> nodeQueue = new LinkedList<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                nodeQueue.offer(i); // 入度为0的节点入队
            }
        }

        List<Integer> ans = new ArrayList<>();
        // 处理队列
        while (!nodeQueue.isEmpty()) {
            // 取出节点,并记录结果
            int u = nodeQueue.poll();
            ans.add(u);

            // 更新其连接的下一个节点的入度
            for (int v : graph.get(u)) {
                inDegrees[v]--;
                // 判断更新后的入度是否为0.如果入度为0则加入队列
                if (inDegrees[v] == 0) {
                    nodeQueue.offer(v);
                }
            }
        }

        // 检查是否可以完成所有课程(结果集size与课程数量相同则说明找到一组符合的拓扑排序)
        if (ans.size() != numCourses) {
            return new int[0];
        }

        // 返回结果
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
