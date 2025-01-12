package com.noob.algorithm.leetcode.q001_100.q079;

/**
 * 🟡 79.单词搜索 - https://leetcode.cn/problems/word-search/
 */
public class Solution1 {
    public boolean exist(char[][] board, String word) {
        // 调用递推方法实现检索：依次遍历二维数组每个元素
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 调用递归方法校验是否存在路径，如果存在则直接记录结果返回
                if (dfs(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * dfs检索
     */
    public boolean dfs(char[][] board, String word, int idx, int row, int col) {
        // 结束条件（遇到边界（索引为负数或者超出长度）、当前元素与目标元素不符、当前元素已被访问则返回false；如果遍历到word的最后一位则说明存在匹配word则返回true）
        // 返回false的情况
        if (row >= board.length || row < 0 || col >= board[row].length || col < 0 || board[row][col] != word.charAt(idx) || board[row][col] == '0') {
            return false;
        }
        // 返回true的情况
        if (idx == word.length() - 1) {
            return true;
        }
        // 进入递推（将元素进行标记，随后往四个方向进行递推，最终复原元素）
        char ch = board[row][col]; // 记录当前遍历元素，并标记为已访问
        board[row][col] = '0';
        if (dfs(board, word, idx + 1, row - 1, col) || dfs(board, word, idx + 1, row + 1, col) || dfs(board, word, idx + 1, row, col - 1) || dfs(board, word, idx + 1, row, col + 1)) {
            return true; // 如果四个方向中有满足条件的则返回true
        }
        board[row][col] = ch; // 复原现场
        return false;
    }
}
