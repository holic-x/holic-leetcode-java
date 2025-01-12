package com.noob.algorithm.leetcode.q301_400.q347;

import java.util.*;

/**
 * 🟡 347.前K个高频元素 - https://leetcode.cn/problems/top-k-frequent-elements/
 */
public class Solution1 {

    // 思路：计算元素出现频次、排序（前K高频概念采用小顶堆：自定义排序规则、遍历小顶堆）
    public int[] topKFrequent(int[] nums, int k) {

        // 借助哈希表存储元素出现频次（<元素值，对应出现频次>）
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // 1.统计频次
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                // 元素存在则更新出现频次
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                // 元素不存在则初始化
                map.put(nums[i], 1);
            }
        }

        // 2.构建小顶堆存储（自定义排序规则:小顶堆元素存储的是不同的元素值，其排序规则需自定义根据map获取key相应的频次进行比较）
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });

        // 遍历Map集合，构建k个元素的小顶堆
        Set<Integer> set = map.keySet();
        Iterator<Integer> iterator = set.iterator();
        for (int i = 0; i < k; i++) {
            queue.add(iterator.next());
        }
        // 对于剩余的元素，则依次和小顶堆的堆顶元素（前K最小值）进行比较
        while (iterator.hasNext()) {
            int cur = iterator.next();
            // 如果cur对应的频次大于堆顶元素则进行替换(注意此处比较的是频次，而堆中存储的是元素)
            if (map.get(cur) > map.get(queue.peek())) {
                queue.remove(); // 堆顶元素弹出
                queue.offer(cur); // 插入当前较大的元素
            }// else 情况不考虑（不满足跻身前K的条件则不做任何操作）
        }

        // 3.遍历生成的小顶堆，返回结果集
        int[] res = new int[k];
        int idx = 0;
        while (queue.size() > 0) {
            res[idx++] = queue.poll();
        }
        return res;
    }

}
