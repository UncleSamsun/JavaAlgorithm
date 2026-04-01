import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] arr = new char[N][M];
        int[] start = new int[2];
        for (int i = 0; i < N; i++) {
            String in = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = in.charAt(j);
                if (arr[i][j] == 'I') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        boolean[][] visited = new boolean[N][M];
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{start[0], start[1]});
        visited[start[0]][start[1]] = true;

        int cnt = 0;
        while (!deque.isEmpty()) {
            int[] cur = deque.poll();

            if (arr[cur[0]][cur[1]] == 'P') {
                cnt++;
            }

            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || arr[nr][nc] == 'X')
                    continue;
                visited[nr][nc] = true;
                deque.offer(new int[] {nr, nc});
            }
        }
        System.out.println(cnt == 0 ? "TT" : cnt);
    }
}