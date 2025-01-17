import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int[] num = new int[3];
            // 세 변의 길이 입력
            num[0] = sc.nextInt();
            num[1] = sc.nextInt();
            num[2] = sc.nextInt();

            // 값이 모두 0일때
            if (num[0] == 0 && num[1] == 0 && num[2] == 0) {
                break;
            }

            Arrays.sort(num);

            // 세 변의 길이가 모두 같을 떄
            if (num[0] == num[1] && num[1] == num[2]) {
                System.out.println("Equilateral");
            }
            // 가장 긴 변이 다른 두변의 합보다 크거나 같을 때
            else if (num[2] >= num[0] + num[1]) {
                System.out.println("Invalid");
            }
            // 두 변의 길이가 같을 때
            else if (num[2] == num[1] || num[1] == num[0]) {
                System.out.println("Isosceles");
            }
            // 그 외 정상적인 삼각형
            else {
                System.out.println("Scalene");
            }
        }
    }
}