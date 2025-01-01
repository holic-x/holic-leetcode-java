package com.noob.algorithm.leetcode.q03;

public class Main {

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        String s2 = "bbbbbb";
        String s3 = "pwwkew";
        String s4 = "  ";
        String s5 = "";
        String s6 = " ";

        Solution1 solution1 = new Solution1();
        System.out.println(solution1.lengthOfLongestSubstring(s1));
        System.out.println(solution1.lengthOfLongestSubstring(s2));
        System.out.println(solution1.lengthOfLongestSubstring(s3));
        System.out.println(solution1.lengthOfLongestSubstring(s4));
        System.out.println(solution1.lengthOfLongestSubstring(s5));
        System.out.println(solution1.lengthOfLongestSubstring(s6));

        System.out.println("---------------------------------------------------");
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.lengthOfLongestSubstring(s1));
        System.out.println(solution2.lengthOfLongestSubstring(s2));
        System.out.println(solution2.lengthOfLongestSubstring(s3));
        System.out.println(solution2.lengthOfLongestSubstring(s4));
        System.out.println(solution2.lengthOfLongestSubstring(s5));
        System.out.println(solution2.lengthOfLongestSubstring(s6));

    }

}
