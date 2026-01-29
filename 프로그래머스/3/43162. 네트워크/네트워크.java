class Solution {
    boolean[] visited;
    int[][] computerArr;
    int size;
    int cnt;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        computerArr = computers;
        cnt = 0;
        size = n;

        for (int idx = 0; idx < n; idx++) {
            if(!visited[idx]) {
                cnt++;
                dfs(idx);
            }
        }

        return cnt;
    }

    public void dfs (int idx) {
        visited[idx] = true;

        for (int nextIdx = 0; nextIdx < size; nextIdx++) {
            if (!visited[nextIdx] && computerArr[idx][nextIdx] == 1) {
                dfs(nextIdx);
            }
        }
    }
}