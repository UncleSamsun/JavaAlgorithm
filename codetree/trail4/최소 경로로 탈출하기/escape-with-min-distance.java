import java.util.*;

public class Main {
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                a[i][j] = sc.nextInt();
        // Please write your code here.

        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{0, 0, 0});

        int answer = -1;

        while(!dq.isEmpty()) {
            int[] cur = dq.poll();
            int r = cur[0];
            int c = cur[1];
            int dist = cur[2];

            if (r == n-1 && c == m-1) {
                answer = dist;
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m || visited[nr][nc] || a[nr][nc] != 1)
                    continue;

                visited[nr][nc] = true;
                dq.offer(new int[]{nr, nc, dist+1});
            }
        }

        System.out.println(answer);

    }
}