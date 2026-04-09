import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new List[N+1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        Deque<Integer> deque = new ArrayDeque<>();
        int[] inDegree = new int[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int pd = Integer.parseInt(st.nextToken());

            if (pd == 1) continue;
            int[] arr = new int[pd];
            arr[0] = Integer.parseInt(st.nextToken());
            for (int j = 1; j < pd; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                graph[arr[j-1]].add(arr[j]);
                inDegree[arr[j]]++;
            }
        }
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                deque.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            int from = deque.poll();
            sb.append(from).append("\n");

            for (int to : graph[from]) {
                inDegree[to]--;
                if (inDegree[to] == 0) {
                    deque.offer(to);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) continue;
            System.out.println(0);
            return;
        }
        System.out.println(sb);
    }
}
