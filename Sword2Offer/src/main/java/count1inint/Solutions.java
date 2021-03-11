package count1inint;
/**
 * @author Everett
 * @date 2021-03-04 11:22 PM
 */

/**
 * @author Everett
 * @version 1.0
 * @description TODO
 * @date 3/4/2021 11:22 PM
 */
public class Solutions {
    public static void main(String[] args) {
        System.out.println(solution_1(10));
    }

    private static int solution_1(int n) {
        int mask = 1, count = 0;
        for (int i = 0; i < 32; i++) {
            if ((mask & n) == 1) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }
}
