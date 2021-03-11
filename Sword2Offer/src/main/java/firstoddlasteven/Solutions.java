package firstoddlasteven;
/**
 * @author Everett
 * @date 2021-03-05 10:58 PM
 */

/**
 * @author Everett
 * @version 1.0
 * @description TODO
 * @date 3/5/2021 10:58 PM
 */
public class Solutions {
    public static void main(String[] args) {

    }

    /**
     * 冒泡排序(随便一种稳定的排序即可)：左边偶数右边奇数，交换
     *
     * @param array
     * @return
     */
    private int[] solution_1(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        int temp;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; i < array.length - j - 1; j++) {
                if ((array[j] & 1) == 0 && (array[j + 1] & 1) == 1) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    /**
     * 先找偶数，再找奇数
     *
     * @param array
     * @return
     */
    private static int[] solution_2(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        int j;
        int temp;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 0) {  // 找到偶数，到其后面去找奇数
                for (j = i; j < array.length; j++) {
                    if ((array[j] & 1) == 1) {  // 找到奇数，交换
                        temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                        break;
                    }
                }
            }
        }
        return array;
    }
}
