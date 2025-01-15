package com.noob.algorithm.skill.sort;

import com.noob.algorithm.base.util.PrintListUtil;
import com.noob.algorithm.base.util.PrintUtil;
import com.sun.xml.internal.bind.v2.model.annotation.Quick;

import java.util.ArrayList;
import java.util.List;

public class MainForSort {


    static List<int[]> caseList = new ArrayList<>();

    // 初始化测试用例
    public static List<int[]> initCase() {
        // 初始化测试用例集合
        caseList = new ArrayList<>();

        // todo 补充测试用例集合
        caseList.add(new int[]{7, 3, 2, 6, 0, 1, 5, 4});

        return caseList;
    }

    // 冒泡排序
    public static void testBubbleSort() {
        // 参数初始化
        initCase();

        for (int[] nums : caseList) {
            // ① 调用算法
            BubbleSort solution = new BubbleSort();
            int[] res = solution.bubbleSort(nums);

            // ② 打印数据
            PrintUtil.print(res);

            // 分隔符
            System.out.println("********************");

        }

    }

    // 选择排序
    public static void testSelectionSort() {
        // 参数初始化
        initCase();

        for (int[] nums : caseList) {
            // ① 调用算法
            SelectionSort solution = new SelectionSort();
            int[] res = solution.selectionSort(nums);

            // ② 打印数据
            PrintUtil.print(res);

            // 分隔符
            System.out.println("********************");

        }

    }

    // 插入排序
    public static void testInsertionSort() {
        // 参数初始化
        initCase();

        for (int[] nums : caseList) {
            // ① 调用算法
            InsertionSort solution = new InsertionSort();
            int[] res = solution.insertionSortBase(nums);

            // ② 打印数据
            PrintUtil.print(res);

            // 分隔符
            System.out.println("********************");

        }
    }


    // 快速排序
    public static void testQuickSort() {
        // 参数初始化
        initCase();

        for (int[] nums : caseList) {
            // ① 调用算法
            QuickSort solution = new QuickSort();
            solution.quickSort(nums, 0, nums.length - 1);

            // ② 打印数据
            PrintUtil.print(nums);

            // 分隔符
            System.out.println("********************");

        }
    }


    // 归并排序
    public static void testMergeSort1() {
        // 参数初始化
        initCase();

        for (int[] nums : caseList) {
            // ① 调用算法
            MergeSort1 solution = new MergeSort1();
            solution.mergeSort(nums, 0, nums.length - 1);

            // ② 打印数据
            PrintUtil.print(nums);

            // 分隔符
            System.out.println("********************");

        }

    }


    // 归并排序
    public static void testMergeSort2() {
        // 参数初始化
        initCase();

        for (int[] nums : caseList) {
            // ① 调用算法
            MergeSort2 solution = new MergeSort2();
            int[] res = solution.mergeSort(nums);

            // ② 打印数据
            PrintUtil.print(res);

            // 分隔符
            System.out.println("********************");

        }
    }


    public static void main(String[] args) {

        System.out.println("---------- 排序算法调用测试 ----------");

        testBubbleSort(); // 冒泡排序
        testSelectionSort(); // 选择排序
        testInsertionSort(); // 插入排序
        testQuickSort(); // 快速排序
        testMergeSort1(); // 归并排序（解法1）
        testMergeSort2(); // 归并排序（解法2）

        System.out.println("---------- 排序调用测试 ----------");

    }
}
