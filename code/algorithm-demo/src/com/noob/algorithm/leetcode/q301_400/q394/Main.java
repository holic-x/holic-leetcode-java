package com.noob.algorithm.leetcode.q301_400.q394;



import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<String> caseList = new ArrayList<>();

    // 初始化测试用例
    public static List<String> initCase() {
        // 初始化测试用例集合
        caseList = new ArrayList<>();

        // todo 补充测试用例集合
        caseList.add("3[a]2[bc]");
        caseList.add("3[a2[c]]");
        caseList.add("2[abc]3[cd]ef");

        return caseList;
    }

    public static void testSolution1() {
        // 参数初始化
        initCase();

        for (String str : caseList) {
            // ① 调用算法
            Solution1 solution = new Solution1();
            String res = solution.decodeString(str);

            // ② 打印数据
            System.out.println(res);

            // 分隔符
            System.out.println("********************");

        }

    }


    public static void testSolution2() {
        // 参数初始化
        initCase();

        for (String str : caseList) {
            // ① 调用算法
            Solution2 solution = new Solution2();
            String res = solution.decodeString(str);

            // ② 打印数据
            System.out.println(res);

            // 分隔符
            System.out.println("********************");

        }

    }


    public static void main(String[] args) {

        System.out.println("---------- 算法①调用测试 ----------");

        testSolution1();

        System.out.println("---------- 算法②调用测试 ----------");

        testSolution2();

    }
}
