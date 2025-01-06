package com.noob.algorithm.base.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 集合打印工具类
 */
public class PrintListUtil<T> {

    // 单个列表打印
    public void print(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print("[" + list.get(i) + "]" + "-");
        }
        System.out.println();
    }

    // 二维列表打印
    public void printMatrix(List<List<T>> list) {
        List<String> res = new ArrayList<>();
        if (list.isEmpty()) {
            System.out.println("[]");
        }
        for (int i = 0; i < list.size(); i++) {
            StringBuffer buffer = new StringBuffer().append("[");
            List<T> curList = list.get(i);
            for (int j = 0; j < curList.size(); j++) {
                buffer.append(curList.get(j));
                if (j != curList.size() - 1) {
                    buffer.append(",");
                }
            }
            buffer.append("]");
            res.add(buffer.toString());
        }
        System.out.println(String.join(" || ", res));
    }

}