import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 단어의 개수 입렵
        int n = sc.nextInt();
        // 단어의 개수에서 그룹단어가 아니면 값을 1씩 감소하여 최종 그룹단어 개수 체크용 변수 선언
        int count = n;
        // 알파벳 중복 시 빠져나가기 위한 flag 변수 선언
        boolean flag = false;
        // 단어 입력을 위한 string 배열 선언
        String[] str = new String[n];

        // 단어 입력
        for (int i = 0; i < n; i++) {
            str[i] = sc.next();
        }

        // 그룹 단어 개수 찾기
        for (int i = 0; i < n; i++) {
            // 그룹 단어에서 중복된 알파벳을 제거한 temp string 선언
            String temp = getAlphabets(str[i]).toString();
            // 단어가 중복되는지 찾기
            for (int j = 0; j < temp.length() - 1; j++) {
                for (int k = j+1; k < temp.length(); k++) {
                    // 단어가 중복된 알파벳 찾으면 count 1씩 감소, flag true로 하여 해당 그룹단어 체크 중단
                    if (temp.charAt(j) == temp.charAt(k)) {
                        count--;
                        flag = true;
                        break;
                    }
                }
                if(flag) {
                    flag = false;
                    break;
                }
            }
        }

        System.out.println(count);
    }

    // 단어에서 중복된 알파벳 제거
    public static StringBuilder getAlphabets(String str) {
        // String 연산을 편하게 하기위한 StringBuilder 선언
        StringBuilder reString = new StringBuilder();

        // 그룹 단어에서 중복되지 않은 알파벳을 reString에 저장
        for (int i = 0; i < str.length(); i++) {
            if (i == 0 || str.charAt(i) != str.charAt(i - 1)) {
                reString.append(str.charAt(i));
            }
        }

        // reString 반환
        return reString;
    }
}
