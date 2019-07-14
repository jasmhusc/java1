package javabase_Test;

public class Test_1 {
    public static void main(String[] args) {
        int sum = 0;
        int[] arr = {1,2,3,4,5,6};
        for (int i=0;i<arr.length;i++) {
            sum+=arr[i];
        }
        System.out.println("数组的元素总和:"+sum);
    }
}
