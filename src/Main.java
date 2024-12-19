import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N개의 수
        int N = sc.nextInt();
        // 개수 카운트
        int count = 0;

        // N 만큼 반복
        for (int i = 0; i < N; i++) {
            // flag
            boolean flag = true;
            // 입력
            int num = sc.nextInt();

            // 입력된 수가 1이 아닐때
            if (num != 1){
                // 1과 자신을 제외한 수로 나머지를 구하기
                for (int j = 2; j < num; j++) {
                    // 1과 자신을 제외한 수 중에 약수가 있다면
                    if (num % j == 0) {
                        flag = false;
                    }
                }
                // 소수라면
                if (flag) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}