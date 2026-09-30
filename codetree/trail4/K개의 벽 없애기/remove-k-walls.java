import java.util.*;

public class Main {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int r1 = sc.nextInt() - 1;
        int c1 = sc.nextInt() - 1;
        int r2 = sc.nextInt() - 1;
        int c2 = sc.nextInt() - 1;
        
        // Please write your code here.

        boolean[][][] visited = new boolean[n][n][k+1];
        visited[r1][c1][0] = true;

        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{r1, c1, 0, 0});

        int ans = -1;

        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int r = cur[0];
            int c = cur[1];
            int crashed = cur[2];
            int dist = cur[3];

            if (r == r2 && c == c2) {
                ans = dist;
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                int nCrashed = crashed;

                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                if (grid[nr][nc] != 0) {
                    if (nCrashed + 1 > k) continue;

                    nCrashed++; 
                }
                if (visited[nr][nc][nCrashed]) continue;

                visited[nr][nc][nCrashed] = true;
                dq.offer(new int[]{nr, nc, nCrashed, dist+1});
            }
        }

        System.out.print(ans);
    }
}