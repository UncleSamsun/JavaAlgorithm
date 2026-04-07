import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge>{
    int from;
    int to;
    int dist;

    public Edge(int from, int to, int dist) {
        this.from = from;
        this.to = to;
        this.dist = dist;
    }
    @Override
    public int compareTo(Edge o) {
        return this.dist - o.dist;
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] p;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        Edge[] edges = new Edge[E];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(from, to, dist);
        }
        Arrays.sort(edges);

        p = new int[V+1];
        for (int i = 0; i <= V; i++) {
            p[i] = i;
        }

        int total = 0;
        for (int i = 0, cnt = 0; i < E && cnt < V-1; i++) {
            if (findSet(edges[i].from) != findSet(edges[i].to)) {
                p[findSet(edges[i].from)] = findSet(edges[i].to);
                cnt++;
                total += edges[i].dist;
            }
        }
        System.out.println(total);
    }

    public static int findSet(int x) {
        if (p[x] != x) p[x] = findSet(p[x]);
        return p[x];
    }
}
