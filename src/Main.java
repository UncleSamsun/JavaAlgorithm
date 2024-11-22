import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // n 입력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 공백과 별 개수를 카운트하기 위한 변수 선언
        int cnt1 = 1;
        int cnt2 = 1;

        // 공백은 줄어들고 별은 늘어나는 패턴
        for (int i = 0; i < n; i++)
        {
            // cnt1이 한줄 채워질때마다 1씩 늘어남
            // 초기 j에 n - cnt1 을 함으로서 초기값이 작아지게 됨
            // 결과적으로 공백 개수가 1씩 점점 작아짐
            for (int j = (n - cnt1); j > 0; j--)
            {
                System.out.print(" ");
            }

            // cnt2의 개수가 한줄이 지날때마다 2씩 증가함
            // 처음엔 별 1개, 이후엔 3, 5, 7 ... 2씩 증가
            for (int j = 0; j < cnt2; j++)
            {
                System.out.print("*");
            }

            cnt1++;
            cnt2 += 2;

            // 한줄 채우고 다음줄 넘기기
            System.out.println();
        }

        // 한줄이 다 별인 상태에서 점점 별의 개수가 작아지게 하기 위해
        // 공백 1개, 별의 개수가 2개 적게 초기화
        cnt1 = n - 1;
        cnt2 = 2 * n - 3;

        // 첫번째 for문과 반대로 동작 -> 공백 1씩 증가, 별 2씩 감소
        for (int i = 0; i < n-1; i++)
        {
            for (int j = (n - cnt1); j > 0; j--)
            {
                System.out.print(" ");
            }
            for (int j = 0; j < cnt2; j++)
            {
                System.out.print("*");
            }
            cnt1--;
            cnt2 -= 2;
            System.out.println();
        }
    }
}
