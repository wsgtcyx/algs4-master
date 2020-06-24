package lc.stackqueue;

import java.util.Stack;

/**
 * Created on 2020-05-17-17:34
 *
 * @author Chen Yuxiang(yuxiangchen@sohu-inc.com)
 * 155. 最小栈
 * https://leetcode-cn.com/problems/min-stack/
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class MinStack {
    Stack<Integer> s1, s2;

    /** initialize your data structure here. */
    public MinStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        s1.push(x);

        if(s2.isEmpty()) {
            s2.push(x);
        }else{
            s2.push(Math.min(s2.peek(), x));
        }
    }

    public void pop() {
        s1.pop();
        s2.pop();
    }

    public int top() {
        return s1.peek();
    }

    public int getMin() {
        return s2.peek();
    }
}
