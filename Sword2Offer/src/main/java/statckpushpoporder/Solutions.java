package statckpushpoporder;

import java.util.Stack;

public class Solutions {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5}, B = {4, 3, 5, 1, 2};
        System.out.println(solution_1(A, B));
    }

    public static boolean solution_1(int[] pushA, int[] popA) {
        if (pushA == null) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0, j = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (j < popA.length && !stack.isEmpty() && stack.peek() == popA[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
