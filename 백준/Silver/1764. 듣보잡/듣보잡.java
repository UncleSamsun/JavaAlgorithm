import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 입력설정
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String > nameSet = new HashSet<>();
        for (int idx = 0; idx < N; idx++) {
            String inputName = br.readLine();
            nameSet.add(inputName);
        }

        int cnt = 0;
        List<String> collaboList = new ArrayList<>();
        for (int idx = 0; idx < M; idx++) {
            String inputName = br.readLine();
            if(nameSet.contains(inputName)) {
                cnt++;
                collaboList.add(inputName);
            }
        }
        collaboList.sort(String::compareTo);
        StringBuilder sb = new StringBuilder().append(cnt).append('\n');
        for (String names : collaboList) {
            sb.append(names).append('\n');
        }
        System.out.print(sb);
    }
}
