package findrepeatednum;
/**
 * @author Everett
 * @date 2021-02-24 9:55 PM
 */

import java.util.HashSet;
import java.util.Set;

/**
 * @author Everett
 * @version 1.0
 * @description TODO
 * @date 2/24/2021 9:55 PM
 */
public class Solutions {
    public static void main(String[] args) {
        // 数组中值为0-数组长度减1
        int[] arr = new int[]{6, 3, 2, 0, 2, 5, 0};
//        System.out.println(Solution.solution_1(arr));
//        System.out.println(Solution.solution_3(arr));
    }
}

class Solution {
    /**
     * 利用set
     * 知识点：
     * 1. set的add方法返回值是boolean，表示是否添加成功
     * 2. set是无序的，不能添加重复值
     *
     * @ac
     */
    public static int solution_1(int[] numbers) {
        int res = -1;
        Set<Integer> set = new HashSet<Integer>();
        for (int num : numbers) {
            if (!set.add(num)) {
                res = num;
                break;
            }
        }
        return res;
    }

    /**
     * @ac
     */
    public static int solution_3(int[] arr) {
        boolean[] booleans = new boolean[arr.length];
        for (int n : arr) {
            if (booleans[n] == false) {
                booleans[n] = true;
            } else {
                return n;
            }
        }
        return -1;
    }
}
