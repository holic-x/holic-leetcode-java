package com.noob.algorithm.leetcode.q101_200.q165;

/**
 * 🟡 165 比较版本号 - https://leetcode.cn/problems/compare-version-numbers/description/
 */
public class Solution1 {

    /**
     * 思路分析：根据`.`拆分版本信息，依次进行比较
     */
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0, j = 0;
        while (i < v1.length && j < v2.length) {
            int val1 = Integer.valueOf(v1[i]);
            int val2 = Integer.valueOf(v2[j]);
            if (val1 == val2) {
                // 继续遍历校验下一位
                i++;
                j++;
            } else if (val1 < val2) {
                return -1;
            } else if (val1 > val2) {
                return 1;
            }
        }

        int compareFlag = 0;
        // 还存在尾巴没有校验
        if (i < v1.length) {
            for (int x = i; x < v1.length; x++) {
                int val = Integer.valueOf(v1[x]);
                if (val != 0) {
                    compareFlag = 1;
                    break;
                }
            }
        }

        if (j < v2.length) {
            for (int x = j; x < v2.length; x++) {
                int val = Integer.valueOf(v2[x]);
                if (val != 0) {
                    compareFlag = -1;
                    break;
                }
            }
        }

        return compareFlag;
    }

}
