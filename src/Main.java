import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 방 번호
        double n = sc.nextDouble();
        // 가장자리 방 개수 계산용
        double m = 6;
        // 카운트 변수
        int count = 1;

        // n이 1일때를 생각하자..
        while (n > 1) {
            n -= m;
            count++;

            // 방의 개수는 가장자리로 갈수록 6개씩 증가함
            m += 6;
        }

        System.out.println(count);
    }
}
