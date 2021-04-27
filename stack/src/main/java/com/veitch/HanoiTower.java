package com.veitch;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 汉诺塔问题比较经典，这里修改一下游戏规则:现在限制不能从最左侧的塔直接移动到最右侧，也不能从最右侧直接移动到最左侧，而是必须经过中间。求当塔有N层的时候，打印最优移动过程和最优移动总步数。
 * 例如，当塔数为两层时，最上层的塔记为1，最下层的塔记为2，则打印:
 * Move 1 from left to mid
 * Move 1 from mid to right
 * Move 2 from left to mid
 * Move 1 from right to mid
 * Move 1 from mid to left
 * Move 2 from mid to right
 * Move 1 from left to mid
 * Move 1 from mid to right
 * It will move 8 steps.
 *
 * @author zhengweichao  2020-07-22 3:51 下午
 **/
public class HanoiTower {

    private static Map<String, String> reverse = new HashMap<>();

    static {
        reverse.put("l2m", "m2l");
        reverse.put("r2m", "m2r");
        reverse.put("m2l", "l2m");
        reverse.put("m2r", "r2m");
    }

    public static void play(Integer layers) {

        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> middleStack = new Stack<>();
        Stack<Integer> rightStack = new Stack<>();
        leftStack.push(Integer.MAX_VALUE);
        middleStack.push(Integer.MAX_VALUE);
        rightStack.push(Integer.MAX_VALUE);

        for (int i = layers; i >0; i--) {
            leftStack.push(i);
        }

        Integer count = 0;
        String lastOperation = "";


        while (Integer.MAX_VALUE != leftStack.peek() || (Integer.MAX_VALUE !=  middleStack.peek() && Integer.MAX_VALUE != rightStack.peek())) {
            count++;
            if (leftStack.peek() < middleStack.peek() && !"l2m".equals(reverse.get(lastOperation))) {
                Integer pop = leftStack.pop();
                middleStack.push(pop);
                lastOperation = "l2m";
                System.out.println("Move " + pop + " from left to mid");
            } else if (middleStack.peek() < leftStack.peek()  && !"m2l".equals(reverse.get(lastOperation))) {
                Integer pop = middleStack.pop();
                leftStack.push(pop);
                lastOperation = "m2l";
                System.out.println("Move " + pop + " from mid to left");
            } else if (middleStack.peek() < rightStack.peek()  && !"m2r".equals(reverse.get(lastOperation))) {
                Integer pop = middleStack.pop();
                rightStack.push(pop);
                lastOperation = "m2r";
                System.out.println("Move " + pop + " from mid to right");
            } else if (rightStack.peek() < middleStack.peek()  && !"r2m".equals(reverse.get(lastOperation))) {
                Integer pop = rightStack.pop();
                middleStack.push(pop);
                lastOperation = "r2m";
                System.out.println("Move " + pop + " from right to mid");
            }
        }

        System.out.println("It will move "+count+" steps.");

    }

    public static void main(String[] args) {
        play(5);
        System.out.println(count(4));
        System.out.println(nomalCount(4));
    }

    private static double count(Integer layers){
        if (layers == 0) {
            return 0;
        }
        return count(layers - 1) + Math.pow(3, layers - 1);

    }

    private static int nomalCount(Integer layers){
        if (layers == 0) {
            return 0;
        }
        if (layers == 1) {
            return 1;
        }
        return 1 + 2 * nomalCount(layers - 1);
    }


}
