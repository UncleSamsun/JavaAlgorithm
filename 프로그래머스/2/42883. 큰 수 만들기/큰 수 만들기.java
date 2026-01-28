import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String solution(String number, int k) {
        // char 덱 생성
        Deque<Character> numberQueue = new ArrayDeque<>();

        // number를 char로 쪼개서 저장
        char[] charNum = number.toCharArray();
        // 순회할 idx 값 선언
        int idx = 0;
        while (idx < charNum.length) {
            // 만약
            // 1. 삭제 갯수가 남음
            // 2. 덱에 값이 있음
            // 3. 덱의 마지막 값이 현재 charNum 값보다 작다면
            // -> 덱의 마지막 값 삭제
            // -> 삭제 갯수 -1 감소
            if (k > 0 && !numberQueue.isEmpty() && numberQueue.peekLast() < charNum[idx]) {
                numberQueue.pollLast();
                k--;
            }
            else {
                // 현재 charNum의 값을 덱에 넣음
                numberQueue.add(charNum[idx]);
                idx++;
            }
        }
        while (k-- > 0) numberQueue.pollLast();

        StringBuilder returnStr = new StringBuilder();
        for (char charQueue : numberQueue) {
            returnStr.append(charQueue);
        }
        return returnStr.toString();
    }
}