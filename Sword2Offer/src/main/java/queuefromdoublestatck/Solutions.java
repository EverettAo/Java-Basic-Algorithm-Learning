package queuefromdoublestatck;
/**
 * @author Everett
 * @date 2021-03-04 9:25 PM
 */

import java.util.Stack;

/**
 * @author Everett
 * @version 1.0
 * @description TODO
 * @date 3/4/2021 9:25 PM
 */
public class Solutions {
    public static void main(String[] args) {

    }

    /**
     * 分析：
     * 进队列：先进一个栈
     * 出队列：从另一个栈取，如果另一个栈空，就把上面栈中的元素全部“倒入”另外这个栈
     *
     * @ac
     */
    static Stack<Integer> stack1 = new Stack<Integer>();
    static Stack<Integer> stack2 = new Stack<Integer>();

    public static void push(int node) {
        stack1.push(node);
    }

    public static int pop() {
        if (stack2.isEmpty() && !stack1.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
