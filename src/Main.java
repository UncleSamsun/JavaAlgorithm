import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 개수 N
        int N = sc.nextInt();
        // 각 포인트 배열 선언
        int[][] points = new int[2][N];
        // x좌표, y좌표의 최솟값, 최댓값
        int xMin = 100001;
        int yMin = 100001;
        int xMax = 0;
        int yMax = 0;

        // N 만큼 반복
        for (int i = 0; i < N; i++) {
            points[0][i] = sc.nextInt();
            points[1][i] = sc.nextInt();

            // 각 x좌표, y좌표의 최대/최소 값 저장
            if(xMin > points[0][i]) {
                xMin = points[0][i];
            }
            if(xMax < points[0][i]) {
                xMax = points[0][i];
            }
            if(yMin > points[1][i]) {
                yMin = points[1][i];
            }
            if(yMax < points[1][i]) {
                yMax = points[1][i];
            }
        }

        // 가로 세로 길이 저장
        int length = xMax - xMin;
        int height = yMax - yMin;

        // 면적 출력
        System.out.println(length * height);
    }
}