import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node>{
    int before, next, dist;

    public Node(int before, int next, int dist) {
        this.before = before;
        this.next = next;
        this.dist = dist;
    }

    public Node(int next, int dist) {
        this.next = next;
        this.dist = dist;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return before == node.before && next == node.next && dist == node.dist;
    }

    @Override
    public int hashCode() {
        return Objects.hash(before, next, dist);
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.dist, o.dist);
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static List<Node>[] graph;
    static int N;
    static int M;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static boolean[][] bfsvisited;
    static int nodeNum;
    static int minLength;
    static boolean[] dfsVisited;

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        graph = new ArrayList[7];
        for (int i = 0; i <= 6; i++) {
            graph[i] = new ArrayList<>();
        }

        // 다익스트라를 위한 간선리스트
        setGraph();

        System.out.println(kruskal());
    }

    public static void setGraph() {
        bfsvisited = new boolean[N][M];
        nodeNum = 1;

        // for 문으로 1이고, 방문 안한 지점 탐색
        // 보이면 bfs 탐색
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] == 1 && !bfsvisited[r][c])
                    graphBfs(r, c);
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] != 0){
                    for (int dir = 0; dir < 4; dir++) {
                        bridge(map[r][c], dir, 0, r, c);
                    }
                }
            }
        }
    }

    public static void bridge(int sts, int dir, int length, int r, int c) {
        int nr = r + dr[dir];
        int nc = c + dc[dir];

        if (!rangeCheck(nr, nc)) return;

        if (map[nr][nc] != 0) {
            if (map[nr][nc] == sts) return;  // 자기 섬 제외

            if (length >= 2) {
                Node node = new Node(sts, map[nr][nc], length);
                if (!graph[sts].contains(node)) {
                    graph[sts].add(node);
                }
            }
            return;
        }

        bridge(sts, dir, length + 1, nr, nc);
    }

    public static void graphBfs(int r, int c) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{r, c});
        bfsvisited[r][c] = true;
        map[r][c] = nodeNum;

        while (!deque.isEmpty()) {
            int[] loc = deque.poll();
            for (int d = 0; d < 4; d++) {
                int nr = loc[0] + dr[d];
                int nc = loc[1] + dc[d];
                if (!rangeCheck(nr, nc)) continue;
                if (map[nr][nc] != 1 || bfsvisited[nr][nc]) continue;
                bfsvisited[nr][nc] = true;
                map[nr][nc] = nodeNum;
                deque.offer(new int[]{nr, nc});
            }
        }
        nodeNum++;
    }

    static int[] parent;

    public static int kruskal() {
        List<Node> edges = new ArrayList<>();

        // graph에 있는 간선 전부 수집
        for (int i = 1; i < nodeNum; i++) {
            for (Node next : graph[i]) {
                edges.add(new Node(i, next.next, next.dist));
            }
        }

        Collections.sort(edges);

        parent = new int[nodeNum];
        for (int i = 1; i < nodeNum; i++) {
            parent[i] = i;
        }

        int total = 0;
        int count = 0;

        for (Node edge : edges) {
            if (union(edge.before, edge.next)) {
                total += edge.dist;
                count++;
            }
        }

        // 섬 개수는 nodeNum - 1개
        // MST 간선 수는 (섬 개수 - 1) = nodeNum - 2
        if (count == nodeNum - 2) return total;
        return -1;
    }

    public static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa == pb) return false;
        parent[pb] = pa;
        return true;
    }

    public static boolean rangeCheck(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}