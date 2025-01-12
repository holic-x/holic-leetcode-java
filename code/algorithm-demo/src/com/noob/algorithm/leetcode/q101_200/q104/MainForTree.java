package com.noob.algorithm.leetcode.q101_200.q104;


import com.noob.algorithm.base.dataStructure.tree.TreeNode;
import com.noob.algorithm.base.util.BinaryTreeUtil;

import java.util.ArrayList;
import java.util.List;

public class MainForTree {

    // 初始化测试用例
    public static List<Integer[]> initCase() {
        List<Integer[]> caseList = new ArrayList<>();

        // todo 补充测试用例集合
        caseList.add(new Integer[]{3,9,20,null,null,15,7});
        caseList.add(new Integer[]{1,null,2});
        caseList.add(new Integer[]{});
        caseList.add(new Integer[]{null});

        return caseList;
    }

    public static void testSolution1(List<Integer[]> caseList) {

        for (Integer[] nums : caseList) {
            // 将元素转化为树
            TreeNode root = BinaryTreeUtil.createBinaryTreeByDfs(nums);

            // ① 调用算法
            Solution1 solution = new Solution1();
            int res = solution.maxDepth(root);

            // ② 打印数据
            System.out.println(res);

            System.out.println("********************");
        }

    }


    public static void testSolution2(List<Integer[]> caseList) {

        for (Integer[] nums : caseList) {
            // 将元素转化为树
            TreeNode root = BinaryTreeUtil.createBinaryTreeByDfs(nums);

            // ① 调用算法
            Solution2 solution = new Solution2();
            int res = solution.maxDepth(root);

            // ② 打印数据
            System.out.println(res);

            System.out.println("********************");
        }

    }


    public static void main(String[] args) {

        // 参数初始化
        List<Integer[]> caseList = initCase();

        System.out.println("---------- 算法①调用测试 ----------");

        testSolution1(caseList);

        System.out.println("---------- 算法②调用测试 ----------");

        testSolution2(caseList);

    }
}
