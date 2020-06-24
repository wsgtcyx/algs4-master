package lc.union;

import java.util.Arrays;

/**
 * Created on 2020-05-19-22:19
 *
 * @author Chen Yuxiang(yuxiangchen@sohu-inc.com)
 * 56. 合并区间
 * https://leetcode-cn.com/problems/merge-intervals/
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 先按照区间起始位置排序，然后分类讨论。
 */
public class MergeDuration {
    public int[][] merge(int[][] intervals) {
        // 先按照区间起始位置排序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]); // 升序

        int[][] res = new int[intervals.length][2];
        int resIdx = -1;
        for (int[] interval : intervals) {
            if(resIdx == -1) { // 如果结果没有区间，则直接加入
                resIdx ++;
                res[resIdx] = interval;
                continue;
            }

            // 可以合并
            if(interval[0] <= res[resIdx][1]) {
                int curRight = Math.max(res[resIdx][1], interval[1]);
                res[resIdx][1] = curRight;
            }else {
                resIdx ++;
                res[resIdx] = interval;
            }
        }

        return Arrays.copyOf(res, resIdx + 1);

    }
}
