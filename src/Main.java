import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // x, y, w, h 입력
        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        // x 축에서 더 작은 수 계산
        int disX = Math.min(x, w - x);
        // y 축에서 더 작은 수 계산
        int disY = Math.min(y, h - y);
        // x, y 중 더 작은 수 출력
        System.out.println(Math.min(disX, disY));
    }
}