import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        // Please write your code here.

        int[][] dp = new int[n][m];
        dp[0][0] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                for (int r = 0; r < i; r++) {
                    for (int c = 0; c < j; c++) {
                        if (dp[r][c] > 0 && grid[i][j] > grid[r][c])
                            dp[i][j] = Math.max(dp[i][j], dp[r][c]+1);
                    }
                }
            }
        }

        int mx = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                mx = Math.max(mx, dp[r][c]);
            }
        }

        System.out.print(mx);
    }
}