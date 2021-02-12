import java.io.PrintStream;

/**
 * @author Everett
 * @version 1.0
 * @description TODO
 * @date 2/5/2021 2:51 PM
 */
public class PrinlnTest {
    public static void main(String[] args) {
        int a = 10, b = 10;
        method(a, b);
        System.out.println("a=" + a);
        System.out.println("b=" + b);
        char[] cs = new char[]{'a','b','c','d','5'};
        System.out.println(cs);
    }

    public static void method(int a, int b) {
        PrintStream ps = new PrintStream(System.out) {
            @Override
            public void println(String x) {
                if ("a=10".equals(x)) {
                    x = "a=100";
                } else if ("b=10".equals(x)) {
                    x = "b=200";
                }
                super.println(x);
            }
        };
        System.setOut(ps);
    }
}
