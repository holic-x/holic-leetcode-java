package com.noob.algorithm.leetcode.q136;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 136.只出现一次的数字
 * 暴力思路：
 * 计数法：遍历数组，统计数组元素出现次数，然后遍历统计数据获取到出现此处为1的元素
 * 标记法：遍历数组，如果发现数据在集合中存在（说明存在重复），则从集合中移除这个数据，如果数据不存在则新加入集合，最终集合中留下来的就是只出现一次的元素
 */
class Solution {

    // 思路1：计数法
    public int singleNumber1(int[] nums) {
        // 通过哈希表存储元素的出现次数
        HashMap<Integer,Integer> map = new HashMap();

        // 1.统计元素出现次数
        for (int num : nums) {
            // 判断数据是否存在
            if(map.containsKey(num)) {
                map.put(num,map.get(num)+1);
            }else{
                map.put(num,1);
            }
        }

        // 2.遍历统计数据
        Iterator<Integer> iterator = map.keySet().iterator();
        while(iterator.hasNext()) {
            int key = iterator.next();
            if(map.get(key)==1) {
                return key;
            }
        }
        return 0;
    }

    // 思路2：标记法(去重法)
    public int singleNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            // 判断当前数据是否存在在集合中
            if(set.contains(num)){
                // 从集合中移除重复的元素
                set.remove(num);
            }else{
                // 如果数据不存在，将当前节点加入集合
                set.add(num);
            }
        }
        // 最终集合中剩下的元素就是不重复的那个
        return set.iterator().next();
    }

    // 思路3：异或操作（0的特殊性）
    public int singleNumber3(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}