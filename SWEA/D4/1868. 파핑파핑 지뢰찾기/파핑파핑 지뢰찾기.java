
    import java.util.ArrayDeque;
    import java.util.Deque;
    import java.util.Scanner;

    class Location {
        int r, c;
        public Location(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    class Solution {
        static char[][] map;
        static boolean[][] visited;
        static int N;
        static int cnt;
        // 좌상, 상, 우상, 우, 우하, 하, 좌하, 좌
        static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
        static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
        public static void main(String[] args) throws Exception {
            Scanner sc = new Scanner(System.in);
            int T = sc.nextInt();
            for (int tc = 1; tc <= T; tc++) {
                // map의 크기 입력 N
                N = sc.nextInt();
                // map 초기화
                map = new char[N][N];
                // map 입력
                for (int i = 0; i < N; i++) {
                    String in = sc.next();
                    for (int j = 0; j < N; j++) {
                        map[i][j] = in.charAt(j);
                    }
                }

                cnt = 0;
                visited = new boolean[N][N];
                for (int r = 0; r < N; r++) {
                    for (int c = 0; c < N; c++) {
                        if (visited[r][c] || map[r][c] == '*') continue;
                        boolean flag = true;
                        for (int d = 0; d < 8; d++) {
                            int nr = r + dr[d];
                            int nc = c + dc[d];
                            if (validation(nr, nc)) continue;
                            if (map[nr][nc] == '*') {
                                flag = false;
                                break;
                            }
                        }
                        if (!flag) continue;
                        cnt++;
                        bfs(r, c);
                    }
                }

                for (int r = 0; r < N; r++) {
                    for (int c = 0; c < N; c++) {
                        if (map[r][c] == '.' && !visited[r][c]) cnt++;
                    }
                }
                System.out.printf("#%d %d\n", tc, cnt);
            }
        }

        static void bfs(int r, int c) {
            Deque<Location> deque = new ArrayDeque<>();
            deque.offer(new Location(r, c));
            visited[r][c] = true;

            while (!deque.isEmpty()) {
                Location loc = deque.poll();
                int lr = loc.r;
                int lc = loc.c;
                boolean flag = true;
                for (int d = 0; d < 8; d++) {
                    int nr = lr + dr[d];
                    int nc = lc + dc[d];
                    if (validation(nr, nc)) continue;
                    if (map[nr][nc] == '*') {
                        flag = false;
                        break;
                    }
                }
                if (!flag) continue;
                for (int d = 0; d < 8; d++) {
                    int nr = lr + dr[d];
                    int nc = lc + dc[d];
                    if (validation(nr, nc)) continue;
                    visited[nr][nc] = true;
                    deque.offer(new Location(nr, nc));
                }
            }
        }

        static boolean validation(int r, int c) {
            return r < 0 || r >= N || c < 0 || c >= N || visited[r][c];
        }
    }