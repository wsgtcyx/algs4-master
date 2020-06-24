package lc.window;

import java.util.Arrays;

/**
 * Created on 2020-05-23-23:27
 *
 * @author Chen Yuxiang(yuxiangchen@sohu-inc.com)
 * 1099 号问题：小于 K 的两数之和。
 *
 * 给你一个整数数组 A 和一个整数 K，请在该数组中找出两个元素，使它们的和小于 K 但尽可能地接近 K，返回这两个元素的和。
 *
 * 如不存在这样的两个元素，请返回 -1。
 *
 * 思路: 用双指针
 */
public class TwoSumLessThanK {

    public int twoSumLessThanK(int[] A, int K) {
        if (A == null || A.length == 0) {
            return -1;
        }

        Arrays.sort(A);

        int l = 0, r = A.length - 1;
        int result = Integer.MIN_VALUE;

        while (l < r) {
            if (A[l] + A[r] >= K) {
                r--;
            } else {
                result = Math.max(result, A[l] + A[r]);
                l++;
            }
        }

        return result == Integer.MIN_VALUE ? -1 : result;
    }
}
