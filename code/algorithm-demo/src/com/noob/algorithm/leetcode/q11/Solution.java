package com.noob.algorithm.leetcode.q11;

/**
 * 11.盛最多水的容器（双指针）
 */
public class Solution {

    public int maxArea(int[] height) {
        // 双指针：定义左侧指针、右侧指针、盛水面积
        int i = 0, j = height.length - 1, res = 0;
        // 当两个指针相遇则停止，在比较过程中计算面积大小（宽度一定的情况下，面积大小取决于短板高度）
        while(i < j) {
            // 比较当前指针对应的柱高度，移动短板一侧，获取较大的res
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]):
                    Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(s.maxArea(height));
    }

}
