import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // M입력
        int M = sc.nextInt();
        // N입력
        int N = sc.nextInt();
        // 소수의 합
        int sum = 0;
        // 소수 중 최솟값
        int min = 0;

        for (int i = M; i <= N; i++) {
            // i가 1이면 continue
            if (i == 1) {
                continue;
            }

            // flag
            boolean flag = true;

            // i의 소수
            for (int j = 2; j < i; j++) {
                // 소수가 아니라면
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }

            // 소수라면
            if (flag) {
                // 소수의 합
                sum += i;

                // 최솟값이 없다면 최솟값 입력
                if (min == 0) {
                    min = i;
                }
            }
        }

        // 소수가 있다면
        if(sum != 0){
            System.out.println(sum);
            System.out.println(min);
        }
        // 소수가 없다면
        else {
            System.out.println(-1);
        }
    }
}