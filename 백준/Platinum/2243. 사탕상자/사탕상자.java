import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 입력 설정
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    public static void main(String[] args) throws Exception{
        // N 입력 확인
        int N = Integer.parseInt(br.readLine().trim());
        int size = 1_000_000;
        int[] tree = new int[size * 4];
        int[] arr = new int[size];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int cmd = Integer.parseInt(st.nextToken());
            int rank = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                System.out.println(popCandy(tree, 1, rank, 1, size));
            }
            else {
                int value = Integer.parseInt(st.nextToken());
                updateCandy(tree, 1, rank, 1, size, value);
            }
        }
    }

    private static void updateCandy(int[] tree, int node, int rank, int start, int end, int value) {
        tree[node] += value;

        if (start == end) {
            return;
        }

        int mid = (start + end) / 2;
        if (rank <= mid) {
            updateCandy(tree, node * 2, rank, start, mid, value);
        }
        else {
            updateCandy(tree, node * 2 + 1, rank, mid + 1, end, value);
        }
    }

    private static int popCandy(int[] tree, int node, int rank, int start, int end) {
        tree[node] -= 1;
        if (start == end) {
            return start;
        }

        int mid = (start + end) / 2;
        if (rank <= tree[node*2]) {
            return popCandy(tree, node * 2, rank, start, mid);
        }
        else {
            return popCandy(tree, node * 2 + 1, rank - tree[node*2], mid + 1, end);
        }
    }

}