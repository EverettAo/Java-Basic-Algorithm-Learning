import com.atguigu.mstack.StackCaculator.TemplateNode;
import com.atguigu.mstack.StackCaculator.TemplateStack;

public class testTemplateStack {
    public static void main(String[] args) {
        TemplateStack<Integer> stack = new TemplateStack<>();
        stack.push(100);
        System.out.println(stack.isEmpty());
        System.out.println(stack.size());
        System.out.println(stack.pop());
        double d = 2;
        System.out.println(d);
        Double dd = new Double(2);
        System.out.println(dd);
    }
}
