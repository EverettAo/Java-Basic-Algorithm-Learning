package sort;

import java.util.ArrayList;

public class findMedianInDataStream {
    private static ArrayList<Integer> buffer = new ArrayList<Integer>();
    private static Integer[] integers;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            buffer.add((int) (Math.random() * 10));
        }
        integers = new Integer[buffer.size()];
        buffer.toArray(integers);
        for (Integer it : integers) {
            System.out.printf(it + "\t");
        }
        System.out.println();
        System.out.println(GetMedian());
        for (Integer it : integers) {
            System.out.printf(it + "\t");
        }
    }

    public static void Insert(Integer num) {
        buffer.add(num);
    }

    public static Double GetMedian() {
        int len = integers.length;
        quickSort(integers, 0, len - 1);
        if (len % 2 == 1) {
            return integers[len / 2] * 1.0;
        } else {
            return (integers[len / 2 - 1] + integers[len / 2]) / 2.0;
        }
    }

    public static void quickSort(Integer[] buffer, int low, int high) {
        if (low < high) {
            int pivot = partition(buffer, low, high);
            quickSort(buffer, low, pivot - 1);
            quickSort(buffer, pivot + 1, high);
        }
    }

    public static Integer partition(Integer[] buffer, int low, int high) {
        Integer pivot = buffer[low];
        while (low < high) {
            while (low < high && buffer[high] >= pivot) {
                high--;
            }
            buffer[low] = buffer[high];
            while (low < high && buffer[low] <= pivot) {
                low++;
            }
            buffer[high] = buffer[low];
        }
        buffer[low] = pivot;
        return low;
    }
}
