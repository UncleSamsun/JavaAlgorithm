import java.io.*;
import java.util.*;

public class Solution {
	// 입력 설정
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int max;
	// 대각선 이동용
	// 우상(0), 우하(1), 좌하(2), 좌상(3)
	static int[] dr = { -1, 1, 1, -1 };
	static int[] dc = { 1, 1, -1, -1 };
	// 카페 정보
	static int[][] cafes;
	// 방향 중복 처리 방지용
	static boolean[] flag;
	// 중복디저트 방지용
	static boolean[] duple;
	// 범위
	static int N;
	// 시작지점
	static int[] start;
	
	public static void main(String[] args) throws Exception {
		// 테스트케이스 수 입력
		int T = Integer.parseInt(br.readLine().trim());
		// 테스트케이스 수만큼 반복
		for (int tc = 1; tc <= T; tc++) {
			// 입력
			// 정점의 갯수 입력
			N = Integer.parseInt(br.readLine().trim());
			// 카페 초기화 후 입력
			cafes = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < N; j++) {
					cafes[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// max 값 초기화
			max = -1;
			start = new int[2];
			// 로직
			// 대각선으로만 움직여야한다.
			// 사각형 모양을 그리며 출발한 카페로 돌아와야한다.
			// 같은 숫자의 디저트를 팔고있는 카페가 있으면 안된다.
			// 카페 범위를 벗어나면 안된다.
			// 왔던 곳을 다시 방문하는 것은 안된다.
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					// 초기화
					flag = new boolean[5];
					duple = new boolean[101];
					start[0] = r;
					start[1] = c;
					
					// dfs 호출
					dfs(r, c, 4, 1);
				}
			}

			// 출력
			System.out.printf("#%d %d\n", tc, max);
		}
	}

	public static void dfs(int r, int c, int beforeDir, int depth) {
		// 지금 값을 set에 저장
		duple[cafes[r][c]] = true;
		
		// 대각선 4방위 탐색
        for (int idx = 0; idx <= 1; idx++) {
            int i = (beforeDir+idx)%4;
			// 이미 했던 방향이면 넘기기
			if (flag[i]) continue;

			// 예상 경로
			int nr = r + dr[i];
			int nc = c + dc[i];
			// 예상 경로가 범위를 넘어가면 넘기기
			if (0 > nr || 0 > nc || nr >= N || nc >= N) continue;

			// 만약 시작에 도착했다면
			// 현재 depth를 max와 비교
			if (nr == start[0] && nc == start[1]) max = Math.max(max, depth);
				
			// 다음 경로 값이 이미 set에 저장되어있다면 넘기기
			if (duple[cafes[nr][nc]]) continue;
			
			// 만약 이전 방향과 다른 방향으로 간다면 이전 방향의 flag 값을 true로 변경
			if(i != beforeDir) flag[beforeDir] = true;
			
			// dfs 재귀
			dfs(nr, nc, i, depth+1);
				
			// 변경한 flag 값을 되돌리기
			if(i != beforeDir) flag[beforeDir] = false;
			
		}
		// set에 저장한 지금 값을 제거
		duple[cafes[r][c]] = false;
	}
}
