import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] num = new int[3];
        // 세 변의 길이 입력
        num[0] = sc.nextInt();
        num[1] = sc.nextInt();
        num[2] = sc.nextInt();

        // 결과 변수
        int result = 0;

        // 오름차순 정렬
        Arrays.sort(num);

        // 가장 긴 변의 길이가 다른 두 변의 합보다 크거나 같을 떄
        if(num[0] + num[1] <= num[2]) {
            int temp = num[0] + num[1];
            result = temp + (temp - 1);
            System.out.println(result);
        } else {
            result = num[0] + num[1] + num[2];
            System.out.println(result);
        }
    }
}