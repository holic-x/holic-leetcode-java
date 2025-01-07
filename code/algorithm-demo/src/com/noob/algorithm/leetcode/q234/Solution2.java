package com.noob.algorithm.leetcode.q234;

import com.noob.algorithm.base.dataStructure.linkedList.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 🟢 234.回文链表 - https://leetcode.cn/problems/palindrome-linked-list/description/
 */
public class Solution2 {

    /**
     * 思路：转化为集合元素存储（双指针校验）
     */
    public boolean isPalindrome(ListNode head) {

        // 指定stack存储类型
        List<Integer> list = new ArrayList<>();

        // 记录链表节点指针
        ListNode cur = head;

        // 依次加入集合
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }

        // 双指针校验回文
        for (int left = 0, right = list.size() - 1; left < right; left++, right--) {
            if (list.get(left) != list.get(right)) {
                return false;
            }
        }

        // 校验通过，返回true
        return true;
    }

}
