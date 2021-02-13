package sort;

import java.util.ArrayList;

public class findMedianInDataStreamInsert {
    private static ArrayList<Integer> buffer = new ArrayList<Integer>();

    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            Insert((int) (Math.random() * 10));
//        }
        Insert(5);
        Insert(2);
        Insert(3);
        for (Integer it : buffer) {
            System.out.printf(it + "\t");
        }
        System.out.println();
        System.out.println(GetMedian());
    }

    public static void Insert(Integer num) {
        if (buffer.size() == 0) {
            buffer.add(num);
        } else {
            int idx = 0;
            while (idx < buffer.size() && num > buffer.get(idx)) {
                idx++;
            }
            if (idx == 0) {
                buffer.add(0, num);
            } else if (idx == buffer.size()) {
                buffer.add(num);
            } else {
                buffer.add(idx, num);
            }
        }
    }

    public static Double GetMedian() {
        if (buffer.size() % 2 == 1) {
            return buffer.get(buffer.size() / 2) * 1.0;
        } else {
            return (buffer.get(buffer.size() / 2 - 1) + buffer.get(buffer.size() / 2)) / 2.0;
        }
    }
}
