package com.noob.algorithm.leetcode.q001_100.q003;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // 初始化测试用例
    public static List<String> initCase() {
        List<String> castList = new ArrayList<>();
        castList.add("abcabcbb");
        castList.add("bbbbbb");
        castList.add("pwwkew");
        castList.add("");
        castList.add("  ");
        castList.add(" ");
        return castList;
    }

    public static void testSolution1(List<String> strList) {
        Solution1 solution1 = new Solution1();
        for (String str : strList) {
            System.out.println(solution1.lengthOfLongestSubstring(str));
        }
    }

    public static void testSolution2(List<String> strList) {
        Solution2 solution2 = new Solution2();
        for (String str : strList) {
            System.out.println(solution2.lengthOfLongestSubstring(str));
        }
    }

    public static void main(String[] args) {
        List<String> caseList = initCase();

        testSolution1(caseList);
        System.out.println("---------------------------------------------------");
        testSolution2(caseList);
    }

}
