package com.noob.algorithm.leetcode.q128;

import java.util.*;

/**
 * 🟡 128.最长连续序列 - https://leetcode.cn/problems/longest-consecutive-sequence/description/
 */
public class Solution1 {
    public int longestConsecutive(int[] nums) {
        // 判断nums是否为空
        if(nums==null || nums.length==0){
            return 0;
        }
        // 定义一个新集合，对nums进行去重、排序
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if(!list.contains(num)){
                list.add(num);
            }
        }
        // 遍历新集合，依次校验当前元素和其下一个元素是否连续，如果连续则跳出当次循环继续下一个校验，如果断掉则当前元素位置即为最大连续序列
        int current = 1;
        int maxLength = 1;
        for (int i=0;i<list.size()-1;i++) {
            if( list.get(i+1) - list.get(i) == 1){
                current ++;
                maxLength = current;
                // 跳出当次循环
                continue;
            }else{
                return maxLength;
            }
        }
        return maxLength;
    }

}
