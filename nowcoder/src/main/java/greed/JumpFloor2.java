package greed;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * demo: 3, 4
 * 题目分析：
 * f(1)=1
 * f(2)=f(2-1)+1=f(1)+1=2
 * f(3)=f(3-1)+f(3-2)+1=f(1)+f(2)+1=4
 * f(4)=f(4-1)+f(4-2)+f(4-3)+1=f(1)+f(2)+f(3)+1=8
 * f(5)=f(5-1)+f(5-2)+f(5-3)+f(5-4)+1=f(1)+f(2)+f(3)+f(4)+1=16
 * 小结：f(n)=2**(n-1)
 */
public class JumpFloor2 {
    public static void main(String[] args) {
        System.out.println(JumpFloorII(4));
    }

    public static int JumpFloorII(int target) {
        return (int)Math.pow(2, target - 1);
    }
}
