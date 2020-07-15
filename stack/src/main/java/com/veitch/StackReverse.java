package com.veitch;

import java.util.Stack;

/**
 * 只用递归逆转 stack
 *
 * @author zhengweichao  2020-07-15 11:48 上午
 **/
public class StackReverse {

    private static void reverse(Stack<Integer> stack){
        if (stack.isEmpty()) {
            return;
        }

        Integer last = getAndPopLastElement(stack);
        reverse(stack);
        stack.push(last);
    }

    private static Integer getAndPopLastElement(Stack<Integer> stack){
        Integer result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            Integer last = getAndPopLastElement(stack);
            stack.push(result);
            return last;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        reverse(stack);

        for (int i = 0; i < 5; i++) {
            System.out.println(stack.pop());
        }
    }
}
