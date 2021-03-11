package findinsorted2darray;
/**
 * @author Everett
 * @date 2021-03-02 11:58 PM
 */

/**
 * @author Everett
 * @version 1.0
 * @description 二维数组，左小右大，上小下大，在里面进行查找
 * eg：
 * [1,3,5]
 * [2,4,6]
 * [3,6,9]
 * @date 3/2/2021 11:58 PM
 */
public class Solutions {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        System.out.println(solution_1(arr, 2));
    }

    /**
     * 从一个角开始查找，这个角满足：进行比较后的查找方向只能有一个，比如：右上角，
     * 如果当前元素比target小，只能往下找
     * 如果当前元素比target大，只能往左找
     *
     * @param array
     * @param target
     */
    public static boolean solution_1(int[][] array, int target) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }
        int row = array.length;
        int col = array[0].length;
        int i = 0, j = col - 1;
        while (i < row && j >= 0) {
            if (array[i][j] > target) {
                j--;
            } else if (array[i][j] < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }
}
