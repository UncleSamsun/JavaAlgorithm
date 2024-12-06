import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 평점 총 개수 = 20
        int n = 20;

        // 과목명, 학점, 평점 배열 선언
        String[] className = new String[n];
        String[] score = new String[n];
        String[] grade = new String[n];

        // 전체 합, 학점 합, 학점 연산용 변수, 평점 연산용 변수
        double sum = 0;
        double scoreSum = 0;
        double gradeNum = 0;
        double scoreNum = 0;

        // 학점 P 체크용
        boolean flag = false;

        // 과목별 학점, 평점 입력
        for(int i = 0; i < n; i++) {
            className[i] = sc.next();
            score[i] = sc.next();
            grade[i] = sc.next();
        }

        // 과목별 학점, 평점 합 구하기
        for(int i = 0; i < n; i++) {
            // 학점 double형으로 변환
            switch (grade[i]) {
                case "A+":
                    gradeNum = 4.5;
                    break;
                case "A0":
                    gradeNum = 4.0;
                    break;
                case "B+":
                    gradeNum = 3.5;
                    break;
                case "B0":
                    gradeNum = 3.0;
                    break;
                case "C+":
                    gradeNum = 2.5;
                    break;
                case "C0":
                    gradeNum = 2.0;
                    break;
                case "D+":
                    gradeNum = 1.5;
                    break;
                case "D0":
                    gradeNum = 1.0;
                    break;
                case "F":
                    gradeNum = 0.0;
                    break;
                default:
                    flag = true;
                    break;
            }
            // 학점이 P가 아닐시 학점, 평점 합 구하기
            if (!flag) {
                scoreNum = Double.parseDouble(score[i]);
                scoreSum += scoreNum;
                sum += scoreNum * gradeNum;
            }
            // flag 초기화
            flag = false;
        }
        // 학점 합이 0이면 0.000000 출력, 아니면 소수점 6자로 출력
        if (scoreSum == 0) {
            System.out.println("0.000000");
        } else {
            System.out.println(String.format("%.6f", sum / scoreSum));
        }
    }
}
