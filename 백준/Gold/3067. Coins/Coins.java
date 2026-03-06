import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] coins = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }
            int K = Integer.parseInt(br.readLine());
            int[] dp = new int[K + 1];
            dp[0] = 1;
            for (int coin : coins) {
                for (int i = 1; i <= K; i++) {
                    if (i >= coin) 
                        dp[i] = dp[i] + dp[i - coin];
                }
            }

            System.out.println(dp[K]);
        }
    }
}