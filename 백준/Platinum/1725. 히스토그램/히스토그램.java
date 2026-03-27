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

        // N이 0이 아니라면 뒤에 숫자 입력
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine().trim());

        int[] tree = new int[N * 4];
        init(tree, arr, 1, 0, N-1);

        System.out.println(getMaxArea(tree, arr, N, 0, N-1));
    }

    public static int init(int[] tree, int[] arr, int node, int start, int end) {
        if (start == end) {
            return tree[node] = start; // 인덱스 저장
        }
        int mid = (start + end) / 2;
        int leftIdx = init(tree, arr, node * 2, start, mid);
        int rightIdx = init(tree, arr, node * 2 + 1, mid + 1, end);

        // 왼쪽과 오른쪽 중 더 낮은 높이를 가진 막대의 인덱스를 저장
        return tree[node] = arr[leftIdx] < arr[rightIdx] ? leftIdx : rightIdx;
    }

    public static int query(int[] tree, int[] arr, int node, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return -1;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        int leftIdx = query(tree, arr, node * 2, start, mid, left, right);
        int rightIdx = query(tree, arr, node * 2 + 1, mid + 1, end, left, right);
        if (leftIdx == -1) return rightIdx;
        if (rightIdx == -1) return leftIdx;
        return arr[leftIdx] <= arr[rightIdx] ? leftIdx : rightIdx;
    }

    public static long getMaxArea(int[] tree, int[] arr, int N, int start, int end) {
        int minIdx = query(tree, arr, 1, 0, N-1, start, end);

        long area = (long) arr[minIdx] * (end - start + 1);

        if (start <= minIdx - 1)
            area = Math.max(area, getMaxArea(tree, arr, N, start, minIdx-1));

        if (end >= minIdx + 1)
            area = Math.max(area, getMaxArea(tree, arr, N, minIdx+1, end));

        return area;
    }

}