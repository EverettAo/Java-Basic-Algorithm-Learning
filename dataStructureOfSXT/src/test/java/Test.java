import java.util.Date;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}

public class Test {
    public static void main(String[] args) {
/*        Date date = new Date();
        fun(date);
        System.out.println(date);
        String fakeFileName = "abc.jpg.avi";

        System.out.println(fakeFileName.matches("^.*(png|jpg|gif|jpeg)$"));

        String[] split = fakeFileName.split(".");
        for (String str : split
        ) {
            System.out.println(str);
        }
        System.out.println(fakeFileName.substring(
                fakeFileName.lastIndexOf(".")));*/
//        String[] split = fakeFileName.split(".");
//        System.out.println(split.length);
//        System.out.println(split[split.length - 1]);


        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        one.next = two;
        two.next = three;
        System.out.println(one);
        changInnerNode(one);
        System.out.println(one);
    }

    public static void fun(Date date) {
        date = null;
    }

    public static void changInnerNode(Node head) {
//        head.next.next = null;

    }
}
