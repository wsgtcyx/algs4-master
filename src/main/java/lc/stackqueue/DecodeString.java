package lc.stackqueue;

import edu.princeton.cs.algs4.In;
import java.util.Stack;

/**
 * Created on 2020-05-17-17:41
 *
 * @author Chen Yuxiang(yuxiangchen@sohu-inc.com)
 * 394. 字符串解码
 * https://leetcode-cn.com/problems/decode-string/
 *
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 示例:
 *
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class DecodeString {

    public String decodeString2(String s) {
        StringBuilder sb = new StringBuilder();

        Stack<Integer> multiStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();

        int multi = 0;

        for(char c : s.toCharArray()) {
            if(c <= '9' && c >= '0') {
                multi = multi * 10 + Integer.parseInt(c + "");
            }else if((c <= 'z' && c >= 'a') || (c >= 'A' && c <= 'Z') ) {
                sb.append(c);
            }else if(c == '[') {
                multiStack.add(multi);
                multi = 0;
                stringStack.add(sb.toString());
                sb = new StringBuilder();
            }else if(c == ']') {
                StringBuilder preSb = new StringBuilder(stringStack.pop());
                int curMulti = multiStack.pop();
                for(int j = 0; j< curMulti; j ++) {
                    preSb.append(sb);
                }
                sb = preSb;
            }
        }

        return sb.toString();
    }
}