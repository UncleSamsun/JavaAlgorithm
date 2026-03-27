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
        // M 입력 확인
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine().trim());

        int[] tree = new int[N * 4];
        init(tree, arr, 1, 0, N-1);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine().trim());
            // 범위 입력
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            System.out.println(query(tree, 1, 0, N-1, left-1, right-1));
        }
    }

    public static void init(int[] tree, int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
        }
        else {
            int mid = (start + end) / 2;
            init(tree, arr, node * 2, start, mid);
            init(tree, arr, node * 2 + 1, mid + 1, end);
            tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
        }

    }

    public static int query(int[] tree, int node, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return -1;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        int leftValue = query(tree, node * 2, start, mid, left, right);
        int rightValue = query(tree, node * 2 + 1, mid + 1, end, left, right);

        if (leftValue == -1)
            return rightValue;
        if (rightValue == -1)
            return leftValue;

        return Math.min(leftValue, rightValue);
    }
}