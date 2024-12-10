import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // String 입력
        String str = sc.next();
        // 진법 입력
        int base = sc.nextInt();
        // 합계
        int sum = 0;
        int tmp = 1;

        // 진법 변환
        for (int i = str.length() - 1; i >= 0; i--) {
            // 한 단어씩 계산
            char c = str.charAt(i);
            // 단어를 숫자로 변환
            int value = 0;

            if(c >= '0' && c <= '9') {
                value = c - '0';
            } else {
                value = c - 'A' + 10;
            }

            // 진법 변환
            sum += value * tmp;
            tmp *= base;
        }
        System.out.println(sum);
    }
}
