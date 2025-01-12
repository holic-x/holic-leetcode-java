package com.noob.algorithm.leetcode.q301_400.q347;

import java.util.*;

/**
 * 🟡 347.前K个高频元素 - https://leetcode.cn/problems/top-k-frequent-elements/
 */
public class Solution2 {

    // 思路：计算元素出现频次、排序（前K高频概念采用大顶堆，自定义排序规则，所有数据入库，循环遍历取前K个栈顶元素）
    public int[] topKFrequent(int[] nums, int k) {

        // 借助哈希表存储元素出现频次（<元素值，对应出现频次>）
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        // 1.统计频次
        for (int i = 0; i < nums.length; i++) {
            // 元素存在则更新出现频次，元素不存在则初始化次数为1
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1); // 如果key不存在则返回value为0（消除if...else...）
        }

        // 2.构建大顶堆存储（自定义排序规则:小顶堆元素存储的是不同的元素值，其排序规则需自定义根据map获取key相应的频次进行比较）
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2) - map.get(o1);
            }
        });

        // 遍历Map集合，构建大顶堆（依次将集合元素入堆）
        Set<Integer> set = map.keySet();
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            queue.add(iterator.next());
        }

        // 3.遍历大顶堆，直接获取前K个元素
        int[] res = new int[k];
        for(int i=0;i<k;i++) {
            res[i] = queue.poll();
        }
        return res;
    }

}
