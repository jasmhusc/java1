import java.util.ArrayList;
import java.util.Scanner;

public class AverageNumber {
    public static void main(String[] args) {
        int cnt=0;
        double sum=0;
        ArrayList<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要求取平均数的整数，-1表示结束：");
        int x = sc.nextInt();
        while (x != -1){
            list.add(x);
            sum+=x;
            cnt++;
            x=sc.nextInt();
        }

        if (cnt>0){
            double avr = sum/cnt;
            System.out.println("平均数为："+avr);
            System.out.println("比平均数大的数有：");
            for (Integer i : list) {
                if (i>avr)
                    System.out.println(i);
            }
        }
    }
}
