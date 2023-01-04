package com.alorithm.normal;

import java.util.Arrays;

/**
 * @author 王贤
 */
public class ThreeSumClosest {

    public static void main(String[] args) {
        final ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        int[] nums = {-1,2,1,-4};
        int target = 1;
        System.out.println(threeSumClosest.threeSumClosest(nums, target));
    }


    /**
     * 给你一个长度为 n 的整数数组nums和 一个目标值target。请你从 nums 中选出三个整数，使它们的和与target最接近。
     *
     * 返回这三个数的和。
     *
     * 假定每组输入只存在恰好一个解。
     * 来源：力扣（LeetCode）
     * 链接：<a href ="https://leetcode.cn/problems/3sum-closest">最接近的三数之和</a>
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int threeSumClosest(int[] nums, int target) {
        int res = 100000;
        int n = nums.length;
        Arrays.sort(nums);
        for (int first = 0; first < n; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int third = n - 1;
            int second = first + 1;

            while (second < third) {
                int sum = nums[first]+nums[second] + nums[third];
                if (sum == target){
                    return target;
                }
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }

                if (sum>target){
                    int third0 = third-1;
                    while (second<third0 && nums[third0]==nums[third]){
                        --third0;
                    }
                    third=third0;
                }else {
                    int second0 = second+1;
                    while (second0 < third && nums[second0]==nums[second]){
                        ++second0;
                    }
                    second=second0;
                }
            }
        }
        return res;
    }
}
