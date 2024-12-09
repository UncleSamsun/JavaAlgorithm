import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입렵받을 문장 5줄 크기 선언
        String[] str = new String[5];
        // 각줄의 문장 길이
        int[] len = new int[5];
        // 각줄의 철자 카운트용 변수
        int[] cnt = new int[5];
        // 각 줄의 문장 끝 여부 확인용 플래그 변수
        boolean[] flag = new boolean[5];


        // 각 줄의 문장 입력
        for(int i = 0; i < 5; i++) {
            str[i] = sc.next();
            len[i] = str[i].length();
            flag[i] = true;
        }

        // 각 줄의 문장이 모두 출력 될 때까지 반복
        while(flag[0] || flag[1] || flag[2] || flag[3] || flag[4]) {
            // 첫번째 줄부터 순서대로 출력
            if (cnt[0] < len[0]) {
                System.out.print(str[0].charAt(cnt[0]));
                cnt[0]++;
            } else {    // 문장이 끝났으면 false로 변경
                flag[0] = false;
            }
            if (cnt[1] < len[1]) {
                System.out.print(str[1].charAt(cnt[1]));
                cnt[1]++;
            } else {
                flag[1] = false;
            }
            if (cnt[2] < len[2]) {
                System.out.print(str[2].charAt(cnt[2]));
                cnt[2]++;
            } else {
                flag[2] = false;
            }
            if (cnt[3] < len[3]) {
                System.out.print(str[3].charAt(cnt[3]));
                cnt[3]++;
            } else {
                flag[3] = false;
            }
            if (cnt[4] < len[4]) {
                System.out.print(str[4].charAt(cnt[4]));
                cnt[4]++;
            } else {
                flag[4] = false;
            }
        }
    }
}
