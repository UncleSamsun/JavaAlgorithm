import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // 각 노드별 건설완료시간
            // 노드는 1번부터 시작
            int[] craftTime = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                craftTime[i] = Integer.parseInt(st.nextToken());
            }

            int[] inDegree = new int[N+1];
            int[][] adjArr = new int[N+1][N+1];
            for (int i = 1; i <= M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                adjArr[from][to] = 1;
                inDegree[to]++;
            }

            int[] ans = new int[N+1];

            Deque<int[]> queue = new ArrayDeque<>();
            for (int i = 1; i <= N; i++) {
                if (inDegree[i] == 0) {
                    queue.offer(new int[]{i, craftTime[i]});
                    ans[i] = craftTime[i];
                }
            }

            int last = Integer.parseInt(br.readLine());


            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                int from = cur[0];
                int time = cur[1];

                for (int to = 1; to <= N; to++) {
                    if (adjArr[from][to] == 0) continue;
                    inDegree[to]--;
                    int newTime = time + craftTime[to];
                    ans[to] = Math.max(ans[to], newTime);
                    if (inDegree[to] == 0) {
                        queue.offer(new int[]{to, ans[to]});
                    }
                }
            }
            System.out.println(ans[last]);
        }
    }
}
