class Solution {
    public static int cnt;

    public int solution(int[] numbers, int target) {
        return dfs(-1, 0, numbers, target);
    }

    // dfs 구현
    public int dfs(int depth, int sum, int[] numbers, int target) {
        depth++;
        if(depth >= numbers.length) {
            if(sum == target) {
                cnt++;
            }
        } else {
            dfs(depth, sum + numbers[depth], numbers, target);
            dfs(depth, sum - numbers[depth], numbers, target);
        }
        return cnt;
    }
}