import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine().trim());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine().trim());

        int[] dp = new int[K+1];
        dp[0] = 1;
        for (int j = 0; j < N; j++) {
            for (int i = 1; i <= K; i++) {
                if (i - arr[j] >= 0)
                    dp[i] = dp[i] + dp[i - arr[j]];
            }
        }
        System.out.println(dp[K]);
    }
}
