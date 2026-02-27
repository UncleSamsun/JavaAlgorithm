import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 입력 설정
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine().trim());
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine().trim());
            String str = st.nextToken();
            if (str.equals("push")) {
                stack.push(Integer.parseInt(st.nextToken()));
            }
            else if (str.equals("pop")) {
                System.out.println(stack.isEmpty() ? -1 : stack.pop());
            }
            else if (str.equals("size")) {
                System.out.println(stack.size());
            }
            else if (str.equals("top")) {
                System.out.println(stack.isEmpty() ? -1 : stack.peek());
            }
            else if (str.equals("empty")) {
                System.out.println(stack.isEmpty() ? 1 : 0);
            }
        }
    }
}