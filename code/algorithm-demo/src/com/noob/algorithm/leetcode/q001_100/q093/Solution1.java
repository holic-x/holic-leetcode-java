package com.noob.algorithm.leetcode.q001_100.q093;

import java.util.ArrayList;
import java.util.List;

/**
 * 🟡 093 复原IP地址 - https://leetcode.cn/problems/restore-ip-addresses/description/
 */
public class Solution1 {

    List<String> res = new ArrayList<>(); // 记录结果集
    List<String> curPath = new ArrayList<>(); // 当前切割路径

    /**
     * 思路分析：回溯法，确定每个切割位置
     */
    public List<String> restoreIpAddresses(String s) {
        // 调用回溯算法进行处理
        backTrack(s, 0);
        // 返回结果集
        return res;
    }

    private void backTrack(String s, int idx) {
        if (idx >= s.length()) {
            // 如果当前切割方案的元素数量为4个则满足切割条件，载入结果集
            if (curPath.size() == 4) {
                res.add(String.join(".", curPath));
            }
            return;
        }

        // 回溯处理
        for (int i = idx; i < s.length(); i++) {
            // 选择切割位置，校验切割的字符串是否满足切割条件
            String subStr = s.substring(idx, i + 1); // 校验当前切割范围字符串是否有效
            long subInt = Long.valueOf(subStr);
            // subStr要么为0，如果不为0则取值在(0,255]且字符串不能以0开头
            if (subStr.equals("0") || (!subStr.equals("0") && !subStr.startsWith("0") && subInt > 0 && subInt <= 255)) {
                // 满足切割条件，可进行切割
                curPath.add(subStr); // 选择
                backTrack(s, i + 1); // 选择下一个切割位置
                curPath.remove(curPath.size() - 1); // 恢复现场
            }
        }
    }
}
