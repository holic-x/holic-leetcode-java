package com.noob.algorithm.leetcode.q801_q900.q827;


import com.noob.algorithm.base.util.PrintUtil;

import java.util.*;

/**
 * 🔴 827 最大人工岛 - https://leetcode.cn/problems/making-a-large-island/
 */
public class Solution2 {

    int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    int curNum = 2; // 当前遍历岛屿编号（此处设定从2开始进行岛屿编号）
    int curArea = 0; // 当前遍历岛屿面积

    // DFS
    private void dfs(int[][] grid, int x, int y, boolean[][] visited) {
        int m = grid.length, n = grid[0].length;
        // 递归出口（节点越界或者非陆地、已遍历过的陆地）
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0 || visited[x][y]) {
            return;
        }

        // 处理当前陆地
        if (grid[x][y] == 1) {
            curArea++; // 岛屿面积+1
            grid[x][y] = curNum;// 将当前陆地进行标记（标记其归属哪个岛屿）
            visited[x][y] = true; // 标记节点为已遍历
        }

        // 递归处理其邻接节点
        for (int i = 0; i < 4; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];
            dfs(grid, nextX, nextY, visited);
        }
    }

    // 封装岛屿编号和面积的映射关系
    public Map<Integer, Integer> getMaxIslandArea(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        // 封装岛屿编号和面积的映射关系
        Map<Integer, Integer> map = new HashMap<>();

        // 初始化visited
        boolean[][] visited = new boolean[m][n];
        for (boolean[] v : visited) {
            Arrays.fill(v, false);
        }
        // 遍历每个节点
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                curArea = 0; // 重置岛屿面积计数器
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, visited); // 递归搜索 获取岛屿面积
                    // 当前岛屿搜索完成，封装岛屿编号和其面积
                    map.put(curNum, curArea);
                    curNum++; // 编号自增，为下一个岛屿的遍历搜索做准备
                }
            }
        }
        return map;
    }

    /**
     * 思路分析：
     * 1.地图更新：遍历每个海域，尝试将其改造成陆地，随后基于DFS获取更新后的地图每个岛屿的面积，获取最大值
     * 2.岛屿标记：
     * - 2.1 将每个岛屿的土地进行标记划分（例如岛屿1标记为1、岛屿2标记为2.....依次类推）
     * - 2.2 再次遍历标记后的岛屿，尝试将海域改造成陆地，通过判断其是否邻接岛屿来计算改造更新后的岛屿面积
     */
    public int largestIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int maxArea = -1; // 如果没有海域可改造，那么原地图中的最大岛屿面积即所得

        // ① 获取岛屿和其面积映射
        System.out.println("标记前：");
        PrintUtil.printMatrix(grid);
        Map<Integer, Integer> map = getMaxIslandArea(grid);
        // 打印标记后的岛屿信息
        System.out.println("标记后：");
        PrintUtil.printMatrix(grid);


        // ② 遍历每一个海域，校验其是否邻接岛屿，如果临接岛屿则说明连成一片，追加岛屿面积
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    // 记录已经连接过的岛屿（即邻接的节点可能连通同一片岛屿，避免重复计算）
                    Set<Integer> set = new HashSet<>();
                    int curArea = 1; // 定义当前改造的面积
                    // 校验邻接节点是否为岛屿
                    for (int k = 0; k < 4; k++) {
                        int nextX = i + dir[k][0];
                        int nextY = j + dir[k][1];
                        // 如果邻接点越界，说明达到边界，跳过校验
                        if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) {
                            continue;
                        }
                        // 如果邻接点为岛屿（在有效的岛屿编号范围内）
                        /*
                        if (grid[nextX][nextY] >= 2) {
                            // 追加邻接岛屿的面积
                            curArea += map.get(grid[nextX][nextY]);
                        }
                         */
                        int islandNum = grid[nextX][nextY];
                        if (!set.contains(islandNum)) { // 校验该岛屿是否已经计算过
                            curArea += map.getOrDefault(grid[nextX][nextY], 0); // 追加岛屿面积
                            set.add(islandNum);
                        }
                    }
                    System.out.println("当前改造节点(" + i + "," + j + ")" + "改造后的面积为" + curArea);
                    // 更新改造后的最大面积
                    maxArea = Math.max(curArea, maxArea);
                }
            }
        }
        // 返回改造后的最大岛屿面积
        return maxArea != -1 ? maxArea : m * n;
    }


    public static void main(String[] args) {
        Solution2 s = new Solution2();
//        int[][] grid = new int[][]{{1, 1}, {1, 0}};
        int[][] grid = new int[][]{
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 0, 0},
                {0, 1, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 0, 0},
                {0, 1, 1, 1, 1, 0, 0}
        };
        int res = s.largestIsland(grid);
        System.out.println(res);
    }

}
