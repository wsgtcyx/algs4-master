package lc.stackqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * Created on 2020-05-17-16:31
 *
 * @author Chen Yuxiang(yuxiangchen@sohu-inc.com)
 * 1172. 餐盘栈
 * https://leetcode-cn.com/problems/dinner-plate-stacks/
 * 我们把无限数量 ∞ 的栈排成一行，按从左到右的次序从 0 开始编号。每个栈的的最大容量 capacity 都相同。
 *
 * 实现一个叫「餐盘」的类 DinnerPlates：
 *
 * DinnerPlates(int capacity) - 给出栈的最大容量 capacity。
 * void push(int val) - 将给出的正整数 val 推入 从左往右第一个 没有满的栈。
 * int pop() - 返回 从右往左第一个 非空栈顶部的值，并将其从栈中删除；如果所有的栈都是空的，请返回 -1。
 * int popAtStack(int index) - 返回编号 index 的栈顶部的值，并将其从栈中删除；如果编号 index 的栈是空的，请返回 -1。
 *
 * 未AC
 *
 */
class DinnerPlates {
    List<Stack<Integer>> plates;
    int nonFullFront = 0;  //从右往左，第一个没有满的栈的index
    int nonEmptyFront = 0;
    int totalSize = 0;
    int capacity;

    public DinnerPlates(int capacity) {
        plates = new ArrayList<>();
        this.capacity = capacity;
        plates.add(new Stack<Integer>());
    }

    public void updateNonFullFront() {
        int index = nonFullFront;
        while(true) {
            Stack<Integer> plate = plates.get(index);
            if(plate.size() < capacity) {
                break;
            }
            index ++;
            if(plates.size() == index) {
                plates.add(new Stack<>());
            }
        }

        nonFullFront = index;
    }

    public void updateNonEmptyFront() {
        if(totalSize == 0) {
            nonEmptyFront = 0;
            return;
        }
        int index = nonEmptyFront;
        while(true) {
            Stack<Integer> plate = plates.get(index);
            if(!plate.isEmpty()) {
                break;
            }

        }
    }

    public void push(int val) {
        Stack<Integer> plate = plates.get(nonFullFront);
        plate.push(val);

        totalSize += 1;

        updateNonEmptyFront();
        updateNonFullFront();
    }

    public int pop() {
        if(totalSize == 0) {
            return -1;
        }

        int index = nonEmptyFront;
        while(true) {
            Stack<Integer> plate = plates.get(index);
            if(plate.isEmpty()) {
                index --;
                continue;
            }

            Integer result = plate.pop();
            nonEmptyFront = index;
            totalSize --;
            return result;
        }
    }

    public int popAtStack(int index) {
        if(totalSize == 0) {
            return -1;
        }
        if(index >= plates.size()) {
            return -1;
        }

        Stack<Integer> plate = plates.get(index);
        if(plate.isEmpty()) {
            return -1;
        }
        Integer result = plate.pop();
        totalSize --;
        if(nonEmptyFront > index) {
            nonEmptyFront = index;
        }
        return result;
    }

}
