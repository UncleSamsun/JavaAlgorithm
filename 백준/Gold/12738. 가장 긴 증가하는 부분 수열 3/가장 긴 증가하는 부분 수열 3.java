import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception{
        int N = Integer.parseInt(br.readLine().trim());
        int[] tails = new int[N];
        int size = 0;

        st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());

            int idx = lowerBound(tails, size, x); // 첫 >= x
            tails[idx] = x;
            if (idx == size) size++;
        }

        System.out.println(size);
    }
    // [0, size) 구간에서 첫 번째로 arr[pos] >= target 인 pos
    static int lowerBound(int[] arr, int size, int target) {
        int l = 0, r = size;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (arr[m] >= target) r = m;
            else l = m + 1;
        }
        return l;
    }
}