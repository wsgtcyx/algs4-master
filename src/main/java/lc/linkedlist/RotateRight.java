package lc.linkedlist;

import lc.utils.ListNode;

/**
 * Created on 2020-05-21-22:09
 *
 * @author Chen Yuxiang(yuxiangchen@sohu-inc.com)
 * 61. 旋转链表
 * https://leetcode-cn.com/problems/rotate-list/
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 *
 * 思路：先将链表连成环，然后再在新头部断开即可。
 *
 */
public class RotateRight {

    public ListNode rotateRight(ListNode head, int k) {
        if(k == 0 || head == null || head.next == null) {
            return head;
        }
        // step1 : 记录链表长度
        int length = 1;
        ListNode current = head;
        while(current.next != null) {
            current = current.next;
            length ++;
        }
        // step2 将链表变成环
        current.next = head;

        // step3 找到新头部前一个节点
        int newHeadPreIndex = length - k % length - 1;
        int curIndex = 0;
        current = head;
        while(curIndex != newHeadPreIndex) {
            current = current.next;
            curIndex ++;
        }
        // 断开为链表
        ListNode newHead = current.next;
        current.next = null;

        return newHead;
    }

}
