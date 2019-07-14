import java.util.Scanner;

public class JJJ {
    public static void main(String[] args) {
//        demo1();
//        demo2();
//        demo3();
        demo4();
    }

    private static void demo4() {
        String ss = "ss";
        String dd = new String();
        System.out.println(dd.getClass().isInstance(ss));
    }

    private static void demo1() {
        int i = 4;
        int j = 5;
        float b = ((float) i)/j;
        System.out.println(b);
    }

    private static void demo2() {
        int len = 5;
        for (int i = 0; i < 10; i++) {
            double v = Math.random();
            System.out.println(v+" "+(int)(v*len));
        }
    }

    private static void demo3() {
        System.out.println("请输入要比较的两个整数：");
        int a = new Scanner(System.in).nextInt();
        int b = new Scanner(System.in).nextInt();
//        int max = a>b ? a:b;
        if (a>b) {
            System.out.println("较大值为："+a);
        } else {
            System.out.println("较大值为："+b);
        }
    }
}
