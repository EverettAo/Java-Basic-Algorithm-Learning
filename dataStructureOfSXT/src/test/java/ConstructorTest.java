/**
 * @author Everett
 * @version 1.0
 * @description TODO
 * @date 2/5/2021 5:23 PM
 */
class Person{
    private int age;
    private String name;

    public Person() {
        System.out.println("aaaaaa....");
    }

    public Person(int age, String name) {
        this();
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
public class ConstructorTest {
    public static void main(String[] args) {
        new Person();
    }
}
