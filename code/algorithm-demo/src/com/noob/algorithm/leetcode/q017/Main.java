package com.noob.algorithm.leetcode.q017;

public class Main {


    public static void main(String[] args) {
        String digits = "23";


        Solution1 solution1 = new Solution1();
        System.out.println(solution1.letterCombinations(digits));

        System.out.println("-----------------------------------------------");

        Solution2 solution2 = new Solution2();
        System.out.println(solution2.letterCombinations(digits));

    }

}
