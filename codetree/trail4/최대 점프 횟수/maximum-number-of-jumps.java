import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.

        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] + j < i) continue;

                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int mx = 0;
        for (int cnt : dp) {
            mx = Math.max(mx, cnt);
        }

        System.out.print(mx);
    }
}