import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        sb = new StringBuilder();
        dfs(0, 0, N, M);
        System.out.println(sb);
    }

    public static void dfs(int idx, int depth, int N, int M) {
        if (depth == M) {
            for (int i = 0; i < N; i++) {
                if (visited[i]){
                    sb.append(i+1).append(" ");
                }
            }
            sb.append("\n");
        }

        for (int i = idx; i < N; i++) {
            visited[i] = true;
            dfs(i+1, depth+1, N, M);
            visited[i] = false;
        }
    }
}