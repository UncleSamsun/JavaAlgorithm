import java.util.*;

public class Main {
    static final int INF = 123456789;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];

        TreeSet<Integer> lower = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                lower.add(grid[i][j]);
            }
        }
        // Please write your code here.

        int min = INF;

        for (int lowNum : lower) {
            if (grid[0][0] < lowNum) continue;
            
            int[][] dp = new int[n][n];
            for (int[] d : dp) 
                Arrays.fill(d, INF);

            dp[0][0] = grid[0][0];

            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    if (grid[r][c] < lowNum) continue;

                    if (r > 0 && dp[r-1][c] != INF) 
                        dp[r][c] = Math.min(dp[r][c], Math.max(dp[r-1][c], grid[r][c]));

                    if (c > 0 && dp[r][c-1] != INF) 
                        dp[r][c] = Math.min(dp[r][c], Math.max(dp[r][c-1], grid[r][c]));
                }
            }

            if (dp[n-1][n-1] != INF)
                min = Math.min(min, dp[n-1][n-1] - lowNum);
        }

        System.out.print(min);
    }
}