package com.noob.algorithm.leetcode.q001_100.q034;


import com.noob.algorithm.base.util.PrintUtil;

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
        param1List.add(new int[]{5, 7, 7, 8, 8, 10});
        param1List.add(new int[]{5, 7, 7, 8, 8, 10});
        param1List.add(new int[]{});

        // 参数2
        param2List.add(8);
        param2List.add(6);
        param2List.add(0);

        // other param


        // 校验测试用例集合
        if (param1List.size() != param2List.size()) {
            throw new RuntimeException("测试用例集合不匹配，请确认测试用例集合");
        }
    }

    public static void testSolution1(List<int[]> param1List, List<Integer> param2List) {

        Solution1 solution = new Solution1();

        for (int i = 0; i < param1List.size(); i++) {
            // Arrays.stream(solution.searchRange(nums, 8)).forEach(System.out::println);
            int[] res = solution.searchRange(param1List.get(i), param2List.get(i));
            PrintUtil.print(res);
        }

    }


    public static void testSolution2(List<int[]> param1List, List<Integer> param2List) {

        Solution2Error solution = new Solution2Error();

        for (int i = 0; i < param1List.size(); i++) {
            int[] res = solution.searchRange(param1List.get(i), param2List.get(i));
            PrintUtil.print(res);
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

