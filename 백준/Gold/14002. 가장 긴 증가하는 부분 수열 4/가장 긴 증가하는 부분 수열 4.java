import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] arr;
    static int[] tail;

    public static void main(String[] args) throws Exception{
        int N = Integer.parseInt(br.readLine().trim());
        arr = new int[N];
        st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        tail = new int[N];
        int size = 0;
        for (int i = 0; i < N; i++) {
            int idx = lowerBound(0, size, arr[i]);
            if (idx == size) size++;
            tail[idx] = arr[i];
            dp[i] = idx;
        }

        int[] ans = new int[size];
        int idx = size-1;
        for (int i = N-1; i >= 0; i--) {
            if (dp[i] == idx) {
                ans[idx] = arr[i];
                idx--;
            }
        }
        System.out.println(size);
        for (int i = 0; i < size; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    public static int lowerBound(int left, int right, int target) {
        while (left < right) {
            int m = (left + right) >>> 1;
            if (tail[m] >= target) right = m;
            else left = m + 1;
        }
        return left;
    }
}