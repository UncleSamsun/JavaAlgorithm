import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // X번째 입력
        int X = sc.nextInt();
        // 이전 라인까지의 개수 총합
        int sum = 0;
        // 현재 라인의 개수
        int lineSum = 1;

        while (true) {
            // 입력받은 X가 현재 번째에 있는지 확인
            if(X <= sum + lineSum) {
                // 현재 라인이 홀수이면
                if(lineSum % 2 == 1) {
                    // 분모는 큰수 -> 작은수
                    int head = lineSum - (X - sum - 1);
                    // 분자는 작은수 -> 큰수
                    int foot = X - sum;
                    // 출력
                    System.out.println(head + "/" + foot);
                    break;
                }
                // 현재 라인이 짝수이면
                else {
                    // 분모는 작은수 -> 큰수
                    int head = X - sum;
                    // 분자는 큰수 -> 작은수
                    int foot = lineSum - (X - sum - 1);
                    // 출력
                    System.out.println(head + "/" + foot);
                    break;
                }
            } else {
                sum += lineSum;
                lineSum++;
            }
        }
    }
}