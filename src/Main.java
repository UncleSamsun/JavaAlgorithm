import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 쿼터, 다임, 니켈, 페니 상수 정의
        final int Quater = 25;
        final int Dime = 10;
        final int Nickel = 5;
        final int Penny = 1;

        // 테스트케이스 수
        int TC = sc.nextInt();

        // 테스트 케이스 별 입력 및 거스름돈 계산 출력
        for (int i = 0; i < TC; i++) {
            int Cash = sc.nextInt();

            int QuaterCnt = Cash / Quater;
            Cash %= Quater;

            int DimeCnt = Cash / Dime;
            Cash %= Dime;

            int NickelCnt = Cash / Nickel;
            Cash %= Nickel;

            int PennyCnt = Cash / Penny;

            System.out.println(QuaterCnt + " " + DimeCnt + " " + NickelCnt + " " + PennyCnt);
        }
    }
}
