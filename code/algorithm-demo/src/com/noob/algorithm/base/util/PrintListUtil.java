package com.noob.algorithm.base.util;

import java.util.List;

/**
 * 集合打印工具类
 */
public class PrintListUtil<T> {

    public void print(List<T> list) {
        for(int i=0;i< list.size();i++){
            System.out.print("[" + list.get(i) + "]" + "-");
        }
        System.out.println();
    }

}