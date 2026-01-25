class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int yelloHeight = 1;
        do {
            if (yellow % yelloHeight != 0) {
                continue;
            }
            int yelloLength = yellow / yelloHeight;

            int brownHeight = yelloHeight + 2;
            int brownLength = yelloLength + 2;
            
            if (brownHeight * brownLength - yellow == brown) {
                answer[0] = brownLength;
                answer[1] = brownHeight;
                return answer;
            }
        } while (yelloHeight++ < (yellow / 2));

        return answer;
    }
}