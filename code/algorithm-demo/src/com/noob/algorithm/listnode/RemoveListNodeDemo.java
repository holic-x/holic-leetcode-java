package com.noob.algorithm.listnode;

/**
 * 移除链表
 */
public class RemoveListNodeDemo {


    /**
     * 基于原链表直接进行操作
     * @param head
     * @param val
     * @return
     */
    public ListNode removeListNode1(ListNode head, int val) {

        // 头节点判断（此处用while是考虑到可能每次移除的都是头节点）
        while(head!=null && head.val==val) {
            head = head.next; // 移除头节点
        }

        // 定义链表指针
        ListNode cur = head;

        // 判断当前节点的下一个节点是否为待删除元素
        while (cur != null && cur.next != null) {
            // 判断当前节点是否为要删除的节点
            if (cur.next.val == val) {
                // 执行删除操作
                cur.next = cur.next.next;
            }
            // 节点后移
            cur = cur.next;
        }

        // 返回链表
        return head;
    }


    /**
     * 增设虚拟头节点操作
     * @param head
     * @param val
     * @return
     */
    public ListNode removeListNode2(ListNode head, int val) {

        // 增设虚拟头节点
        ListNode dummy = new ListNode(0,head);

        // 定义链表指针
        ListNode cur = dummy;

        // 从虚拟头结点开始遍历，判断当前节点的下一个节点元素是否为待删除元素，如果是则将当前节点的next指向下下个节点
        while (cur.next != null) {
            // 判断当前节点是否为要删除的节点
            if (cur.next.val == val) {
                // 执行删除操作
                cur.next = cur.next.next;
            }else{
                // 指针后移
                cur = cur.next;
            }
        }

        // 返回链表
        return dummy.next;
    }



    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        RemoveListNodeDemo demo = new RemoveListNodeDemo();
        // 直接在原链表进行操作
        /*
        demo.removeListNode1(head, 2);// 1
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
         */


        ListNode cur = demo.removeListNode1(head, 1);// 1
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }


    }
}
