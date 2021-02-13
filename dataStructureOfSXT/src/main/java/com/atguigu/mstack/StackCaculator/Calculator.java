package com.atguigu.mstack.StackCaculator;

import java.util.Scanner;

public class Calculator {
    private final static Scanner scanner = new Scanner(System.in);
    private final static TemplateStack<Character> charStack = new TemplateStack<>();
    private final static TemplateStack<Double> numStack = new TemplateStack<>();

    public static String getInpupt() {
        System.out.println("请输入计算表达式：");
        return scanner.nextLine();
    }

    public static Double calcu2Numbers(Double first, Double second, Character op) {
        Double res = 0.0;
        switch (op) {
            case '+':
                res = first + second;
                break;
            case '-':
                res = second - first;
                break;
            case '*':
                res = first * second;
                break;
            case '/':
                res = second / first;
                break;
            default:
                break;
        }
        return res;
    }

    public static boolean isIlegal(String str) {
        if (str.length() == 0) {
            return false;
        }
        boolean res = true;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) <= '9' && str.charAt(i) >= 0) {
                res = true;
            } else {
                switch (str.charAt(i)) {
                    case '+':
                    case '*':
                    case '-':
                    case '/':
                        res = true;
                        break;
                    default:
                        res = false;
                }
            }
            if (res == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * special case:
     * 1. 只有一个数字 x
     * 2. 有特殊符号（输入不合法）
     * 4. 符号结尾
     *
     * @param str 要进行计算的字符串
     * @return 计算结果
     * @throws Exception
     */
    public static Double calculate(String str) throws Exception {
        if (!isIlegal(str)) {
            throw new Exception("输入不合法");
        }
        int index = 0;
        Double num = 0.0;
        int curChar = 0;
        /**
         * index对字符串进行扫描
         * 扫描到末尾，正常来说应该是数字，此时pop出一个符号，pop出一个数字，两者进行计算
         */
        while (index < str.length()) {
            curChar = str.charAt(index++);
            /**
             * 如果是数字，连续读取，然后找到完整的数字，直接入数字栈
             */
            if (curChar <= '9' && curChar >= '0') {
                num = num * 10 + Character.getNumericValue(curChar);
            } else {
                /**
                 * 如果是符号
                 *  1. 符号栈为空：直接入栈
                 *  2. 当前符号优先级大于等于栈顶符号优先级，入栈
                 *  3. 当前符号优先级小于栈顶符号优先级，从数栈中pop出两个数、符号栈pop出一个符号进行计算，然后将结果入数栈，当前符号入符号栈
                 */
                /**
                 * 如果符号在最后，舍弃（即跳出循环）
                 */
                numStack.push(num);
                if (index == str.length()) {
                    break;
                }
                num = 0.0;
                if (charStack.isEmpty()) {
                    charStack.push((char) curChar);
                } else {
                    int topPri = charStack.priority(new TemplateNode<Character>(charStack.peek()));
                    int curPri = charStack.priority(new TemplateNode<Character>((char) curChar));
                    if (curPri > topPri) {
                        charStack.push((char) curChar);
                    } else {
                        char op = charStack.pop();
                        double first = numStack.pop();
                        double second = numStack.pop();
                        numStack.push(Calculator.calcu2Numbers(first, second, op));
                        charStack.push((char) curChar);
                    }
                }
            }
        }
        /**
         * 正常表达式，扫描完后最后应该是一个数，即num != 0
         */
        if (num != 0.0) {
            numStack.push(num);
        }
        while (!charStack.isEmpty() && numStack.size > 1) {
            numStack.push(Calculator.calcu2Numbers(numStack.pop(), numStack.pop(), charStack.pop()));
        }
        return numStack.pop();
    }
}
