package com.noob.algorithm.leetcode.q02;

/**
 * 2-两数相加（超出内存限制）
 * 思路：将链表组成的数字相加，然后再放在一个新链表中，链表中每个节点存一个数字）
 */
public class Solution2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // 定义链表
        ListNode res = new ListNode(0);
        // 定义链表指针
        ListNode cur = res;

        // 分别遍历链表，组合数字
        StringBuffer sb1 = new StringBuffer();
        while(l1!=null){
            sb1.append(l1.val);
        }
        StringBuffer sb2 = new StringBuffer();
        while(l2!=null){
            sb2.append(l2.val);
        }
        // 计算数字之和
        int sum = Integer.valueOf(sb1.toString()) + Integer.valueOf(sb2.toString());

        // 将数字加入链表
        String sumStr = String.valueOf(sum);
        for(int i=0;i<sumStr.length();i++){
            cur.val += sumStr.charAt(i);
            cur = cur.next;
        }
        // 返回链表
        return res.next;
    }
}
