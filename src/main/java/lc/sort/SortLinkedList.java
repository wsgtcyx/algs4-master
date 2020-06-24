package lc.sort;

import lc.utils.ListNode;

/**
 * Created on 2020-05-18-22:51
 *
 * @author Chen Yuxiang(yuxiangchen@sohu-inc.com)
 *  * 148. 排序链表
 *  * https://leetcode-cn.com/problems/sort-list/
 *  * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *  *
 *  * 思路：采用mergeSort，链表存储时不需要额外数组空间。
 *  * 如何进行对半切分：采用快慢指针。
 */


public class SortLinkedList {


    static ListNode mergeSort(ListNode head) {

        if(head.next == null) {
            return head;
        }


        ListNode slow = head, fast = head;
        ListNode slowPrev = null;

        while(fast != null && fast.next != null) {
            slowPrev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        slowPrev.next = null;
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(slow);

        return merge(left, right);

    }

    static ListNode merge(ListNode a, ListNode b) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while(a != null && b != null) {
            if(a.val < b.val) {
                cur.next = a;
                cur = cur.next;
                a = a.next;
            }else {
                cur.next = b;
                cur = cur.next;
                b = b.next;
            }
        }

        if(a != null){
            cur.next = a;
        }
        if(b != null) {
            cur.next = b;
        }
        return head.next;
    }

    public ListNode sortList(ListNode head) {
        if(head == null) {
            return null;
        }

        return mergeSort(head);
    }
}
