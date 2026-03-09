import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int ans;
    static int[] board;
    static int N;
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine().trim());
        board = new int[N];
        ans = 0;
        dfs(0);
        System.out.println(ans);
    }

    public static void dfs(int cnt) {
        if (cnt == N) {
            ans++;
            return;
        }

        for (int i = 0; i < N; i++) {
            board[cnt] = i;
            if (validation(cnt)) dfs(cnt+1);
        }
    }

    public static boolean validation(int cnt) {
        for (int i = 0; i < cnt; i++) {
            if (board[i] == board[cnt]) return false;
            if (Math.abs(i - cnt) == Math.abs(board[i] - board[cnt])) return false;
        }
        return true;
    }
}