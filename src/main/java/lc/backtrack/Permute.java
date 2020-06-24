package lc.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created on 2020-05-24-16:21
 * 46. 全排列
 * https://leetcode-cn.com/problems/permutations/
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * result = []
 * def backtrack(路径, 选择列表):
 *     if 满足结束条件:
 *         result.add(路径)
 *         return
 *
 *     for 选择 in 选择列表:
 *         做选择
 *         backtrack(路径, 选择列表)
 *         撤销选择
 *
 * @author Chen Yuxiang(yuxiangchen@sohu-inc.com)
 */
public class Permute {


    public boolean[] used;
    public int totalLen = 0;

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        totalLen = nums.length;
        used = new boolean[totalLen];

        backTrack(path, nums, result);
        return result;
    }

    public void backTrack(List<Integer> path, int[] candidates, List<List<Integer>> result) {
        if(path.size() == totalLen) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < candidates.length; i++) {
            if(used[i]) {
                continue;
            }

            // 做选择
            path.add(candidates[i]);
            used[i] = true;

            backTrack(path, candidates, result);

            // 撤销选择
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
