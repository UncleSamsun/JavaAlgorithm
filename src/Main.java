import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        String str = input.toUpperCase();
        int max = 0;
        int chNum = 0;
        boolean flag = false;

        int[] cnt = new int[26];

        for(int i = 0; i < str.length(); i++) {
            cnt[str.charAt(i) - 'A']++;
        }

        for(int i = 0; i < cnt.length; i++) {
            if(cnt[i] > 0) {
                if(max < cnt[i]) {
                    max = cnt[i];
                    chNum = i;
                    flag = false;
                } else if(max == cnt[i]) {
                    flag = true;
                }
            }
        }

        if(flag) {
            System.out.println("?");
        } else {
            System.out.println((char)('A'+chNum));
        }
    }
}
