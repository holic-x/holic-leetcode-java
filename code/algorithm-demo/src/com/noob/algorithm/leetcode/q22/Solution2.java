package com.noob.algorithm.leetcode.q22;

import java.util.ArrayList;
import java.util.List;

/**
 * 22.括号生成
 * 思路：回溯法
 */
public class Solution2 {

    // 定义全局结果集合
    private List<String> res = new ArrayList<String>();

    public List<String> generateParenthesis(int n) {
        backtrack(0,0,n,new StringBuilder());
        return res;
    }

    // 思路：回溯法（深度遍历，根据左括号来决定放右括号）
    public void backtrack(int left, int right, int max, StringBuilder cur) {
        // left:左括号个数、right：右括号个数、max最大括号对数、cur当前构建的字符串序列

        // 如果当前括号字符串序列长度=2*max，说明符合条件（左右匹配规则在后面进行限定、剪枝，如果到达叶子节点则说明是满足的序列）
        if (cur.length() == 2 * max) {
            res.add(cur.toString());
            return;
        }

        // 如果左括号个数不足max说明还可继续添加左括号
        if (left < max) {
            cur.append("("); // 添加左括号
            backtrack(left + 1, right, max, cur); // 递归
            cur.deleteCharAt(cur.length() - 1); // 回溯
        }

        // 如果右括号小于左括号说明需要补足右括号
        if (right < left) {
            cur.append(")");
            backtrack(left, right + 1, max, cur);// 递归
            cur.deleteCharAt(cur.length() - 1); // 回溯
        }
    }

}
