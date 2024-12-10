import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 반복 개수
        int n = sc.nextInt();
        // 점의 개수
        int point = 2;

        // 반복했을 때 가로 또는 세로 점의 개수
        for (int i = 0; i < n; i++) {
            point = (point * 2) - 1;
        }
        // 전체 점의 개수
        point *= point;

        // 출력
        System.out.println(point);
    }
}
