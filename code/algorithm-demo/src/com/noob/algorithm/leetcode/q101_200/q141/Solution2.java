package com.noob.algorithm.leetcode.q101_200.q141;


import com.noob.algorithm.base.dataStructure.linkedList.ListNode;

/**
 * 🟢 141-环形链表 - https://leetcode.cn/problems/linked-list-cycle/
 */
public class Solution2 {

    /**
     * 思路：快慢指针
     */
    public boolean hasCycle(ListNode head) {

        // 定义快慢指针，如果遍历过程中指针相遇则说明存在环
        ListNode slow = head,fast = head;

        // 如果快指针先到达终点（尾节点）则循环结束
        while(fast!=null && fast.next!=null){
            // 移动指针
            slow = slow.next;
            fast = fast.next.next;
            // 判断指针是否相遇,相遇则说明存在环
            if(slow==fast){
                return true;
            }
        }
        return false;
    }

}
