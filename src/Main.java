import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            // 수 입력
            int N = sc.nextInt();
            // 입력이 -1 이라면 중단
            if(N == -1) {
                break;
            }

            // 카운트 변수
            int cnt = 0;
            // 약수의 합
            int sum = 0;
            // 약수 배열 선언
            int[] div = new int[N];

            // N의 약수 찾기
            for(int i = 1; i < N; i++) {
                if(N % i == 0) {
                    div[cnt] = i;
                    sum += i;
                    cnt++;
                }
            }

            // N이 완전수인지 확인
            if (sum == N) {
                System.out.print(N + " = ");
                for (int i = 0; i < cnt; i++) {
                    System.out.print(div[i]);
                    if (i != cnt - 1) {
                        System.out.print(" + ");
                    }
                }
                System.out.println();
            } else {
                System.out.println(N + " is NOT perfect.");
            }
        }
    }
}