package lc.window;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2020-05-20-23:15
 *
 * @author Chen Yuxiang(yuxiangchen@sohu-inc.com)
 * 3. 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路：用Map + 双指针滑动窗口
 */
public class UniqueSubString {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        int left = 0, right = 0, maxLen = 0;
        Map<Character, Integer> lastIndexMap = new HashMap<>();
        while(right < s.length()) {
            Character ch = s.charAt(right);

            Integer lastIndex = lastIndexMap.get(ch);
            if(lastIndex != null && lastIndex >= left) {
                left = lastIndex + 1;
            }

            maxLen = Math.max(maxLen, right - left + 1);

            lastIndexMap.put(ch, right);
            right ++;
        }

        return maxLen;
    }

}
