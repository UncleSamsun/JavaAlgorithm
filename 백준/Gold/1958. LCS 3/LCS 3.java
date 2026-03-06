import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        String str1 = "0" + br.readLine();
        String str2 = "0" + br.readLine();
        String str3 = "0" + br.readLine();
        int[][][] dp = new int[str1.length()][str2.length()][str3.length()];
        for (int i = 1; i < str1.length(); i++) {
            for (int j = 1; j < str2.length(); j++) {
                for (int k = 1; k < str3.length(); k++) {
                    if (str1.charAt(i) == str2.charAt(j) && str3.charAt(k) == str2.charAt(j)) {
                        dp[i][j][k] = dp[i-1][j-1][k-1] + 1;
                    }
                    else {
                        dp[i][j][k] = Math.max(Math.max(dp[i-1][j][k], dp[i][j-1][k]), dp[i][j][k-1]);
                    }
                }
            }
        }

        System.out.println(dp[str1.length()-1][str2.length()-1][str3.length()-1]);
    }
}