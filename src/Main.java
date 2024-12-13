import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 낮동안 올라가는 높이
        int A = sc.nextInt();
        // 밤동안 내려오는 높이
        int B = sc.nextInt();
        // 나무막대 높이
        int V = sc.nextInt();

        // 결과
        int result = 0;

        // 정상에 올라가면 미끄러지지 않는다
        // 위의 조건떄문에 밤에 내려오는 높이를 미리 빼고 계산 진행
        result = (V - B) / (A - B);

        // 만약 위의 계산을 했을 때 남은 높이가 있다면 하루더 올라가는 것으로 계산
        if((V - B) % (A - B) != 0) {
            result++;
        }

        // 출력
        System.out.println(result);
    }
}