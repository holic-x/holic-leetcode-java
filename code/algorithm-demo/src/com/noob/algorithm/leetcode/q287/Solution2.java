package com.noob.algorithm.leetcode.q287;

/**
 * 287.寻找重复数
 * 思路：参考链表的快慢指针思路(环形链表)
 * point = num[point] 等价于 point = point.next
 */
public class Solution2 {


    public int testNums(int[] nums) {

        // point 指针理解
        int point = 0;
        while(true){
            System.out.println(nums[point]);
            point = nums[point]; // 等价于point = point.next
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,2};
        Solution2 solution = new Solution2();
        System.out.println(solution.testNums(nums));
    }


    public int findDuplicate(int[] nums) {

        // 定义快、慢指针
        int slow = 0,fast = 0;
        // 已知会存在环，slow和fast会在重复序列中相遇（因此当两者不相等的时候就继续走，直到相遇）
        while (true) {
            slow = nums[slow]; // 对应slow = slow.next （慢指针先走一步）
            fast = nums[nums[fast]]; // 对应fast = fast.next.next (快指针先走两步)
            if (slow == fast) {
                break;
            }
        }

        // 定义finder指针和slow一起走，他们必定会在入口处相遇
        int finder=0;
        while(true){
            finder = nums[finder];
            slow = nums[slow];
            if(finder==slow){
                return finder;
            }
        }
    }

    public int findDuplicate1(int[] nums) {

        // 定义快、慢指针
        int slow = 0,fast = 0;
        slow = nums[slow]; // 对应slow = slow.next （慢指针先走一步）
        fast = nums[nums[fast]];// 对应fast = fast.next.next (快指针先走两步)

        // 已知会存在环，slow和fast会在重复序列中相遇（因此当两者不相等的时候就继续走，直到相遇）
        while (fast != slow) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        // 定义finder指针和slow一起走，他们必定会在入口处相遇
        int finder=0;
        while(finder!=slow){
            finder = nums[finder];
            slow = nums[slow];
        }
        return slow; // finder
    }


}
