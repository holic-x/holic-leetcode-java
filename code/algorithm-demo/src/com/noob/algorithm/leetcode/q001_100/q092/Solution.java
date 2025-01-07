package com.noob.algorithm.leetcode.q001_100.q092;

class Solution {
    /**
     * 分段处理：
     * 第1段：[0,left-1] 正常遍历
     * 第2段：[left,right] 反转
     * 第3段：[right+1,end] 拼接
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 定义虚拟头节点
        ListNode dummy = new ListNode(-1, head); // 将head拼接过来构成一个新链表，对这个新链表进行区间反转操作：等价于ListNode dummy = new ListNode(-1); dummy.next = head;
        ListNode pd = dummy; // pd指针指向新链表的头节点

        /**
         * 第1段：正常遍历(p、cur向前移动，到达要进行反转的左区间)
         * 遍历完成 pd 的下一个节点指向的是要翻转的节点（因为dummy多了个虚拟头结点）
         */
        for (int i = 0; i < left - 1; i++) {
            pd = pd.next;
        }

        /**
         * 第2段：反转这个范围区间的链表节点
         */
        ListNode pre = null; // 指向前一个节点
        ListNode cur = pd.next; // cur 指向当前要反转的节点（当前遍历的节点位置）
        for (int i = 0; i < right - left + 1; i++) {
            // 记录位置，翻转节点
            ListNode nxt = cur.next; // 记录当前要翻转的下一个节点内容（避免被覆盖）
            cur.next = pre; // 将cur.next指向前一个节点pre
            // 更新指针位置，等待下一轮反转（pre、cur往后移动）
            pre = cur;
            cur = nxt;
        }
        // 反转完成最终cur指向的就是反转区间的下一个节点（此处也就是指代第三段区间），而pre则是指向反转完成的这个区间

        // 拼接：找到第一段的拼接位置，将反转后的区间和第三段区间进行拼接（此处是先操作pd.next.next,再操作pd.next，避免影响覆盖）
        pd.next.next = cur;
        pd.next = pre;
        return dummy.next;
    }
}