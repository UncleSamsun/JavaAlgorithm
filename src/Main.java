import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 정사각형 n개 입력
        // 값이 커서 long으로 선언
        long n = sc.nextLong();

        // 직사각형의 둘레 출력
        System.out.println(n * 4);
    }
}