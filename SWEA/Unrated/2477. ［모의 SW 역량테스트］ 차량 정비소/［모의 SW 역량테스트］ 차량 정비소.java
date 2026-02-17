import java.io.*;
import java.util.*;

public class Solution {
    // 입력 설정
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    // 접수창구의 개수
    static int N;
    // 정비창구의 개수
    static int M;
    // 방문한 고객의 수
    static int K;
    // 지갑을 두고 간 고객의 접수 창구번호 A, 정비 창구번호 B
    static int[] AB;
    // 접수 창구 소요시간
    static int[] reception;
    // 정비 창구 소요시간
    static int[] maintenance;
    // 고객의 방문시간
    static int[] customer;
    // 지갑을 잃어버린 사람과 같은 접수창구, 정비창구인 고객번호의 합
    static int sum;

    public static void main(String[] args) throws Exception {
        // 테스트케이스 수 입력
        int T = Integer.parseInt(br.readLine().trim());
        // 테스트케이스 수만큼 반복
        for (int tc = 1; tc <= T; tc++) {
            // 입력
            st = new StringTokenizer(br.readLine().trim());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            sum = 0;

            AB = new int[2];
            AB[0] = Integer.parseInt(st.nextToken());
            AB[1] = Integer.parseInt(st.nextToken());

            reception = new int[N];
            st = new StringTokenizer(br.readLine().trim());
            for (int i = 0; i < reception.length; i++) {
                reception[i] = Integer.parseInt(st.nextToken());
            }

            maintenance = new int[M];
            st = new StringTokenizer(br.readLine().trim());
            for (int i = 0; i < maintenance.length; i++) {
                maintenance[i] = Integer.parseInt(st.nextToken());
            }

            customer = new int[K];
            st = new StringTokenizer(br.readLine().trim());
            for (int i = 0; i < customer.length; i++) {
                customer[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(customer);

            /*
             - N개의 접수창구와 M개의 정비창구
             - 둘다 1~N, 1~M까지의 번호가 붙음
             - 한 담당자의 처리시간은 고객과 고장의 종류에 상관없이 항상 같음
             - 차량 정비소를 방문한 고객은 K명 -> 도착순서대로 1번부터 고객번호 부여
             - 빈 접수 창고가 있다면 고장을 접수
             - 빈 접수 창고가 없다면 빈 창고가 생길때까지 기다리다가 접수
             - 고장 접수 완료 후 정비 창구로 이동
             - 접수창구의 우선순위
                - 여러 고객이 기다리는 경우 고객 번호가 낮은 순서대로 우선 접수
                - 빈 창구가 여러 곳인 경우 접수창구 번호가 작은 곳으로 간다
             - 정비 창구의 우선순위
                - 먼저 기다리는 고객 우선
                - 두 명 이상의 고객들이 접수 창구에서 동시 접수 완료하고 정비창구로 왔을 경우 이용했던 창구번호가 작은 고객 우선
                - 빈 창구가 여러 곳인 경우 정비 창구 번호가 작은 곳으로 간다
             - 필요 출력
                - 지갑을 분실한 고객과 같은 접수 창구와 같은 정비 창구를 이용한 고객의 고객번호들을 찾아 그 합을 출력
             */
            solution();

            // 출력
            System.out.printf("#%d %d\n", tc, (sum == 0) ? -1 : sum);
        }
    }

    public static void solution() {
        int[][] canReception = new int[N][2];
        for (int i = 0; i < N; i++) canReception[i][0] = -1;
        int[][] canMaintenance = new int[M][2];
        for (int i = 0; i < M; i++) canMaintenance[i][0] = -1;
        int customerNum = 0;
        Deque<Integer> waitingRp = new LinkedList<>();;
        Deque<Integer> waitingMt = new LinkedList<>();;
        Set<Integer> tmp = new HashSet<>();
        int endCnt = 0;
        int time = 0;
        while (true) {
            while (customerNum < K && customer[customerNum] == time) {
                customerNum += 1;
                waitingRp.add(customerNum);
                for (int idx = 0; idx < N; idx++) {
                    if (canReception[idx][0] == -1 && !waitingRp.isEmpty()) {
                        canReception[idx][0] = 0;
                        canReception[idx][1] = waitingRp.poll();
                    }
                }
            }
            // 접수창구 순회
            for (int idx = 0; idx < N; idx++) {
                if (canReception[idx][0] >= 0) {
                    canReception[idx][0]++;
                } else if (canReception[idx][0] == -1 && !waitingRp.isEmpty()) {
                    canReception[idx][0] = 0;
                    canReception[idx][1] = waitingRp.poll();
                }
                if (canReception[idx][0] >= reception[idx]) {
                    waitingMt.add(canReception[idx][1]);
                    for (int i = 0; i < M; i++) {
                        if (canMaintenance[i][0] == -1 && !waitingMt.isEmpty()) {
                            canMaintenance[i][1] = waitingMt.poll();
                            canMaintenance[i][0] = 0;
                        }
                    }
                    int n = idx + 1;
                    if (n == AB[0]) {
                        tmp.add(canReception[idx][1]);
                    }
                    if(!waitingRp.isEmpty()) {
                        canReception[idx][0] = 0;
                        canReception[idx][1] = waitingRp.poll();
                    } else {
                        canReception[idx][0] = -1;
                        canReception[idx][1] = 0;
                    }
                }
            }

            // 정비창구 순회
            for (int idx = 0; idx < M; idx++) {
                if (canMaintenance[idx][0] >= 0){
                    canMaintenance[idx][0]++;
                }
                else if (canMaintenance[idx][0] == -1 && !waitingMt.isEmpty()) {
                    canMaintenance[idx][0] = 0;
                    canMaintenance[idx][1] = waitingMt.poll();
                }
                if (canMaintenance[idx][0] >= maintenance[idx]) {
                    endCnt++;
                    int n = idx+1;
                    if (n == AB[1] && tmp.contains(canMaintenance[idx][1])) {
                        sum += canMaintenance[idx][1];
                    }
                    if (!waitingMt.isEmpty()) {
                        canMaintenance[idx][0] = 0;
                        canMaintenance[idx][1] = waitingMt.poll();
                    } else {
                        canMaintenance[idx][0] = -1;
                        canMaintenance[idx][1] = 0;
                    }
                }
            }

            if (endCnt >= K) return;
            time++;
        }
    }
}
