package lc.backtrack;

/**
 * Created on 2020-05-24-16:43
 *
 * @author Chen Yuxiang(yuxiangchen@sohu-inc.com)
 * 10. 正则表达式匹配
 * https://leetcode-cn.com/problems/regular-expression-matching/
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 *
 */
public class RegexMatch {
    boolean find;
    String s, p;
    int sLen, pLen;
    public boolean isMatch(String s, String p) {
        this.s = s;
        this.p = p;
        this.sLen = s.length();
        this.pLen = p.length();
        find = false;
        backtrack(0, 0);
        return find;
    }

    public boolean backtrack(int sIndex, int pIndex) {
        if(sIndex == (sLen - 1) && (pIndex == (pLen - 1))) {
            find = true;
            return true;
        }

        if(sIndex == (sLen -1) ^ pIndex == (pLen - 1)) {
            return false;
        }

        boolean result = false;
        // 考虑多个选择
        char pChar = p.charAt(pIndex);
        char sChar = s.charAt(sIndex);
        boolean first = false;
        if(pChar == sChar || pChar == '.') {
            first = true;
        }

        if(pIndex < (pLen - 1) && p.charAt(pIndex + 1) == '*') {
            // 可以选择不匹配或者匹配一次
            return (backtrack(sIndex, pIndex + 2)) ||
                (first && backtrack(sIndex + 1, pIndex));
        }else {
            return (first && backtrack(sIndex + 1, pIndex + 1));
        }
    }
}
