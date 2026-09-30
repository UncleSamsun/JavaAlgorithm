import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.

        boolean[] visited = new boolean[n*2];
        visited[n] = true;

        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{n, 0});

        int ans = -1;

        while(!dq.isEmpty()) {
            int[] cur = dq.poll();
            int num = cur[0];
            int dist = cur[1];

            if (num == 1) {
                ans = dist;
                break;
            }

            if(!visited[num-1]) {
                visited[num-1] = true;
                dq.offer(new int[]{num-1, dist+1});
            }

            if (num+1 < n*2 && !visited[num+1]) {
                visited[num+1] = true;
                dq.offer(new int[]{num+1, dist+1});
            }

            if (num % 2 == 0 && !visited[num/2]) {
                visited[num/2] = true;
                dq.offer(new int[]{num/2, dist+1});
            }

            if (num % 3 == 0 && !visited[num/3]) {
                visited[num/3] = true;
                dq.offer(new int[]{num/3, dist+1});
            }
            
        }

        System.out.print(ans);
    }
}