import java.util.*;

class Cell implements Comparable<Cell> {
    int r, c, val;

    public Cell (int r, int c, int val) {
        this.r = r;
        this.c = c;
        this.val = val;
    }

    @Override
    public int compareTo (Cell other) {
        return Integer.compare(this.val, other.val);
    }
}

public class Main {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];

        int[][] dp = new int[n][n];

        ArrayList<Cell> cells = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                dp[i][j] = 1;
                cells.add(new Cell(i, j, grid[i][j]));
            }
        }
        // Please write your code here.

        Collections.sort(cells);

        for (Cell cell : cells) {
            int r = cell.r;
            int c = cell.c;
            int val = cell.val;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                if (grid[nr][nc] <= val) continue;

                dp[nr][nc] = Math.max(dp[nr][nc], dp[r][c] + 1);
            }
        }

        int ans = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dp[i][j]);
            }
        }

        System.out.print(ans);

    }
}