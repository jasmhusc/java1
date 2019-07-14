import java.util.Random;
import java.util.Scanner;

public class RandomTest {
    public static void main(String[] args) {

        int num = new Random().nextInt(100);
//        int num = (int) (Math.random() * 100);
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入猜的数字：");
        int guessNum = sc.nextInt();

        // while(true)  ---break;
        while (num != guessNum){
            if (num<guessNum){
                System.out.println("猜大了！");
                guessNum = sc.nextInt();
            }
            if (num>guessNum) {
                System.out.println("猜小了！");
                guessNum = sc.nextInt();
            }
        }
        System.out.println("恭喜您，猜中了！");
    }
}
