package firstonce;
/**
 * @author Everett
 * @date 2021-03-06 9:54 PM
 */

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Everett
 * @version 1.0
 * @description TODO
 * @date 3/6/2021 9:54 PM
 */
public class Solutions {
    public static void main(String[] args) {
        System.out.println(new Solutions().solution_2("NXWtnzyoHoBhUJaPauJaAitLWNMlkKwDYbbigdMMaYfkVPhGZcrEwp"));
    }

    public int solution_1(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            Integer value = map.getOrDefault(c, 0);
            map.put(c, ++value);
        }
        Integer value = null;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            value = entry.getValue();
            if (value == 1) {
                return str.indexOf(entry.getKey());
            }
        }
        return -1;
    }

    private static int solution_2(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        int[] ints = new int[52];
        for (char c : str.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                ints[c - 'A']++;
            } else {
                ints[c - 'a' + 26]++;
            }
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ((c >= 'A' && c <= 'Z' && ints[c - 'A'] == 1) || (c >= 'a' && c <= 'z' && ints[c - 'a' + 26] == 1)) {
                return i;
            }
        }
        return -1;
    }
}
