import java.util.*;
public class Main {
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int h = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = sc.nextInt();
        // Please write your code here.

        int[][] answer = new int[n][n];

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (a[r][c] != 2) continue;

                answer[r][c] = -1;

                boolean[][] visited = new boolean[n][n];
                visited[r][c] = true;
                Deque<int[]> dq = new ArrayDeque<>();
                dq.offer(new int[]{r, c, 0});

                while (!dq.isEmpty()) {
                    int[] cur = dq.poll();
                    int cr = cur[0];
                    int cc = cur[1];
                    int dist = cur[2];

                    if (a[cr][cc] == 3) {
                        answer[r][c] = dist;
                        break;
                    }

                    for (int d = 0; d < 4; d++) {
                        int nr = cr + dr[d];
                        int nc = cc + dc[d];

                        if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                        if (visited[nr][nc]) continue;
                        if (a[nr][nc] == 1) continue;

                        visited[nr][nc] = true;
                        dq.offer(new int[]{nr, nc, dist+1});
                    }
                }
            }
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                System.out.print(answer[r][c] + " ");
            }
            System.out.println();
        }
    }
}