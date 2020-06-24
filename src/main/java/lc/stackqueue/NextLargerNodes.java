package lc.stackqueue;

/**
 * Created on 2020-05-17-20:34
 *
 * @author Chen Yuxiang(yuxiangchen@sohu-inc.com)
 * 1019. 链表中的下一个更大节点
 * https://leetcode-cn.com/problems/next-greater-node-in-linked-list/
 *
 * 给出一个以头节点 head 作为第一个节点的链表。链表中的节点分别编号为：node_1, node_2, node_3, ... 。
 *
 * 每个节点都可能有下一个更大值（next larger value）：对于 node_i，如果其 next_larger(node_i) 是 node_j.val，那么就有 j > i 且  node_j.val > node_i.val，而 j 是可能的选项中最小的那个。如果不存在这样的 j，那么下一个更大值为 0 。
 *
 * 返回整数答案数组 answer，其中 answer[i] = next_larger(node_{i+1}) 。
 *
 * 注意：在下面的示例中，诸如 [2,1,5] 这样的输入（不是输出）是链表的序列化表示，其头节点的值为 2，第二个节点值为 1，第三个节点值为 5 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-node-in-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 维护三个数据结构，一个栈，用于存储节点的index，一个Array，存储节点的数据值，一个Array，存储节点的下一个更大节点值。
 * 按单调递增栈的入栈顺序，如果出现当前遍历到的节点比栈顶值大，说明需要将栈中元素出栈，并更新 res 值
 * 单调递增栈 ：数据出栈的序列为单调递增序列
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import lc.utils.ListNode;


public class NextLargerNodes {


    public int[] nextLargerNodes(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> data = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        int index = 0;
        ListNode node = head;
        while(node != null) {
            int val = node.val;
            data.add(val);
            result.add(0);

            while(!stack.isEmpty() && data.get(stack.peek()) < val) {
                result.set(stack.pop(), val);
            }
            stack.push(index);
            index ++;
            node = node.next;
        }


        int[] largerNodes = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            largerNodes[i] = result.get(i);
        }
        return largerNodes;

    }



}
