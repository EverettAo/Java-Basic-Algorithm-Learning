package blankreplace;
/**
 * @author Everett
 * @date 2021-03-03 12:14 AM
 */

/**
 * @author Everett
 * @version 1.0
 * @description 把字符串中的空格替换成%20
 * @date 3/3/2021 12:14 AM
 */
public class Solutions {
    public static void main(String[] args) {
        String str = "but if you wanna cry";
        System.out.println(solution_1(str));
    }

    /**
     * 因为是一个字符替换成三个符号，所以要开三倍的长度
     *
     * @param s
     */
    public static String solution_1(String s) {
        int n = s.length();
        char[] chars = new char[n * 3];
        int index = 0;
        char c;
        for (int i = 0; i < n; i++) {
            c = s.charAt(i);
            if (c == ' ') {
                chars[index++] = '%';
                chars[index++] = '2';
                chars[index++] = '0';
            } else {
                chars[index++] = c;
            }
        }
        return new String(chars, 0, index);
    }
}
