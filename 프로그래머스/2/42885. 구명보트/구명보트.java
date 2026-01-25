import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
        System.out.println(solution(people, 100));
    }
    public static int solution(int[] people, int limit) {
        int answer = 0;
        List<Integer> peopleList = new ArrayList<>();
        for (int person : people) peopleList.add(person);
        peopleList.sort(Integer::compareTo);
        int minIdx = 0;
        for (int maxIdx = peopleList.size()-1; maxIdx >= 0; maxIdx--) {
            if(minIdx > maxIdx) break;
            if (peopleList.get(maxIdx) + peopleList.get(minIdx) <= limit && maxIdx > 0) {
                minIdx++;
            }
            answer++;
        }
        return answer;
    }
}