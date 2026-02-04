import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 입력 설정
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    // 출력용 StringBuilder
    static StringBuilder sb = new StringBuilder();

    // 완료 체크용 boolean
    static boolean solved = false;

    // 가로, 세로, 박스 기준의 사용 여부 체크
    static boolean[][] rowUsed = new boolean[9][10];
    static boolean[][] colUsed = new boolean[9][10];
    static boolean[][] boxUsed = new boolean[9][10];

    public static void main(String[] args) throws Exception {
        List<int[]> blankList = new ArrayList<>();
        int[][] sudoku = new int[9][9];
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int value = Integer.parseInt(st.nextToken());
                sudoku[i][j] = value;

                // 값이 0이면 blankList에 추가
                if(value == 0){
                    blankList.add(new int[] {i, j});
                }
                // 값이 있다면 가로, 세로, 박스에 true 표시
                else {
                    rowUsed[i][value] = true;
                    colUsed[j][value] = true;
                    boxUsed[boxIndex(i, j)][value] = true;
                }
            }
        }
        // dfs 호출
        dfs(sudoku, blankList, 0);

        // 완료된 스도쿠 StringBuilder에 저장
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(sudoku[i][j] + " ");
            }
            sb.append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }

    // box index를 반환하는 클래스
    public static int boxIndex(int x, int y) {
        return (x / 3) * 3 + y / 3;
    }

    // dfs 동작
    public static void dfs(int[][] sudoku, List<int[]> blankList, int idx) {
        // 만약 이미 blankList를 다 돌았다면, solved true 처리
        if (idx == blankList.size()) solved = true;

        // solved가 true라면 더이상 dfs를 안돌리고 return
        if (solved) return;

        // blankList에서 비어있는 좌표값 가져옴
        int[] xy = blankList.get(idx);
        int x = xy[0];
        int y = xy[1];
        int b = boxIndex(x, y);

        // 1 ~ 9까지 사용하지 않은 숫자 검색
        for (int num = 1; num <= 9; num++) {
            // 이미 사용중인 숫자면 continue
            if (rowUsed[x][num] || colUsed[y][num] || boxUsed[b][num]) continue;

            // 없는 숫자면 값을 sudoku에 넣고 사용중 표시
            sudoku[x][y] = num;
            rowUsed[x][num] = true;
            colUsed[y][num] = true;
            boxUsed[b][num] = true;

            // 값을 넣은 상태로 dfs 호출 -> 호출 시 idx + 1
            dfs(sudoku, blankList, idx + 1);

            // 위의 dfs에서 완료되어 리턴되었으면 되돌리지 않고 종료
            if (solved) return;

            // 완료되지 않았다면 되돌리고 종료
            sudoku[x][y] = 0;
            rowUsed[x][num] = false;
            colUsed[y][num] = false;
            boxUsed[b][num] = false;
        }
    }
}