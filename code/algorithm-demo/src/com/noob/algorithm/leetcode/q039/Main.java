package com.noob.algorithm.leetcode.q039;


import com.noob.algorithm.base.util.PrintUtil;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // todo
    // 参数集合列表（case列表下标一一对照）
    static List<int[]> param1List = new ArrayList<>();
    static List<Integer> param2List = new ArrayList<>();


    // 初始化测试用例
    public static void initCase() {
        // todo 补充测试用例集合

        // 参数1
        param1List.add(new int[]{2, 3, 6, 7});
        param1List.add(new int[]{2, 3, 5});
        param1List.add(new int[]{2});

        // 参数2
        param2List.add(7);
        param2List.add(8);
        param2List.add(1);

        // other param


        // 校验测试用例集合
        if (param1List.size() != param2List.size()) {
            throw new RuntimeException("测试用例集合不匹配，请确认测试用例集合");
        }
    }

    public static void testSolution1(List<int[]> param1List, List<Integer> param2List) {
        for (int i = 0; i < param1List.size(); i++) {
            Solution1 solution = new Solution1(); // 注意对象引用问题
            List<List<Integer>> res = solution.combinationSum(param1List.get(i), param2List.get(i));
            PrintUtil.printMatrix(res);
        }
    }


    public static void testSolution2(List<int[]> param1List, List<Integer> param2List) {
        for (int i = 0; i < param1List.size(); i++) {
            Solution2 solution = new Solution2(); // 注意对象引用问题
            List<List<Integer>> res = solution.combinationSum(param1List.get(i), param2List.get(i));
            PrintUtil.printMatrix(res);
        }
    }


    public static void main(String[] args) {

        // ---------- 初始化测试用例 ----------
        initCase();


        // ---------- 测试算法 ----------
        testSolution1(param1List, param2List);

        System.out.println("-------------------------------");

        testSolution2(param1List, param2List);

    }
}
