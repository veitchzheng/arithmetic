package com.veitch;

import java.util.Stack;

/**
 * 用一个栈给另一个栈排序
 *
 * @author zhengweichao  2020-07-21 4:36 下午
 **/
public class StackOrder {

    public static Stack<Integer> order(Stack<Integer> stack){

        if (stack.isEmpty()) {
            return stack;
        }

        Stack<Integer> orderStack = new Stack<>();

        Integer temp;

        while (!stack.isEmpty()){
            if (orderStack.isEmpty()) {
                orderStack.push(stack.pop());
                continue;
            }

            if (orderStack.peek() > stack.peek()) {
                orderStack.push(stack.pop());
            } else {
                temp = stack.pop();

                while (!orderStack.isEmpty() && temp > orderStack.peek()){
                    stack.push(orderStack.pop());
                }
                orderStack.push(temp);
            }
        }



        return orderStack;
    }

    public static void main(String[] args) {

        Stack<Integer> integers = new Stack<>();
        integers.push(3);
        integers.push(7);
        integers.push(3);
        integers.push(5);
        integers.push(1);
        Stack<Integer> orders = order(integers);
        while (!orders.isEmpty()){
            System.out.println(orders.pop());
        }



    }

}
