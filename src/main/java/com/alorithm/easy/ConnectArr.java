package com.alorithm.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 王贤
 */
public class ConnectArr {
    public static void main(String[] args) {
        int[] arr = {91, 4,64,78};
        int[][] pieces = {{78}, {4,64},{91}};
        System.out.println(canFormArray(arr,pieces));
    }

    /**
     * 给你一个整数数组 arr ，数组中的每个整数 互不相同 。另有一个由整数数组构成的数组 pieces，其中的整数也 互不相同 。请你以 任意顺序 连接 pieces
     * 中的数组以形成 arr 。但是，不允许 对每个数组 pieces[i] 中的整数重新排序。
     * 如果可以连接 pieces 中的数组形成 arr ，返回 true ；否则，返回 false 。
     * <p>
     * 示例 1：
     * 输入：arr = [15,88], pieces = [[88],[15]]
     * 输出：true
     * 解释：依次连接 [15] 和 [88]
     * <p>
     * 示例 2：
     * 输入：arr = [49,18,16], pieces = [[16,18,49]]
     * 输出：false
     * 解释：即便数字相符，也不能重新排列 pieces[0]
     **/
    public static boolean canFormArray(int[] arr, int[][] pieces) {
        int m = arr.length, n = pieces.length;
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < n; i++) {
            index.put(pieces[i][0], i);
        }
        for (int i = 0; i < m;) {
            if (!index.containsKey(arr[i])) {
                return false;
            }
            int j = index.get(arr[i]);
            int len = pieces[j].length;

            for (int k = 0; k < len; k++) {
                if (arr[i + k] != pieces[j][k]) {
                    return false;
                }
            }
            i += len;
        }
        return true;
    }
}
