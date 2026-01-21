import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> setStr = new HashSet<>();
        HashSet<String> checkStr = new HashSet<>();
        int cnt = 0;
        for (int in = 0; in < N; in++) {
            setStr.add(br.readLine());
        }
        for (int in = 0; in < M; in++) {
            String inputStr = br.readLine();
            if (setStr.contains(inputStr)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
