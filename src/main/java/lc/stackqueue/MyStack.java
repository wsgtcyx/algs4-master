package lc.stackqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created on 2020-05-17-16:06
 *
 * @author Chen Yuxiang(yuxiangchen@sohu-inc.com)
 * 225. 用队列实现栈
 * https://leetcode-cn.com/problems/implement-stack-using-queues/
 * 使用队列实现栈的下列操作：
 *
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 注意:
 *
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-stack-using-queues
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路：栈为LIFO  队列为FIFO
 *  每次添加元素的时候，对队列的元素进行倒序
 *  插入元素操作O(n), 弹出元素操作O(1)
 */
class MyStack {
    Queue<Integer> q;

    /** Initialize your data structure here. */
    public MyStack() {
        q = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q.add(x);
        int size = q.size();
        while(size > 1) {
            Integer head = q.remove();
            q.add(head);
            size --;
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(empty()) {
            return -1;
        }

        return q.remove();
    }

    /** Get the top element. */
    public int top() {
        if(empty()) {
            return -1;
        }
        return q.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
    }
}
