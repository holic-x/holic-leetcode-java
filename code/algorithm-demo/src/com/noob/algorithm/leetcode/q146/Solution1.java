package com.noob.algorithm.leetcode.q146;

import java.util.*;

/**
 * 146-LRU缓存
 * 基于LinkedHashMap实现:存储key、value
 */
class LRUCache {

    // 定义缓存容量阈值
    int capacity ;

    // 定义数据结构（存储集合）
    LinkedHashMap <Integer, Integer> cache;

    // 构造函数
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<Integer, Integer>();
    }

    // 访问元素（判断元素是否存在，更新访问节点位置（重新插入：即先删后插））
    public int get(int key) {
        // 如果指定值存在
        if(cache.containsKey(key)) {
            // 记录当前值
            int value = cache.get(key);
            // 移除节点
            cache.remove(key);
            // 重新插入节点到链表尾部
            cache.put(key, value);
            return value;
        }else{
            return -1;
        }
    }

    // 插入元素（判断插入数据是否存在，存储则直接覆盖，如果不存在则继续判断是否超出阈值，超出阈值则需要触发LRU淘汰机制）
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            // key已存在则覆盖（先删后加）
            cache.remove(key);
            cache.put(key, value);
        }else{
            // 校验阈值
            if(cache.size()>=capacity){
                // 超出阈值触发清理(因为LinkedHashMap是有序的，所以此处通过迭代器获取到第一个元素，然后直接移除)
                Iterator<Integer> iterator = cache.keySet().iterator();
                cache.remove(iterator.next());
            }
            // 最终将新的数据节点插入
            cache.put(key, value);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


public class Solution1{

}