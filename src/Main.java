import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 세 각 입력
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        // 세각이 모두 60 일때
        if (A == 60 && B == 60 && C == 60) {
            System.out.println("Equilateral");
        }
        // 세각의 합이 180일때
        else if (A + B + C == 180) {
            // 두 각이 같을 경우
            if (A == B || B == C || C == A) {
                System.out.println("Isosceles");
            }
            // 모든 각이 다를 경우
            else {
                System.out.println("Scalene");
            }
        }
        // 그 외 모든 상황
        else {
            System.out.println("Error");
        }
    }
}