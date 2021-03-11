package minnumberInrotatearray;
/**
 * @author Everett
 * @date 2021-03-04 9:41 PM
 */

/**
 * @author Everett
 * @version 1.0
 * @description TODO
 * @date 3/4/2021 9:41 PM
 */
public class Solutions {
    public static void main(String[] args) {
        int[] array = new int[]{5, 1, 2, 3, 3, 4, 5};
        System.out.println(solution_1(array));
        System.out.println(-1 / 2);
    }

    /**
     * 二分查找
     *
     * @param array
     * @return
     */
    public static int solution_1(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int low = 0;
        int mid;
        int high = array.length - 1;
        while (low < high) {
            mid = (low + high) >> 1;
            if (array[mid] > array[high]) {
                low = mid + 1;
            } else if (array[mid] == array[high]) {
                high--;
            } else {
                high = mid;
            }
        }
        return array[high];
    }

    /**
     * 暴力法
     *
     * @param array
     * @return
     */
    public static int solution_2(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int s = array[0];
        for (int i = 1; i < array.length; i++) {
            if (s > array[i]) {
                s = array[i];
                break;
            }
        }
        return s;
    }

}
