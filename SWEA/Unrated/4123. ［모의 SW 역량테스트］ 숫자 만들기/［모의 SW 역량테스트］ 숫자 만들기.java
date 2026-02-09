import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        // 테스트케이스 수 입력
        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine().trim());
            Deque<String> oper = new ArrayDeque<>();
            List<Integer> num = new ArrayList<>();
            st = new StringTokenizer(br.readLine().trim());
            for (int i = 0; i < 4; i++) {
                int op = Integer.parseInt(st.nextToken());
                for (int j = 0; j < op; j++) {
                    if (i == 0) oper.add("+");
                    else if (i == 1) oper.add("-");
                    else if (i == 2) oper.add("*");
                    else oper.add("/");
                }
            }
            st = new StringTokenizer(br.readLine().trim());
            for (int i = 0; i < N; i++)
                num.add(Integer.parseInt(st.nextToken()));

            List<Integer> ansList = new ArrayList<>();
            dfs(1, num, oper, ansList, num.get(0));
            Collections.sort(ansList);
            System.out.printf("#%d %d\n", tc, ansList.get(ansList.size() - 1) - ansList.get(0));
        }
    }

    public static void dfs(int idx, List<Integer> num, Deque<String> oper, List<Integer> ansList, int nm) {
        if(idx == num.size()) {
            ansList.add(nm);
            return;
        }

        Set<String> temp = new HashSet<>();
        for(int i = 0; i < oper.size(); i++) {
            int sm = nm;
            String op = oper.pollFirst();
            if (!temp.contains(op)) temp.add(op);
            else {
                oper.addLast(op);
                continue;
            }

            if (op.equals("+")) {
                sm += num.get(idx);
            }
            else if (op.equals("-")) {
                sm -= num.get(idx);
            }
            else if (op.equals("*")) {
                sm *= num.get(idx);
            }
            else {
                sm /= num.get(idx);
            }
            dfs(idx+1, num, oper, ansList, sm);
            oper.addLast(op);
        }
    }
}
