import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        System.out.println(Arrays.toString(solution(tickets)));
    }
    static boolean[] visited;
    static int max;
    static List<String> strArr = new ArrayList<>();
    static List<String> result = new ArrayList<>();
    public static String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        max = tickets.length;
        strArr.add("ICN");
        for (int i = 0; i < max; i++) {
            if (tickets[i][0].equals("ICN"))
                dfs(i, tickets);
        }
        String[] answer = new String[max+1];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

    public static void dfs(int idx, String[][] tickets) {
        visited[idx] = true;
        strArr.add(tickets[idx][1]);
        if(strArr.size() == max+1) {
            if (!result.isEmpty()) {
                for (int i = 0; i <= max; i++) {
                    String str1 = strArr.get(i);
                    String str2 = result.get(i);
                    if(str1.equals(str2)) continue;
                    if(str1.compareTo(str2) < 0)
                        result = new ArrayList<>(strArr);
                    break;
                }
            } else {
                result = new ArrayList<>(strArr);
            }
        }
        for (int i = 0; i < max; i++) {
            if(!visited[i] && strArr.get(strArr.size()-1).equals(tickets[i][0])) {
                dfs(i, tickets);
            }
        }
        visited[idx] = false;
        strArr.remove(strArr.size()-1);
    }
}