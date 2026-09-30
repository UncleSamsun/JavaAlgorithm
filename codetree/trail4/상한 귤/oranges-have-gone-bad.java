import java.util.*;

public class Main {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        // Please write your code here.

        int[][] ans = new int[n][n];

        Deque<int[]> dq = new ArrayDeque<>();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 2) {
                    dq.offer(new int[]{r, c, 0});
                    ans[r][c] = 0;
                }

                if (grid[r][c] == 0) {
                    ans[r][c] = -1;
                }
            }
        }


        while(!dq.isEmpty()) {
            int[] cur = dq.poll();

            for(int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n || grid[nr][nc] != 1)
                    continue;
                
                grid[nr][nc] = 2;
                ans[nr][nc] = cur[2] + 1;

                dq.offer(new int[]{nr, nc, cur[2]+1});
                
            }
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) ans[r][c] = -2;
            }
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                System.out.print(ans[r][c] + " ");
            }
            System.out.println();
        }
    }
}