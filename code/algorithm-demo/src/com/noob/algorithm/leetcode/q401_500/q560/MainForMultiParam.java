package com.noob.algorithm.leetcode.q401_500.q560;


import java.util.ArrayList;
import java.util.List;

public class MainForMultiParam {

    // 参数集合列表（case列表下标一一对照）
    static List<int[]> param1List = new ArrayList<>();
    static List<Integer> param2List = new ArrayList<>();


    // 初始化测试用例
    public static void initCase() {
        // 初始化测试用例集合
        param1List = new ArrayList<>();
        param2List = new ArrayList<>();

        // todo 补充测试用例集合

        // 参数1
        param1List.add(new int[]{1, 1, 1});
        param1List.add(new int[]{1, 2, 3});

        // 参数2
        param2List.add(2);
        param2List.add(3);

        // other param


        // 校验测试用例集合
        if (param1List.size() != param2List.size()) {
            throw new RuntimeException("测试用例集合不匹配，请确认测试用例集合");
        }
    }

    public static void testSolution1() {
        // 初始化用例
        initCase();

        for (int i = 0; i < param1List.size(); i++) {
            // ① 调用算法
            Solution1 solution = new Solution1();
            int res = solution.subarraySum(param1List.get(i), param2List.get(i));

            // ② 输出结果
            System.out.println(res);

            // 分隔符
            System.out.println("********************");

        }

    }


    public static void testSolution2() {

    }


    public static void main(String[] args) {

        // ---------- 测试算法 ----------
        System.out.println("---------- 算法①调用测试 ----------");

        testSolution1();

        System.out.println("---------- 算法②调用测试 ----------");

        testSolution2();

    }
}
