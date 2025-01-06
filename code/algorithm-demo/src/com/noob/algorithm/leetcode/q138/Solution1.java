package com.noob.algorithm.leetcode.q138;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 🟡 138.随机链表的复制 - https://leetcode.cn/problems/copy-list-with-random-pointer/description/
 */
public class Solution1 {

    public Node copyRandomList(Node head) {

        // 构建新链表
        Node res = new Node(0);

        // 定义链表指针
        Node cur = head;

        // 构建一个哈希表结构存储当前节点和对应Random节点的对应关系
        Map<Node, Node> map = new HashMap<Node, Node>();

        // 步骤①：遍历链表，用于对应创建节点（无next、random）
        // 定义哈希表
        while (cur != null) {
            Node newNode = new Node(cur.val); // 创建新节点
            map.put(cur, newNode); // 构建当前节点和新节点的映射（用于后续构建节点关系）
            cur = cur.next; // 指针后移
        }

        // 步骤②：构建链表节点之间的联系（设置next、random）
        cur = head; // 重新初始化链表指针
        while (cur != null) {
            // 根据key获取到对应的新链表节点
            Node newNode = map.get(cur);

            // 寻找这个新链表节点的next和random值

            // 设置next指针（新节点对应的next指针即为cur.next在map中的映射值）
            newNode.next = map.get(cur.next);
            // 设置random指针（新节点对应的random指针即为cur.random在map中的映射值）
            newNode.random = map.get(cur.random);

            // 指针后移
            cur = cur.next;
        }

        // 返回结果
        return map.get(head);
    }

}


/**
 * 链表节点定义
 */
class Node {
    int val;
    Node next;
    Node random;

    Node() {
    }

    Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

}