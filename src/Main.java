import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 색종이의 개수
        int N = sc.nextInt();
        // 색종이의 시작 좌표
        int[][] paper = new int[N][2];
        // 색종이 영역 : 100 x 100
        boolean[][] area = new boolean[100][100];
        // 색종이 영역 개수
        int count = 0;

        // 색종이 시작 좌표 입력
        for (int i = 0; i < N; i++) {
            paper[i][0] = sc.nextInt();
            paper[i][1] = sc.nextInt();
        }

        // 색종이 영역 체크
        for (int i = 0; i < N; i++) {
            for (int j = paper[i][0]; j < paper[i][0] + 10; j++) {
                for (int k = paper[i][1]; k < paper[i][1] + 10; k++) {
                    area[j][k] = true;
                }
            }
        }

        // 색종이 영역 개수 확인
        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {
                if(area[i][j]) {
                    count++;
                }
            }
        }
        System.out.println(count);

    }
}
