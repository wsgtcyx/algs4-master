package lc.dp;

import java.util.Arrays;

/**
 * Created on 2020-05-24-20:59
 *
 * @author Chen Yuxiang(yuxiangchen@sohu-inc.com)
 * 300. 最长上升子序列
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * dp[i] = 以i位置元素为结尾的最长上升子序列
 */
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        if(nums.length <= 1) {
            return nums.length;
        }

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int maxLen = 1;

        for (int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }
}
