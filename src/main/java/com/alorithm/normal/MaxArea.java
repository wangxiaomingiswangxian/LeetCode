package com.alorithm.normal;

/**
 * @author 王贤
 */
public class MaxArea {

    public static void main(String[] args) {
        int a[] = {1,1};
        int b[] = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(a));
        System.out.println(maxArea(b));
    }

    /**
     * 给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。
     *
     * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
     *
     * 返回容器可以储存的最大水量。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/container-with-most-water
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int maxArea(int[] height) {
        int res=0;
        int start=0,end=height.length-1;
        while (start<end){
            if (height[start]<height[end]){
                res = Math.max((end-start)*height[start],res);
                start++;
            }else {
                res = Math.max((end-start)*height[end],res);

                end--;
            }
        }
        return res;

    }
}
