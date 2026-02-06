import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        for (int TC = 1; TC <= 10; TC++) {
            int N = sc.nextInt();
            String str = sc.next();
            StringBuilder sb = new StringBuilder();
            Stack<Character> chStack = new Stack<>();
            Stack<Integer> numStack = new Stack<>();
            for (int i = 0; i < N; i++) {
                char ch = str.charAt(i);
                if (ch >= '0' && ch <= '9') {
                    sb.append(ch);
                }
                else if(chStack.isEmpty()){
                    chStack.push(ch);
                }
                else {
                    sb.append(chStack.pop());
                    chStack.push(ch);
                }
            }
            while (!chStack.isEmpty()) {
                sb.append(chStack.pop());
            }
            String after = sb.toString();
            int sum = 0;
            for (int i = 0; i < after.length(); i++) {
                char ch = after.charAt(i);
                if (ch >= '0' && ch <= '9') {
                    numStack.push(Integer.parseInt(String.valueOf(ch)));
                }
                else {
                    int a = numStack.pop();
                    int b = numStack.pop();
                    sum = a + b;
                    numStack.push(sum);
                }
            }
            System.out.printf("#%d %d\n", TC, sum);
        }
    }
}
