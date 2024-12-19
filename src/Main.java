import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 각 포인트를 저장할 배열 생성
        int[][] points = new int[2][3];
        // 값 저장
        for (int i = 0; i < 3; i++) {
            points[0][i] = sc.nextInt();
            points[1][i] = sc.nextInt();
        }

        // 이 문제의 요점은 x좌표 중에서 중복되지 않은 한 좌표와
        // y좌표 중에서 중복되지 않은 한 좌표를 출력하는 심이다.
        // 따라서 중복된 x좌표를 찾고 남은 한 좌표를 출력하는 것이 핵
        if (points[0][0] == points[0][1]) {
            System.out.print(points[0][2]);
        }else if(points[0][0] == points[0][2]) {
            System.out.print(points[0][1]);
        }else {
            System.out.print(points[0][0]);
        }

        System.out.print(" ");
        if (points[1][0] == points[1][1]) {
            System.out.print(points[1][2]);
        }else if(points[1][0] == points[1][2]) {
            System.out.print(points[1][1]);
        }else {
            System.out.print(points[1][0]);
        }
    }
}