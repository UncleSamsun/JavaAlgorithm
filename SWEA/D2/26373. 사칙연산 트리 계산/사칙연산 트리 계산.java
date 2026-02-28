import java.util.*;

class Solution {
    static String[] tree;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc. nextInt();

        for (int tc = 1; tc <= T; tc++) {
            // 노드의 개수 N
            int N = sc.nextInt();
            tree = new String[N+1];
            for (int i = 0; i < N; i++) {
                String nodeNum = sc.next(); // "1" -> 노드 번호
                tree[Integer.parseInt(nodeNum)] = sc.next(); // 1번 인덱스에 2번째 값("*")이 들어감
                sc.next();
                sc.next();
            }
            int result = cal(1);
            System.out.printf("#%d %d\n", tc, result);
        }
    }

    public static int cal(int nodeNum) {
        if ("+-*/".contains(tree[nodeNum])) {
            int num1 = cal(nodeNum * 2);
            int num2 = cal(nodeNum * 2 + 1);
            // 어떤 사칙연산인지 판단
            if (tree[nodeNum].equals("+")) return num1 + num2;
            if (tree[nodeNum].equals("-")) return num1 - num2;
            if (tree[nodeNum].equals("*")) return num1 * num2;
            if (tree[nodeNum].equals("/")) return num1 / num2;
        } else {
            return Integer.parseInt(tree[nodeNum]);
        }
        return 0;
    }
}