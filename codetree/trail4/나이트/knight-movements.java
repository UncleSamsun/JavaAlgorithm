import java.util.*;

public class Main {

    static int[] dr = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dc = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r1 = sc.nextInt() - 1;
        int c1 = sc.nextInt() - 1;
        int r2 = sc.nextInt() - 1;
        int c2 = sc.nextInt() - 1;
        // Please write your code here.

        boolean[][] visited = new boolean[n][n];
        visited[r1][c1] = true;

        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{r1, c1, 0});

        int ans = -1;

        while(!dq.isEmpty()) {
            int[] cur = dq.poll();

            if (cur[0] == r2 && cur[1] == c2) {
                ans = cur[2];
                break;
            }

            for (int d = 0; d < 8; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n || visited[nr][nc])
                    continue;

                visited[nr][nc] = true;
                dq.offer(new int[] {nr, nc, cur[2]+1});
            }
        }

        System.out.println(ans);

    }
}