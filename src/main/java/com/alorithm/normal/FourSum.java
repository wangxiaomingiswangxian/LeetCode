package com.alorithm.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 王贤
 */
public class FourSum {

    public static void main(String[] args) {
        final FourSum fourSum = new FourSum();
        int[] nums = {1, 0, -1, 0, -2, 2};
        int[] nums2 = {1000000000, 1000000000, 1000000000, 1000000000};
        System.out.println(fourSum.fourSum(nums, 0));
        System.out.println(fourSum.fourSum(nums2, -294967296));
    }

    /**
     *
     * 给你一个由 n 个整数组成的数组nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组[nums[a], nums[b], nums[c], nums[d]]（若两个四元组元素一一对应，则认为两个四元组重复）：
     *
     * 0 <= a, b, c, d< n
     * a、b、c 和 d 互不相同
     * nums[a] + nums[b] + nums[c] + nums[d] == target
     * 你可以按 任意顺序 返回答案 。
     *
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：<a href="https://leetcode.cn/problems/4sum">力扣</a>
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int first = 0; first < n; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            for (int second = first + 1; second < n - 2; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                int forth = n - 1;

                for (int third = second + 1; third < n - 1; third++) {
                    if (third > second + 1 && nums[third] == nums[third - 1]) {
                        continue;
                    }

                    while (third < forth && (long)nums[first] + nums[second] + nums[third] + nums[forth] > target) {
                        forth--;
                    }
                    if (third == forth) {
                        break;
                    }
                    if (nums[first] + nums[second] + nums[third] + nums[forth] == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[first]);
                        list.add(nums[second]);
                        list.add(nums[third]);
                        list.add(nums[forth]);
                        res.add(list);
                    }
                }
            }
        }

        return res;
    }
}
