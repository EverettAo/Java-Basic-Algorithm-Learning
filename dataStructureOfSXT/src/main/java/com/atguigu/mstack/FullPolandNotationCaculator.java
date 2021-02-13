package com.atguigu.mstack;

import java.util.*;

public class FullPolandNotationCaculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp;

        while (true) {
            System.out.println("请输入表达式：");
            exp = scanner.nextLine();
            List<String> inffixList = toInfixExpList(exp);
            List<String> suffixList = inffix2suffix(inffixList);
            double res = calculateViaPolandNotation(suffixList);
            System.out.println(res);
        }
    }

    /**
     * 用逆波兰表达式进行计算，只需要一个栈即可
     *
     * @param ls
     * @return
     */
    public static double calculateViaPolandNotation(List<String> ls) {
        Stack<String> stack = new Stack<>();
        for (String s : ls) {
            /**
             * 使用正则表达式来取出数
             */
            if (s.matches("\\d+") || s.matches("\\d+.\\d+")) {
                stack.push(s);
            } else {
                Double first = Double.parseDouble(stack.pop());
                Double second = Double.parseDouble(stack.pop());
                stack.push(String.valueOf(calculate2Nums(second, first, s)));
            }
        }
        return Double.parseDouble(stack.pop());
    }

    /**
     * 1. 如果是数，直接进2栈
     * 2. 如果是符号：
     * 0. 1栈空，直接进栈
     * 1. 括号：
     * 1. “（”直接进1栈
     * 2. “）”把1栈“（”前的符号pop出来并进2栈，括号舍弃
     * 2. 当前符号优先级低于等于1栈栈顶符号：1栈pop一个符号进2栈
     * 3. 当前符号优先级高于1栈栈顶符号：进1栈
     *
     * @param inffixList
     * @return
     */
    public static List<String> inffix2suffix(List<String> inffixList) {
        Stack<String> s1 = new Stack<>();
        Stack<String> s2 = new Stack<>();
        int i = 0;
        String curS;
        for (i = 0; i < inffixList.size(); i++) {
            curS = inffixList.get(i);
            if (!isOperator(curS)) {
                /**
                 * 数字
                 */
                s2.push(curS);
            } else {
                /**
                 * 符号
                 */
                if (curS.equals("(") || s1.isEmpty()) {
                    s1.push(curS);
                } else if (curS.equals(")")) {
                    while (!s1.peek().equals("(")) {
                        s2.push(s1.pop());
                    }
                    /**
                     * 舍弃括号 “（”
                     */
                    s1.pop();
                } else {
                    if (s1.peek().equals("(")) {
                        s1.push(curS);
                    } else if (priority(curS) <= priority(s1.peek())) {
                        s2.push(s1.pop());
                        s1.push(curS);
                    } else {
                        s1.push(curS);
                    }
                }
            }
        }
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        List<String> list = new ArrayList<>();
        while (!s2.isEmpty()) {
            list.add(s2.pop());
        }
        Collections.reverse(list);
        return list;
    }

    public static boolean isOperator(String s) {
        return s.equals(")") || s.equals("(") || s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    public static int priority(String op) {
        if (op.equals("+") || op.equals("-")) {
            return -1;
        } else if (op.equals("*") || op.equals("/")) {
            return 1;
        } else {
            throw new RuntimeException("运算符错误");
        }
    }

    /**
     * 将中缀表达式字符串转换为List
     *
     * @param str
     * @return
     */
    public static List<String> toInfixExpList(String str) {
        List<String> stringList = new ArrayList<>();
        char c;
        String s;
        int i = 0;
        do {
            /**
             * 注意i只在数字处变动
             */
            c = str.charAt(i);
            /**
             * 如果是数字，把数字读完
             */
            if (c >= '0' && c <= '9') {
                s = "";
                while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    c = str.charAt(i);
                    s += c;
                    i++;
                }
                if (i < str.length() && str.charAt(i) == '.') {
                    c = str.charAt(i);
                    s += c;
                    i++;
                    while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                        c = str.charAt(i);
                        s += c;
                        i++;
                    }
                }
                stringList.add(s);
            } else {
                /**
                 * 符号，直接入栈
                 */
                stringList.add("" + c);
                i++;
            }
        } while (i < str.length());
        return stringList;
    }

    public static double calculate2Nums(Double f, Double s, String op) {
        Double res = 0.0;
        switch (op) {
            case "+":
                res = f + s;
                break;
            case "-":
                res = f - s;
                break;
            case "*":
                res = f * s;
                break;
            case "/":
                res = f / s;
                break;
            default:
                throw new RuntimeException("运算符有误");
        }
        return res;
    }
}
