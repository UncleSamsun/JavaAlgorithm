import java.util.*;

// 1번째 코드
class Solution {
    // 상, 하, 좌, 우 확인용 dx, dy 좌표 설정
    final static int[] dx = {0, 1, 0, -1};
    final static int[] dy = {-1, 0, 1, 0};
    // 결과 확인용 변수
    static int result = -1;
    // 방문 확인용 배열
    static boolean[][] visited;
    // 타겟 좌표
    static int targetX;
    static int targetY;

    public int solution(int[][] maps) {
        // 타겟 좌표 설정
        targetX = maps.length-1;
        targetY = maps[0].length-1;
        // 방문 확인용 배열의 크기 생성
        visited = new boolean[targetX+1][targetY+1];
        bfs(maps);

        // 결과 출력
        return result;
    }

    public void bfs(int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] nowXY = queue.poll();
            int x = nowXY[0];
            int y = nowXY[1];
            int dp = nowXY[2];

            if(nowXY[0] == targetX && nowXY[1] == targetY){
                result = nowXY[2];
            }

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int depth = dp + 1;
                if (nx >= 0 && nx <= targetX && ny >= 0 && ny <= targetY) {
                    if (maps[nx][ny] == 1 && !visited[nx][ny]) {
                        queue.offer(new int[]{nx, ny, depth});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}