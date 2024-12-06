import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 배열크기 입력
        int N = sc.nextInt();
        int M = sc.nextInt();

        // 2차원 A배열, B배열 선언
        int[][] arrA = new int[N][M];
        int[][] arrB = new int[N][M];

        // A배열 입력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arrA[i][j] = sc.nextInt();
            }
        }

        // B배열 입력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arrB[i][j] = sc.nextInt();
            }
        }

        // A배열 + B배열 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(arrA[i][j] + arrB[i][j] + " ");
            }
            System.out.println();
        }

    }
}
