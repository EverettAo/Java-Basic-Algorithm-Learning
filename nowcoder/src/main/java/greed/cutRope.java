package greed;

/**
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段
 * （m、n都是整数，n>1并且m>1，m<=n），
 * 每段绳子的长度记为k[1],...,k[m]。请问k[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * input:输入一个数n，意义见题面。（2 <= n <= 60）
 * demo: input:8, return 18
 * <p>
 * 分析：
 * 8：2，3，3
 * 2： 1，1=1                 %3=2
 * 3： 2，1=2                 %3=0
 * 4： 2，2=4                 %3=1
 * 5： 3，2=6                 %3=2
 * 6： 3，3=9                 %3=0
 * 7： 3，4=12                %3=1
 * 8： 3，3，2=18             %3=2
 * 9： 3，3，3=27；           %3=0
 * 10：3，3，4=36；
 * 11：3，3，3，2=54；
 * 12：3，3，3，3=81；
 * 13：3，3，3，4=108；
 * 14：3，3，3，3，2=162；
 * 15：3，3，3，3，3=243
 * <p>
 * 小结3**a*b, where 2<=b<=4
 * if(target%3)==0; 3**(target/3)
 */
public class cutRope {
    public static void main(String[] args) {
        System.out.println(cutRope(11));
    }

    public static int cutRope(int target) {
        if (target == 2) {
            return 1;
        } else if (target == 3) {
            return 2;
        } else if (target == 4) {
            return 4;
        } else {
            int mod = target % 3;
            int pow = (target - mod) / 3;
            if (mod == 0) {
                // eg:9,mod=0,pow=3
                return (int) Math.pow(3, pow - 1) * 3;
            } else if (mod == 1) {
                // eg:10,mod=1;pow=3
                return (int) Math.pow(3, pow - 1) * 4;
            } else {
                // eg:11,mod=2,pow=3
                return (int) Math.pow(3, pow) * 2;
            }
        }
    }
}
