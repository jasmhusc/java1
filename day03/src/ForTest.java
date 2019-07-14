public class ForTest {
    public static void main(String[] args) {
        // 水仙花数
        int count=0;
        for (int i = 100; i < 1000; i++) {
            if ((Math.pow(i%10,3)+Math.pow(i/10%10,3)+Math.pow(i/100,3)) == i) {
                System.out.println(i);
                count++;
            }
        }
        System.out.println("1000以内水仙花数共有："+count+"个");
    }
}
