import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[][] routes = {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};
        System.out.println(solution(routes));
    }

    public static int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> (a[1] - b[1]));
        int answer = 0;
        int base = Integer.MIN_VALUE;
        for (int idx = 0; idx < routes.length; idx++) {
            if (routes[idx][0] > base || base > routes[idx][1]) {
                base = routes[idx][1];
                answer++;
            }
        }
        return answer;
    }
}