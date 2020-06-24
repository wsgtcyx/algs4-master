package lc.dp;

/**
 * Created on 2020-05-24-16:15
 *
 * @author Chen Yuxiang(yuxiangchen@sohu-inc.com)
 * 53. 最大子序和
 * https://leetcode-cn.com/problems/maximum-subarray/
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) return nums[0];

        // dp[i] 即以i为结尾的子序列的最大和
        int[] dp = new int[nums.length];
        int max = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(0, dp[i - 1]) + nums[i];
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
