package fibnacci;
/**
 * @author Everett
 * @date 2021-03-04 9:31 PM
 */

/**
 * @author Everett
 * @version 1.0
 * @description TODO
 * @date 3/4/2021 9:31 PM
 */
public class Solutions {
    public static void main(String[] args) {
        System.out.println(solution_2(4));
    }

    /**
     * 递归
     *
     * @param n
     * @return
     * @ac
     */
    public static int solution_1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return solution_1(n - 1) + solution_1(n - 2);
    }

    /**
     * 非递归
     *
     * @param n
     * @return
     * @ac
     */
    public static int solution_2(int n) {
        int first = 0, second = 1;
        if (n == 0) {
            return first;
        }
        if (n == 1) {
            return second;
        }
        int count = 1;
        while (count++ != n) {
            second = second + first;
            first = second - first;
        }
        return second;
    }
}
