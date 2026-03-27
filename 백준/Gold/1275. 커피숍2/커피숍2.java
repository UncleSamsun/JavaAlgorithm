import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 입력 설정
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine().trim());
        // N 입력 확인
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        long[] tree = new long[N * 4];
        init(tree, arr, 1, 0, N-1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            if (left < right)
                sb.append(query(tree, 1, 0, N-1, left-1, right-1)).append("\n");
            else
                sb.append(query(tree, 1, 0, N-1, right-1, left-1)).append("\n");
            update(tree, 1, 0, N-1, A-1, B);
        }
        System.out.println(sb.toString());
    }

    public static long init(long[] tree, int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
        }
        else {
            int mid = (start + end) / 2;
            long leftValue = init(tree, arr, node * 2, start, mid);
            long rightValue = init(tree, arr, node * 2 + 1, mid + 1, end);
            tree[node] = leftValue + rightValue;
        }
        return tree[node];
    }

    public static long query(long[] tree, int node, int start, int end, int left, int right) {
        if (end < left || right < start) {
            return 0;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        long leftValue = query(tree, node * 2, start, mid, left, right);
        long rightValue = query(tree, node * 2 + 1, mid + 1, end, left, right);
        return leftValue + rightValue;
    }

    public static void update(long[] tree, int node, int start, int end, int idx, long val) {
        if (idx < start || idx > end) return;

        if (start == end) {
            tree[node] = val; // 리프 노드 값 변경
            return;
        }

        int mid = (start + end) / 2;
        update(tree, node * 2, start, mid, idx, val);
        update(tree, node * 2 + 1, mid + 1, end, idx, val);
        tree[node] = tree[node * 2] + tree[node * 2 + 1]; // 부모 갱신
    }
}