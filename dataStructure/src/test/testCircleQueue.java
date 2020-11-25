import com.atguigu.queue.CircleQueue;

import java.util.Scanner;

public class testCircleQueue {
    public static void main(String[] args) {
        System.out.println("请输入队列大小：");
        Scanner scanner = new Scanner(System.in);
        int capacity = scanner.nextInt();
        CircleQueue circleQueue = new CircleQueue(capacity);
        char key;
        boolean loop = true;
        while (loop) {
            System.out.println("s(show)：显示队列");
            System.out.println("e(exit)：退出程序");
            System.out.println("a(add)：添加数据到队列");
            System.out.println("g(get)：从队列中取数据");
            System.out.println("h(head)：查看队列头的数据");
            System.out.println("m(maxSize)：查看队列最大容量");
            System.out.println("c(currentSize)：查看队列当前容量");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    circleQueue.showAllElement();
                    break;
                case 'e':
                    loop = false;
                    break;
                case 'a':
                    System.out.println("请输入：");
                    int num = scanner.nextInt();
                    try {
                        circleQueue.addElement(num);
                    } catch (RuntimeException re) {
                        System.out.println(re.getMessage());
                        ;
                    }
                    break;
                case 'g':
                    System.out.println("队首元素为：");
                    try {
                        System.out.println(circleQueue.getElement());
                    } catch (RuntimeException re) {
                        System.out.println(re.getMessage());
                    }
                    break;
                case 'h':
                    System.out.println("队首元素为：");
                    try {
                        System.out.println(circleQueue.showHead());
                    } catch (RuntimeException re) {
                        System.out.println(re.getMessage());
                    }
                    break;
                case 'm':
                    System.out.println(circleQueue.getCapacity());
                    break;
                case 'c':
                    System.out.println(circleQueue.size());
                default:
                    break;
            }
        }
    }
}
