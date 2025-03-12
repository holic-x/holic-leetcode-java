package com.noob.algorithm.leetcode.LCR.q140;

import com.noob.algorithm.plan_archive.baseStructure.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 🟢 LCR 140 链表的倒数第K个节点 - https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/description/
 */
public class SolutionLCR140_02 {
    /**
     * 思路分析：借助集合辅助遍历
     */
    public ListNode trainingPlan(ListNode head, int cnt) {
        ListNode cur = head;
        // 遍历链表，借助集合辅助
        List<ListNode> list = new ArrayList<>();
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }

        // 获取倒数第K个节点
        return list.get(list.size() - cnt);
    }
}
