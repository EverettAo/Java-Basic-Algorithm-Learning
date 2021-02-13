package search;

public class countOne {
    public static void main(String[] args) {
        System.out.println(3/10);
        System.out.println(NumberOf1Between1AndN_Solution(13));
    }

    public static int NumberOf1Between1AndN_Solution(int n) {
        int counter = 0;
        for (int i = 1; i <= n; i++) {
            int j = i;
            while (j != 0) {
                if (j % 10 == 1) {
                    counter++;
                }
                j = j / 10;
            }
        }
        return counter;
    }
}
