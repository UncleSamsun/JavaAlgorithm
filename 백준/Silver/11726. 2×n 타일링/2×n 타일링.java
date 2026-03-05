import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine().trim());
        int[] dp = new int[N + 1];
        if (N >= 1) dp[1] = 1;
        if (N >= 2) dp[2] = 2;
        if (N > 2)
            for (int i = 3; i <= N; i++) {
                dp[i] = (dp[i-1] + dp[i-2]) % 10_007;
            }
        System.out.println(dp[N]);
    }
}
