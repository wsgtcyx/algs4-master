package lc.linkedlist;

import lc.utils.ListNode;

/**
 * Created on 2020-05-24-01:11
 *
 * @author Chen Yuxiang(yuxiangchen@sohu-inc.com)
 * 2. 两数相加
 * https://leetcode-cn.com/problems/add-two-numbers/
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode(-1);
        int resNumber = 0;

        ListNode current = result;

        while(l1 != null || l2 != null) {
            int curNumber = resNumber;
            resNumber = 0;
            if(l1 != null) {
                curNumber += l1.val;
            }
            if(l2 != null) {
                curNumber += l2.val;
            }

            if(curNumber > 9) {
                resNumber = 1;
                curNumber -= 10;
            }

            ListNode tmp = new ListNode(curNumber);
            current.next = tmp;

            current = current.next;
            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }
        if(resNumber > 0) {
            ListNode tmp = new ListNode(resNumber);
            current.next = tmp;
        }
        return result.next;
    }
}
