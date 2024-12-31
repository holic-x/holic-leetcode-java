package com.noob.algorithm.leetcode.q131;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 131.分割回文串
 */
public class Solution {

    // 定义结果集
    List<List<String>> res = new ArrayList<List<String>>();
    // 定义临时子集
    List<String> temp = new ArrayList<>();

    /**
     * 核心：求子集、判断回文
     *
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        dfs(0, s); // 执行dfs操作，起始从0开始
        return res; // 返回结果
    }

    /**
     * 构造递推方法（深度遍历）
     * idx 为当前切割位置，s为目标字符串
     */
    public void dfs(int idx, String s) {
        // 如果切割位置和字符串长度相同，则更新结果集并返回
        if (idx == s.length()) {
            res.add(new ArrayList<>(temp)); // 此处需设定new一个子集
            return;
        }
        for (int i = idx; i < s.length(); i++) {
            // 判断是否为回文字符串
            String subStr = s.substring(idx, i + 1);
            if (isHuiWen(subStr)) {
                // 加入回文字符串，然后进行递推操作，最后复原现场
                temp.add(subStr); // 加入子集
                dfs(i + 1, s); // 执行递推
                temp.remove(temp.size() - 1); // 复原现场
            }
        }
    }

    // 双指针校验回文：校验效率较高（参考整体响应8ms）
    public boolean isHuiWen1(String str) {
        // 通过双指针来校验回文，指针相遇则说明满足回文
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            // 指针移动
            start++;
            end--;
        }
        return true;
    }

    // 字符串反转校验回文，校验效率较低（参考整体响应16ms）
    public boolean isHuiWen(String str) {
        // 通过字符串反转来校验回文
        String reverseStr = new StringBuilder(str).reverse().toString();
        return str.equals(reverseStr);
    }
}
