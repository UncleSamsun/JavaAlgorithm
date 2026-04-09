import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    // 상우하좌
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int[][] visited;
    static int ans;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] grid = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                switch (str.charAt(j)) {
                    case 'U':
                        grid[i][j] = 0;
                        break;
                    case 'R':
                        grid[i][j] = 1;
                        break;
                    case 'D':
                        grid[i][j] = 2;
                        break;
                    case 'L':
                        grid[i][j] = 3;
                        break;
                }
            }
        }

        visited = new int[N][M];
        ans = 1;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (visited[r][c] != 0) continue;
                visitedCheck(grid, r, c);
            }
        }
        System.out.println(ans-1);
    }

    public static int visitedCheck(int[][] grid, int r, int c) {
        if (visited[r][c] != 0) {
            if (visited[r][c] == ans) ans++;
            return visited[r][c];
        }
        visited[r][c] = ans;
        int nr = r + dr[grid[r][c]];
        int nc = c + dc[grid[r][c]];
        visited[r][c] = visitedCheck(grid, nr, nc);
        return visited[r][c];
    }
}
