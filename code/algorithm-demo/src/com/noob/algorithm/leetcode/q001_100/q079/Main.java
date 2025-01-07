package com.noob.algorithm.leetcode.q001_100.q079;


import com.noob.algorithm.base.util.PrintListUtil;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<char[][]> caseList = new ArrayList<>();
    static List<String> wordList = new ArrayList<>();

    // 初始化测试用例
    public static void initCase() {


        // todo 补充测试用例集合
        caseList.add(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}});
        wordList.add("ABCCED");

        caseList.add(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}});
        wordList.add("SEE");

        caseList.add(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}});
        wordList.add("ABCB");
    }

    public static void testSolution1(List<char[][]> caseList) {

        for (int i = 0; i < caseList.toArray().length; i++) {
            // ① 调用算法
            Solution1 solution = new Solution1();
            boolean res = solution.exist(caseList.get(i), wordList.get(i));

            // ② 打印数据
            System.out.println(res);
        }

    }


    public static void testSolution2(List<char[][]> caseList) {

    }


    public static void main(String[] args) {

        // 参数初始化
        initCase();

        System.out.println("---------- 算法①调用测试 ----------");

        testSolution1(caseList);

        System.out.println("---------- 算法②调用测试 ----------");

        testSolution2(caseList);

    }
}
