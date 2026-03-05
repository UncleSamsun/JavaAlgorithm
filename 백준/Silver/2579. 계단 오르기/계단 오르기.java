import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine().trim());
        int[] arr = new int[N + 1];
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine().trim());
        }
        if (N >= 1) dp[1] = arr[1];
        if (N >= 2) dp[2] = arr[1] + arr[2];
        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 3] + arr[i] + arr[i-1], dp[i - 2] + arr[i]);
        }
        System.out.println(dp[N]);
    }
}
