package com.noob.algorithm.leetcode.q056;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 56.合并区间
 * 核心：先按照左区间排序，然后循环遍历进行合并确认
 */
public class Solution1 {

    public int[][] merge(int[][] intervals) {

        // 定义结果集
        List<int[]> list = new ArrayList<int[]>();

        // 根据每个子数组的首元素对数组进行排序(可以用Lambda表达式简化)
        /*
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
         */
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        // 定义区间的左右指针，从第一个数组开始（left左区间、right右区间）
        int left = intervals[0][0];
        int right = intervals[0][1];
        // 循环遍历排序后的数组元素，将右区间和对应区间的左右(nl\nr)进行对比
        for(int i=1;i<intervals.length;i++){
            // 如果right>nl 说明区间重叠，需要更新区间
            if(right>=intervals[i][0]){
                if(right>=intervals[i][1]){
                    // right > nr,说明是[1,10] [2,3]这种情况，不需要更新区间
                }else{
                    // right < nr,说明时[1,10] [2,12]这种情况，需要更新右区间
                    right=intervals[i][1];
                }
            }else{
                // 如果right<nl 说明区间无重叠，需要将区间结果集，并更新当前指针索引
                list.add(new int[]{left,right});
                left=intervals[i][0];
                right=intervals[i][1];
            }
        }
        // 将当前指针索引区间加入结果集
        list.add(new int[]{left,right});

        // 返回结果集
        return list.toArray(new int[list.size()][]);
    }
}
