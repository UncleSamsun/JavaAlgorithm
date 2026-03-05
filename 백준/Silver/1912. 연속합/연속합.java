import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine().trim());
        st = new StringTokenizer(br.readLine().trim());
        int[] arr = new int[N+1];
        arr[0] = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N+1];
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            dp[i] = Math.max(arr[i], dp[i-1] + arr[i]);
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}
