public class isPrimes {
    public static void main(String[] args) {
        /*
         100以内的质数 给一系列数一个是否是素数的属性 boolean isPrime 默认为true
         把那些是整数的倍数的数属性设置为 false
         输出属性为 true的余下的数
          */
        boolean[] isPrime = new boolean[100];
        for (int i = 0; i < 100; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]){
                for (int j = 2;i*j<100; j++) {
                    isPrime[i*j] = false;
                }
            }
        }

        for (int i = 2; i < 100; i++) {
            if (isPrime[i])
                System.out.print(i+" ");
        }
    }
}
