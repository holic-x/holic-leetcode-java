package com.noob.algorithm.leetcode.q035;


import com.noob.algorithm.leetcode.q279.Solution;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // 参数集合列表（case列表下标一一对照）
    static List<int[]> param1List = new ArrayList<>();
    static List<Integer> param2List = new ArrayList<>();


    // 初始化测试用例
    public static void initCase() {
        // todo 补充测试用例集合

        // 参数1
        param1List.add(new int[]{1, 3, 5, 6});
        param1List.add(new int[]{1, 3, 5, 6});
        param1List.add(new int[]{1, 3, 5, 6});

        // 参数2
        param2List.add(5);
        param2List.add(2);
        param2List.add(7);

        // other param


        // 校验测试用例集合
        if (param1List.size() != param2List.size()) {
            throw new RuntimeException("测试用例集合不匹配，请确认测试用例集合");
        }
    }

    public static void testSolution1(List<int[]> param1List, List<Integer> param2List) {

        Solution1 solution = new Solution1();
        for (int i = 0; i < param1List.size(); i++) {
            int res = solution.searchInsert(param1List.get(i), param2List.get(i));
            System.out.println(res);
        }

    }


    public static void testSolution2(List<int[]> param1List, List<Integer> param2List) {

        Solution2 solution = new Solution2();
        for (int i = 0; i < param1List.size(); i++) {
            int res = solution.searchInsert(param1List.get(i), param2List.get(i));
            System.out.println(res);
        }

    }

    public static void testSolution3(List<int[]> param1List, List<Integer> param2List) {

        Solution3 solution = new Solution3();
        for (int i = 0; i < param1List.size(); i++) {
            int res = solution.searchInsert(param1List.get(i), param2List.get(i));
            System.out.println(res);
        }

    }


    public static void main(String[] args) {

        // ---------- 初始化测试用例 ----------
        initCase();


        // ---------- 测试算法 ----------
        testSolution1(param1List, param2List);

        System.out.println("-------------------------------");

        testSolution2(param1List, param2List);

        System.out.println("-------------------------------");

        testSolution3(param1List, param2List);

    }
}
