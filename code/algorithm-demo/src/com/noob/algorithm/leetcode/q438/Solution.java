package com.noob.algorithm.leetcode.q438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438.找到字符串中所有字母异位词
 * 字母异位词：可以从两个点切入，排序后的字母序列是一致的 或者 字符串中每个字符出现的个数是一样的
 */
public class Solution {

    /**
     * @param s 原字符串
     * @param p 目标字符串
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        // 定义结果
        List<Integer> res = new ArrayList<Integer>();

        // 对目标字符串进行排序
        char[] pArr =  p.toCharArray();
        Arrays.sort(pArr);
        p = new String(pArr);

        // 定义滑动窗口的左右指针
        int left = 0,right = pArr.length;

        // 当窗口移动到数组尾部则结束
        while(right<=s.length()){
            // 判断窗口队列排序后的序列是否和排序后的p一致
            char[] subArr = s.substring(left,right).toCharArray();
            Arrays.sort(subArr);
            if(p.equals(String.valueOf(subArr))){
                res.add(left);
            }
            // 窗口右移（左右指针右移）
            left ++;
            right ++;
        }

        // 返回结果
        return res;
    }

    public static void main(String[] args) {
//        String s = "cbaebabacd";
//        String p = "abc";

        String s = "abab";
        String p = "ab";

        Solution solution = new Solution();
        System.out.println(solution.findAnagrams(s, p));
    }
}
