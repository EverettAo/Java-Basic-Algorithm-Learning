package baseexponent;
/**
 * @author Everett
 * @date 2021-03-04 11:37 PM
 */

/**
 * @author Everett
 * @version 1.0
 * @description TODO
 * @date 3/4/2021 11:37 PM
 */
public class Solutions {
    public static void main(String[] args) {
        System.out.println(solution_1(2, -3));
    }

    private static double solution_1(double base, int exponent) {
        if (base == 0) {
            return 0;
        }
        if (exponent == 0) {
            return 1;
        }
        int flag = exponent > 0 ? 1 : -1;
        exponent = exponent > 0 ? exponent : -exponent;
        double res = 1.0;
        while (exponent-- != 0) {
            res *= base;
        }
        if (flag == -1) {
            res = 1 / res;
        }
        return res;
    }
}
