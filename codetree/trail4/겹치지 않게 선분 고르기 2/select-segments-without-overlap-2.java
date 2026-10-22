import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] segments = new int[n][2];
        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            segments[i][0] = x1;
            segments[i][1] = x2;
        }
        // Please write your code here.

        Arrays.sort(segments, (a, b) -> Integer.compare(a[1], b[1]));


        int end = 0;
        int cnt = 1;
        for (int[] segment : segments) {
            if(end == 0) {
                end = segment[1];
                continue;
            }

            if (end < segment[0]) {
                cnt++;
                end = segment[1];
            }
        }

        System.out.print(cnt);
    }
}