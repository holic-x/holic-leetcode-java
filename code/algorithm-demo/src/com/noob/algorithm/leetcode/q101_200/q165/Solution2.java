package com.noob.algorithm.leetcode.q101_200.q165;

/**
 * 🟡 165 比较版本号 - https://leetcode.cn/problems/compare-version-numbers/description/
 */
public class Solution2 {

    /**
     * 思路分析：根据`.`拆分版本信息，依次进行比较
     */
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        // 在for循环中处理，两两比较，如果超出数组范围则置为0即可
        for (int i = 0; i < v1.length || i < v2.length; i++) {
            int val1 = (i < v1.length ? Integer.valueOf(v1[i]) : 0);
            int val2 = (i < v2.length ? Integer.valueOf(v2[i]) : 0);
            if (val1 == val2) {
                continue;
            } else if (val1 < val2) {
                return -1;
            } else if (val1 > val2) {
                return 1;
            }
        }
        // 校验均相等
        return 0;
    }

}
