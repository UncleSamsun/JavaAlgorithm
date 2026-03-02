
    import java.util.*;

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
                int N = sc.nextInt();
                PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
                PriorityQueue<Integer> minHeap = new PriorityQueue<>();
                int middle = sc.nextInt();
                int result = 0;
                for (int i = 1; i <= N; i++) {
                    int num1 = sc.nextInt();
                    int num2 = sc.nextInt();
                    if (num1 > middle && num2 > middle) {
                        minHeap.offer(num1);
                        minHeap.offer(num2);
                        maxHeap.offer(middle);
                        middle = minHeap.poll();
                    }
                    else if (num1 < middle && num2 < middle) {
                        maxHeap.offer(num1);
                        maxHeap.offer(num2);
                        minHeap.offer(middle);
                        middle = maxHeap.poll();
                    }
                    else {
                        maxHeap.offer(Math.min(num1, num2));
                        minHeap.offer(Math.max(num1, num2));
                    }
                    result = (result + middle) % 20171109;
                }

                System.out.printf("#%d %d\n", tc, result);
            }
        }
    }