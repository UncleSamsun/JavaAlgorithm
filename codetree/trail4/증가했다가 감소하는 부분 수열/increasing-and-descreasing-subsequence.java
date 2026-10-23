import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.

        int[] up = new int[n];
        Arrays.fill(up, 1);

        int[] down = new int[n];
        Arrays.fill(down, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] <= arr[j]) continue;

                up[i] = Math.max(up[i], up[j] + 1);
            }
        }

        for (int i = n-1; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {
                if (arr[i] <= arr[j]) continue;

                down[i] = Math.max(down[i], down[j] + 1);
            }
        }

        int mx = 0;
        for (int i = 0; i < n; i++) {
            mx = Math.max(mx, up[i] + down[i] - 1);
        }

        System.out.print(mx);
    }
}