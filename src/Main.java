import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 배열크기 입력
        int N = 9;
        int M = 9;

        // 최대값 좌표 변수 선언
        int max = 0;
        int max_x = 0;
        int max_y = 0;

        // 2차원 배열 선언
        int[][] arr = new int[N][M];

        // 배열 입력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();

                // 최대값 찾기
                if (arr[i][j] > max) {
                    max = arr[i][j];
                    max_x = i;
                    max_y = j;
                }
            }
        }

        System.out.println(max);
        System.out.println((max_x + 1) + " " + (max_y + 1));
    }
}
