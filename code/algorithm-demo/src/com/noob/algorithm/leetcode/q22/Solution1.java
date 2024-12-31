package com.noob.algorithm.leetcode.q22;

import java.util.ArrayList;
import java.util.List;

/**
 * 22.括号生成
 * 思路：暴力法
 */
public class Solution1 {

    // 定义全局结果集合
    private List<String> res = new ArrayList<String>();

    // 核心：通过递归生成所有的括号序列，随后依次调用自定义方法来校验序列的有效性

    public List<String> generateParenthesis(int n) {
        generate(new StringBuilder(),n);
        return res;
    }

    public void generate(StringBuilder cur,int max) {
        // cur:当前生成的括号字符序列，max最大括号对数

        // 校验字符串长度
        if(cur.length() == 2*max) {
            // 校验括号字符序列的有效性，有效则加入结果集
            if(isValid(cur.toString())){
                res.add(cur.toString());
            }
        }else{
            // 加入左括号或者右括号,然后深度遍历到底部校验序列
            cur.append("("); // 加入左括号
            generate(cur,max);
            cur.deleteCharAt(cur.length()-1); // 复原

            cur.append(")"); // 加入右括号
            generate(cur,max);
            cur.deleteCharAt(cur.length()-1); // 复原
        }
    }

    /**
     * 自定义方法校验括号字符序列的有效性
     * @param str
     * @return
     */
    private boolean isValid(String str) {
        int balance = 0; // 定义平衡参数校验括号字符序列的有效性
        for(char c : str.toCharArray()){
            if(c=='('){
                balance++;
            }else if(c==')'){
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

}
