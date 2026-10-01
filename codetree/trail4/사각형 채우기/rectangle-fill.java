import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        int[] dp = new int[n+1];
        for (int i = 0; i <= n; i++) {
            if (i <= 1) dp[i] = 1;
            else if (i == 2) dp[i] = 2;
            else dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }

        System.out.println(dp[n]);
    }
}