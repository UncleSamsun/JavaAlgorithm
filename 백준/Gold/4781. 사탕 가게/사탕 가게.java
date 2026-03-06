import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
    static class Candy {
        int cal;
        int price;

        public Candy(int cal, int price) {
            this.cal = cal;
            this.price = price;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        while (true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int money = (int) Math.round(Double.parseDouble(st.nextToken()) * 100);
            if (N == 0 && money == 0) break;
            Candy[] candies = new Candy[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int cal = Integer.parseInt(st.nextToken());
                int price = (int) Math.round(Double.parseDouble(st.nextToken()) * 100);
                candies[i] = new Candy(cal, price);
            }
            int[] dp = new int[money+1];
            for (Candy candy : candies) {
                for (int i = 1; i <= money; i++) {
                    if (i >= candy.price) {
                        dp[i] = Math.max(dp[i], dp[i-candy.price] + candy.cal);
                    }
                }
            }

            System.out.println(dp[money]);
        }
    }
}