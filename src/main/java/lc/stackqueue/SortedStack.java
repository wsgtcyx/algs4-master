package lc.stackqueue;

import java.util.Stack;

/**
 * Created on 2020-05-17-17:23
 *
 * @author Chen Yuxiang(yuxiangchen@sohu-inc.com)
 * 栈排序
 * https://leetcode-cn.com/problems/sort-of-stacks-lcci/
 * 栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-of-stacks-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路：用两个栈， 第一个栈内存储排序好的元素，小的在栈顶，用于pop。   栈2用于push时辅助操作。
 *  在push时，若元素比最小值大，需要插在中间，则利用栈2先暂时保存比该元素小的items，赛好该元素后，items再返回到栈1.
 */
class SortedStack {
    Stack<Integer> s1, s2;

    public SortedStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int val) {
        while(!s1.isEmpty() && s1.peek() < val) {
            s2.push(s1.pop());
        }
        s1.push(val);

        while(!s2.isEmpty()) {
            s1.push(s2.pop());
        }

    }

    public void pop() {
        if(isEmpty()) {
            return;
        }
        s1.pop();
        return;
    }

    public int peek() {
        if(isEmpty()) {
            return -1;
        }
        return s1.peek();
    }

    public boolean isEmpty() {
        return s1.isEmpty();
    }
}
