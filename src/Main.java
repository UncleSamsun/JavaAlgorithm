import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 숫자 N 입력
        int N = sc.nextInt();
        // 숫자 K 입력
        int K = sc.nextInt();
        // count 변수
        int count = 0;
        int i = 0;

        // 약수 배열 선언
        int[] divisor = new int[N];

        while (count < N) {
            count++;
            // K의 배수인지 확인
            if (N % count == 0) {
                divisor[i] = count;
                i++;
            }
        }
        System.out.println(divisor[K - 1]);
    }
}