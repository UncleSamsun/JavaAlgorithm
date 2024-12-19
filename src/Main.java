import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 직사각형 가로 세로 입력
        int A = sc.nextInt();
        int B = sc.nextInt();

        // 직사각형 넓이 출력
        System.out.println(A * B);
    }
}