package com.veitch;

import java.util.Stack;

/**
 * 可以返回最小值的栈
 *
 * @author zhengweichao  2020-07-17 2:33 下午
 **/
public class MinStack {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MinStack() {
        stackData = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(Integer data) {
        stackData.push(data);
        if (stackMin.isEmpty() || data < getMin()) {
            stackMin.push(data);
        }
    }

    public Integer pop() {
        if (stackData.isEmpty()) {
            throw new RuntimeException("MinStack is empty!");
        }

        Integer data = stackData.pop();
        if (data.equals(getMin())) {
            stackMin.pop();
        }
        return data;
    }

    public Integer getMin() {
        if (stackMin.isEmpty()) {
            throw new RuntimeException("MinStack is empty!");
        }
        return stackMin.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(3);
        System.out.println(minStack.getMin());
        minStack.push(2);
        System.out.println(minStack.getMin());
        minStack.push(1);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();

    }

}
