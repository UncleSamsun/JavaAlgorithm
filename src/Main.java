import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 반복
        while (true) {
            // 첫번째 수 입력
            int num1 = sc.nextInt();

            // 두번째 수 입력
            int num2 = sc.nextInt();

            // num1 과 num2가 둘다 0 일때 종료
            if (num1 == 0 && num2 == 0) {
                break;
            }
            // 첫번째 숫자가 두번째 숫자의 약수인지
            if(num2 % num1 == 0) {
                System.out.println("factor");
            }
            // 첫번째 숫자가 두번째 숫자의 배수인지
            else if (num1 % num2 == 0) {
                System.out.println("multiple");
            }
            // 둘다 아닌지
            else {
                System.out.println("neither");
            }
        }
    }
}