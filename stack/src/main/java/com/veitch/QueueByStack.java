package com.veitch;

import java.util.Stack;

/**
 * 用栈实现队列
 *
 * @author zhengweichao  2020-07-17 2:59 下午
 **/
public class QueueByStack {

    Stack<Integer> stackPush;
    Stack<Integer> stackPop;

    public QueueByStack(){
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    public void add(Integer data){
        stackPush.push(data);
    }

    public Integer poll(){
        if (stackPush.isEmpty() && stackPop.isEmpty()) {
            throw new RuntimeException("QueueByStack is empty!");
        } else if (stackPop.isEmpty()){
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }

        return stackPop.pop();
    }

    public Integer peek(){
        if (stackPush.isEmpty() && stackPop.isEmpty()) {
            throw new RuntimeException("QueueByStack is empty!");
        } else if (stackPop.isEmpty()){
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }

        return stackPop.peek();
    }

    public static void main(String[] args) {
        QueueByStack queueByStack = new QueueByStack();
        queueByStack.add(1);
        queueByStack.add(2);
        queueByStack.add(3);
        queueByStack.add(4);
        System.out.println(queueByStack.peek());
        System.out.println(queueByStack.poll());
        System.out.println(queueByStack.peek());
        System.out.println(queueByStack.poll());
        System.out.println(queueByStack.peek());
        System.out.println(queueByStack.poll());
        System.out.println(queueByStack.peek());
        System.out.println(queueByStack.poll());



    }



}
