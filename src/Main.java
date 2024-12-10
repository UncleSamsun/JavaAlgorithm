import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 10진수 입력
        int num = sc.nextInt();
        // 진법 입력
        int base = sc.nextInt();
        // 출력 스트링
        StringBuilder str = new StringBuilder();
        // 반복문 제어용 boolean
        boolean flag = true;

        // 숫자를 단어로 변환
        while (flag) {
            // 10진수를 입력받은 진법으로 나눈 나머지 계산
            int mod = num % base;

            // 나머지 값에 따라 10진수를 단어로 변환
            if (mod >= 10) {
                str.append((char) ('A' + mod - 10));
            } else {
                str.append(mod);
            }
            // 진법으로 나눈 몫 계산
            num /= base;

            // 더이상 나눌게 없으면 반복문 종료
            if (num == 0) {
                flag = false;
            }
        }
        System.out.println(str.reverse().toString());
    }
}
