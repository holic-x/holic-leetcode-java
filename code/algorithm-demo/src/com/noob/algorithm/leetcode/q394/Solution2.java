package com.noob.algorithm.leetcode.q394;

import java.util.*;

/**
 * 394.字符串解码
 */
public class Solution2 {

    public String decodeString(String s) {
        /**
         * - 如果是数字，则构造Map对应的key，记录num
         * - 如果是`[`，则创建键值对`(num,"")`
         * - 如果是字符，则追加字符到当前栈顶元素的value子串中
         * - 如果是`]`，弹出栈顶元素构造重复字符串，然后追加到当前栈顶元素的子串中
         */
        // 定义辅助结构，栈中存储的是键值对信息(此处用StringBuffer[]便于处理，也可以用Map<StringBuffer, StringBuffer>来替代)
        Stack<StringBuffer[]> stack = new Stack<>();
        // 初始化栈顶元素
        stack.push(new StringBuffer[]{new StringBuffer("1"),new StringBuffer("")});
        // 定义临时存储
        StringBuffer nums = new StringBuffer("");
        // 循环遍历字符串系列进行处理
        for(char c : s.toCharArray()) {
            if(Character.isDigit(c)){
                // 如果是数字则构建key
                nums.append(c);
            }else if(Character.isLetter(c)){
                // 追加到栈顶元素(追加字符到栈顶元素的value)
                stack.peek()[1].append(c); // StringBuffer[] curStackTop = stack.peek(); curStackTop[1].append(c);
            }else if(c == '['){
                // 构建键值对并入栈,定义键值对（每个栈元素对应一个(nums,repeatStr),初始化为(nums,"")）
                StringBuffer[] item = new StringBuffer[]{new StringBuffer("".equals(nums.toString())?"1":nums.toString()), new StringBuffer("")};
                stack.push(item);
                // 入栈成功重置临时存储
                nums = new StringBuffer("");
            }else if(c == ']'){
                // 弹出栈顶元素得到一个重复序列，然后将其追加到当前新的栈顶元素中
                StringBuffer[] item = stack.pop();
                // 根据栈元素生成重复序列
                String newStr = genStr(Integer.valueOf(item[0].toString()), item[1].toString());
                // 追加序列到栈顶元素
                stack.peek()[1].append(newStr);
            }
        }
        // 遍历结束，最终得到的栈顶元素就是最终序列
        return stack.peek()[1].toString();
    }


    /**
     * 根据nums，repeatStr生成重复序列
     */
    public String genStr(int nums,String str){
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < nums; i++) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
//        String s = "3[a2[c]]";
        Solution2 solution = new Solution2();
        System.out.println(solution.decodeString(s));
    }

}
