import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public String solution(int[] numbers) {
        String[] numberStr = new String[numbers.length];
        int i = 0;
        for (int number : numbers) {
            numberStr[i] = String.valueOf(number);
            i++;
        }
        Arrays.sort(numberStr, (a, b) -> (b + a).compareTo(a + b));

        if (numberStr[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String str : numberStr) {
            sb.append(str);
        }
        String answer = sb.toString();
        return answer;
    }
}