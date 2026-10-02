import java.util.*;
public class Main {
    static final int INF = 123456789;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        // Please write your code here.

        int[][] dp = new int[n][n];
        for (int[] a : dp) {
            Arrays.fill(a, INF);
        }
        dp[0][0] = matrix[0][0];

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (r > 0) {
                    dp[r][c] = Math.min(dp[r][c], Math.max(dp[r-1][c], matrix[r][c]));
                }
                if (c > 0) {
                    dp[r][c] = Math.min(dp[r][c], Math.max(dp[r][c-1], matrix[r][c]));
                }
            }
        }

        System.out.print(dp[n-1][n-1]);
    }
}