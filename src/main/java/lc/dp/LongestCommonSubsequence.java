package lc.dp;

/**
 * Created on 2020-05-24-21:26
 *
 * @author Chen Yuxiang(yuxiangchen@sohu-inc.com)
 * 1143. 最长公共子序列
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 *
 * 若这两个字符串没有公共子序列，则返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路：https://leetcode-cn.com/problems/longest-common-subsequence/solution/dong-tai-gui-hua-zhi-zui-chang-gong-gong-zi-xu-lie/
 */
public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {

        if(text1.length() == 0 || text2.length() == 0) {
            return 0;
        }

        int M = text1.length();
        int N = text2.length();
        int[][] dp = new int[M + 1][N + 1];

        for(int i = 1; i <= M; i++) {
            for(int j = 1; j <= N; j ++) {
                if(text1.charAt(i -1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }

        }
        return dp[M][N];
    }

}
