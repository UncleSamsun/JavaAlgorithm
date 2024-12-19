import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 정수 N 입력
        int N = sc.nextInt();

        // N이 소인수분해 될때까지 반복
        for (int i = 2; i <= N; i++) {
            while (N % i == 0) {
                System.out.println(i);
                N /= i;
            }
        }
    }
}