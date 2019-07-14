public class Primes {
    public static void main(String[] args) {
        // 求前50个质数
        int[] primes = new int[50];
        primes[0] = 2;
        int cnt = 1;
        MAIN_LOOP:
        for (int x = 3;cnt<primes.length; x++) {
            for (int j = 0; j < cnt; j++) {
                if (x%primes[j] == 0){
                    continue MAIN_LOOP;
                }
                primes[cnt] = x;
            }
            cnt++;
        }
        for (int prime : primes) {
            System.out.print(prime+" ");
        }
    }
}
