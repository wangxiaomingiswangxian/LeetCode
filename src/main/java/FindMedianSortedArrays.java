/**
 * 获取数组中位数
 *
 * @author 王贤
 */
public class FindMedianSortedArrays {

//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int[] nums;
//        int m = nums1.length;
//        int n = nums2.length;
//        nums = new int[m + n];
//        if (m == 0) {
//            if (n % 2 == 0) {
//                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
//            } else {
//
//                return nums2[n / 2];
//            }
//        }
//        if (n == 0) {
//            if (m % 2 == 0) {
//                return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
//            } else {
//                return nums1[m / 2];
//            }
//        }
//
//        int count = 0;
//        int i = 0, j = 0;
//        while (count != (m + n)) {
//            if (i == m) {
//                while (j != n) {
//                    nums[count++] = nums2[j++];
//                }
//                break;
//            }
//            if (j == n) {
//                while (i != m) {
//                    nums[count++] = nums1[i++];
//                }
//                break;
//            }
//
//            if (nums1[i] < nums2[j]) {
//                nums[count++] = nums1[i++];
//            } else {
//                nums[count++] = nums2[j++];
//            }
//        }
//
//        if (count % 2 == 0) {
//            return (nums[count / 2 - 1] + nums[count / 2]) / 2.0;
//        } else {
//            return nums[count / 2];
//        }
//    }


//    public double findMedianSortedArrays(int[] A, int[] B) {
//        int m = A.length;
//        int n = B.length;
//        int len = m + n;
//        int left = -1, right = -1;
//        int aStart = 0, bStart = 0;
//        for (int i = 0; i <= len / 2; i++) {
//            left = right;
//            if (aStart < m && (bStart >= n || A[aStart] < B[bStart])) {
//                right = A[aStart++];
//            } else {
//                right = B[bStart++];
//            }
//        }
//        if ((len & 1) == 0) {
//            return (left + right) / 2.0;
//        } else {
//            return right;
//        }
//    }


    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int all = m + n;
        int left = -1, right = -1;
        int aStart = 0, bStart = 0;
        for (int i = 0; i < all / 2; i++) {
            left = right;
            if (aStart < m && (bStart >= n || A[aStart] < B[bStart])) {
                right = A[aStart++];
            } else {
                right = B[bStart++];
            }
        }
        if ((all & 1) == 0) {
            return (left + right) / 2.0;
        } else {
            return right;
        }
    }

}
