package com.noob.algorithm.leetcode.q49;

import java.util.*;

/**
 * 49.字母异位词分组统计
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 定义结果集（存储排序后的字母异位词，和对应的分组）
        Map<String,List<String>> map = new HashMap<>();

        for(String str : strs){
            // 将字符串转化为字符数据后排序
            char[] strArr = str.toCharArray();
            // 使用工具类进行数组内部元素排序
            Arrays.sort(strArr);
            String sortedStr = new String(strArr);
            // 获取当前key对应的list列表
            List<String> list = map.getOrDefault(sortedStr,new ArrayList<String>());// 此处直接获取指定key对应的list，不存在就创建一个新的
            // 将当前字符串加入到对应列表中
            list.add(str);
            // 更新map
            map.put(sortedStr,list);
        }
        // 将map的value值列表转化为ArrayList集合
        return new ArrayList<List<String>>(map.values());
    }
}
