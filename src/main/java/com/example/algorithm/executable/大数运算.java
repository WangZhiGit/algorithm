package com.example.algorithm.executable;

import java.util.Stack;

public class 大数运算 {
    public static Stack<Integer> stringToStack(String str) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                stack.push(Integer.valueOf(String.valueOf(c)));
            }
        }

        return stack;
    }

    public static String add(String a, String b) {
        Stack<Integer> stackA = stringToStack(a);
        Stack<Integer> stackB = stringToStack(b);
        Stack<Integer> stackSum = new Stack<>();
        int tempSum;
        boolean isCarry = false;

        while (!stackA.isEmpty() && !stackB.isEmpty()) {
            tempSum = stackA.pop() + stackB.pop();

            //若有进位，加1
            if (isCarry) {
                tempSum++;
                isCarry = false;
            }

            //位数和大于10，个位数入栈，标志进位
            if (tempSum >= 10) {
                tempSum -= 10;
                stackSum.push(tempSum);
                isCarry = true;
            } else {
                stackSum.push(tempSum);
            }
        }

        //取不为空的栈
        Stack<Integer> stackTemp = !stackA.isEmpty() ? stackA : stackB;
        while (!stackTemp.isEmpty()) {
            if (isCarry) {
                int end = stackTemp.pop();
                end++;
                if (end >= 10) {
                    end -= 10;
                    stackSum.push(end);
                } else {
                    stackSum.push(end);
                    isCarry = false;
                }
            } else {
                stackSum.push(stackTemp.pop());
            }
        }

        //最高位有进位时，直接最后一个数为1
        if (isCarry) {
            stackSum.push(1);
        }

        //把栈中结果转为字符串
        String result = new String();
        while (!stackSum.isEmpty()) {
            result = result.concat(stackSum.pop().toString());
        }

        return result;
    }

    public static void main(String[] args) {
        String a = "123456";
        String b = "654321";
        System.out.print("和为：" + add(a, b));
    }
}
