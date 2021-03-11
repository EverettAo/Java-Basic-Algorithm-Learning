package multiarray;

import java.util.Arrays;

/**
 * 问题描述：
 * 数组A、B：长度为n：0-(n-1)，根据A算B
 * B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]
 * 规定B[0] = A[1] * A[2] * ... * A[n-1].    B[n-1] = A[0] * A[1] * ... * A[n-2]
 * 对于A长度为1的情况，B无意义，故而无法构建，因此该情况不会存在
 */
public class Solutions {
    public static void main(String[] args) {
        int[] A = {0, 0, 40, 0, 0};
        System.out.println(Arrays.toString(solution_1(A)));
    }

    /**
     * 暴力法
     */
    public static int[] solution_1(int[] A) {
        if (A == null || A.length == 1) {
            return A;
        }
        int[] B = new int[A.length];
        int multi = 1;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (i != 0 && j != i) {
                    multi *= A[j];
                }
                if (i == 0) {
                    multi *= A[j];
                }
            }
            B[i] = multi;
            multi = 1;
        }
        return B;
    }

    /**
     * 把A[i]、B[i]看成一张表
     *
     * @param A
     * @return
     */
    public static int[] solution_2(int[] A) {
        if (A == null || A.length == 1) {
            return A;
        }
        int[] B = new int[A.length];
        B[0] = 1;
        for (int i = 1; i < A.length; i++) {    // 从左算到右
            B[i] = B[i - 1] * A[i - 1];
        }
        int t = 1;
        for (int i = A.length - 2; i >= 0; i--) {   // 从右算到左
            t *= A[i + 1];
            B[i] *= t;
        }
        return B;
    }
}
