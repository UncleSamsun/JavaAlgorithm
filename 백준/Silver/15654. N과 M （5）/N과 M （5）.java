import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static boolean[] visited;
    static StringBuilder sb;
    static List<Integer> list;
    static List<Integer> nums;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        sb = new StringBuilder();
        list = new ArrayList<>();
        nums = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            nums.add(num);
        }
        Collections.sort(nums);

        dfs(0, 0, N, M);
        System.out.println(sb);
    }

    public static void dfs(int idx, int depth, int N, int M) {
        if (depth == M) {
            for (int num : list) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (list.contains(nums.get(i))) continue;
            list.add(nums.get(i));
            dfs(i, depth+1, N, M);
            list.remove(list.size()-1);
        }
    }
}