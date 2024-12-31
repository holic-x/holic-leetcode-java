package com.noob.algorithm.test01;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * LRU 缓存实现
 * 最近未被使用（优先淘汰）
 *
 * 方式1：队列
 * 定义一个容器存储元素，确定入队和出队的方向，确保出队的那一端是最近未被访问的元素
 * 例如定义一个队列，然后依次入队，如果元素被访问到则将元素取出重新插入（相当于更新它的排队顺序），始终淘汰队首（因为将经常被访问的元素放在队尾，因此队首就是要淘汰的目标）
 *
 * 方式2：通过记录元素的访问次数来实现，但需要额外的存储空间记录和排序校验，相对来说没有这么灵活
 */
public class LRUCache {

    // 基于LinkedHashMap实现键值对的LRU缓存
    private LinkedHashMap<String,String> cache ; // map 对应的就是缓存容器

    private int capacity = 10; // 设定初始化容量为10

    // 初始化
    public LRUCache(int capacity) {
        // 初始化容器，设定容量大小
        this.capacity = capacity;
        cache = new LinkedHashMap(capacity);
    }

    /**
     * 构建缓存的基本操作（CRUD概念），此处设计主要是增加、删除存储
     * @param key
     * @return
     */
    // 访问元素
    public String get(String key) {
        // 访问元素：需要检索指定key的元素，然后更新它的排队顺序（先出去后进来）
        String val = cache.get(key);
        cache.remove(key); // 先出去
        cache.put(key, val); // 后进来 更新排队顺序
        return val;
    }

    // 新增元素
    public void put(String key, String value) {
        // 判断元素是否存在，如果存在则更新，不存在则需新增（新增的过程中需注意LRU判断）
        String val = cache.get(key);
        if(val!=null){
            // 元素存在 执行更新操作(更新操作本质上也是先移除后新增，更新它的排队序列)
            cache.remove(key);
            cache.put(key, value); // 此处更新的是新的value值
        }else{
            // 如果元素不存在则直接新增(新增时需判断是否超出容量，超出容量需要先删除队首元素腾挪位置)
            if(cache.size()+1>capacity){ // 超出容量
                // 删除队首元素
                // Map.Entry<String,String> firstEntry = cache.entrySet().iterator().next();
                // cache.remove(firstEntry.getKey());
                String firstKey = cache.keySet().iterator().next();
                cache.remove(firstKey);
            }
            cache.put(key, value); // 此处是新增操作
        }
    }

    // 构建打印缓存方法
    public void print(){
        System.out.println("......start......");
        Set<String> keys = cache.keySet();
        for (String key : keys) {
            System.out.println(key + ":" + cache.get(key));
        }
        System.out.println("......end......");
    }

    public static void main(String[] args) {
        // 构建测试
        int capacity = 3;
        LRUCache cache = new LRUCache(capacity);
        cache.put("001","hello");
        cache.put("002","world");
        cache.put("003","bibibi");
        cache.print();
        cache.get("001");
        cache.put("004","xixixi");
        cache.print();
    }

}
