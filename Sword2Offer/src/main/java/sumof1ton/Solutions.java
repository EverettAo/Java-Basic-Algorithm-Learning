package sumof1ton;
/**
 * @author Everett
 * @date 2021-03-04 10:18 AM
 */

/**
 * @author Everett
 * @version 1.0
 * @description TODO
 * @date 3/4/2021 10:18 AM
 */
public class Solutions {
    public static void main(String[] args) {
        System.out.println(solution_1(5));
    }

    public static int solution_1(int n) {
        boolean x = (n > 0) && ((n += solution_1(n - 1)) > 0);
        return n;
    }
}
