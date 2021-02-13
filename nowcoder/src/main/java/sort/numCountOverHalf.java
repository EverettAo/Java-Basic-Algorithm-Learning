package sort;

public class numCountOverHalf {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 2, 4, 2, 5, 2, 3, 2, 2};
        System.out.println(MoreThanHalfNum_Solution(array));
    }

    public static int MoreThanHalfNum_Solution(int[] array) {
        int count = 0, num = array[0];
        for (int i = 0; i < array.length; i++) {
            if (count == 0) {
                num = array[i];
                count++;
            } else {
                if (array[i] == num) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        count = 0;
        for (int i = 0; i < array.length; i++) {
            if (num == array[i]) {
                count++;
            } else {
                count--;
            }
        }
        if (count > 0) {
            return num;
        } else {
            return 0;
        }
    }
}
