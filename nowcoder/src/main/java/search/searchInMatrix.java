package search;

public class searchInMatrix {
    public static void main(String[] args) {
        int[][] array = new int[4][4];
        int counter = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                array[i][j] = counter++;
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println(Find(5, array));
    }

    public static boolean Find(int target, int[][] array) {
       /* for (int row = 0; row < array.length; ) {
            for (int col = array[0].length - 1; col >= 0; ) {
                if (array[row][col] == target) {
                    return true;
                } else if (array[row][col] > target) {
                    if (col == 0) {
                        return false;
                    }
                    col--;
                } else if (array[row][col] < target) {
                    if (row == array.length - 1) {
                        return false;
                    }
                    row++;
                }
            }
        }*/
        if (array.length == 0 || array[0].length == 0) {
            return false;
        }
        int row = 0, col = array[0].length - 1;
        while (array[row][col] != target) {
            if (array[row][col] < target) {
                if (row != array.length - 1) {
                    row++;
                } else {
                    return false;
                }
            }
            if (array[row][col] > target) {
                if (col != 0) {
                    col--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
