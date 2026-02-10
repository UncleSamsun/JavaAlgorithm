import java.io.*;
import java.util.*;
import java.util.LinkedList;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static List<Integer> magnet1;
    static List<Integer> magnet2;
    static List<Integer> magnet3;
    static List<Integer> magnet4;
    
	public static void main(String[] args) throws Exception {
        // 테스트케이스 수 입력
        int T = Integer.parseInt(br.readLine().trim());
		// 테스트케이스 수만큼 반복
		for (int tc = 1; tc <= T; tc++) {
			magnet1 = new LinkedList<>();
			magnet2 = new LinkedList<>();
			magnet3 = new LinkedList<>();
			magnet4 = new LinkedList<>();
			
			// 총 회전 수
            int cycle = Integer.parseInt(br.readLine().trim());
            
            // 1번 자석 입력
            st = new StringTokenizer(br.readLine().trim());
            for (int i = 0; i < 8; i++) magnet1.add(Integer.parseInt(st.nextToken()));
            // 2번 자석 입력
            st = new StringTokenizer(br.readLine().trim());
            for (int i = 0; i < 8; i++) magnet2.add(Integer.parseInt(st.nextToken()));
            // 3번 자석 입력
            st = new StringTokenizer(br.readLine().trim());
            for (int i = 0; i < 8; i++) magnet3.add(Integer.parseInt(st.nextToken()));
            // 4번 자석 입력
            st = new StringTokenizer(br.readLine().trim());
            for (int i = 0; i < 8; i++) magnet4.add(Integer.parseInt(st.nextToken()));
            
            for (int time = 0; time < cycle; time++) {
                st = new StringTokenizer(br.readLine().trim());
                int num = Integer.parseInt(st.nextToken());
                int rotate = Integer.parseInt(st.nextToken());
                
                bfs (num, rotate);
            }
            
            int result = 0;
            result += (magnet1.get(0) == 1) ? 1 : 0;
            result += (magnet2.get(0) == 1) ? 2 : 0;
            result += (magnet3.get(0) == 1) ? 4 : 0;
            result += (magnet4.get(0) == 1) ? 8 : 0;
			
			// result 출력
			System.out.printf("#%d %d\n", tc, result);
		}
	}
	
	public static void bfs(int num, int rotate) {
		Deque<List<Integer>> deque = new ArrayDeque<>();
		deque.add(Arrays.asList(num, rotate));
		
		boolean[] flag = new boolean[4];
		while (!deque.isEmpty()) {
			List<Integer> magnet = deque.poll();
			int nm = magnet.get(0);
			int dir = magnet.get(1);
			
			if(flag[nm-1]) continue;
			else flag[nm-1] = true;
			
			if(nm == 1) {
				if(magnet1.get(2) != magnet2.get(6)) {
					deque.add(Arrays.asList(2, (dir == 1) ? -1 : 1));
				}
				if(dir == 1) {
					magnet1.add(0, magnet1.get(magnet1.size()-1));
					magnet1.remove(magnet1.size()-1);
				}
				else {
					magnet1.add(magnet1.size(), magnet1.get(0));
					magnet1.remove(0);
				}
			}
			else if (nm == 4) {
				if(magnet4.get(6) != magnet3.get(2)) {
					deque.add(Arrays.asList(3, (dir == 1) ? -1 : 1));
				}
				if(dir == 1) {
					magnet4.add(0, magnet4.get(magnet4.size()-1));
					magnet4.remove(magnet4.size()-1);
				}
				else {
					magnet4.add(magnet4.size(), magnet4.get(0));
					magnet4.remove(0);
				}
			}
			else if (nm == 2) {
				if(magnet2.get(6) != magnet1.get(2)) {
					deque.add(Arrays.asList(1, (dir == 1) ? -1 : 1));
				}
				
				if(magnet2.get(2) != magnet3.get(6)) {
					deque.add(Arrays.asList(3, (dir == 1) ? -1 : 1));
				}
				
				if(dir == 1) {
					magnet2.add(0, magnet2.get(magnet2.size()-1));
					magnet2.remove(magnet2.size()-1);
				}
				else {
					magnet2.add(magnet2.size(), magnet2.get(0));
					magnet2.remove(0);
				}
			} 
			else {
				if(magnet3.get(6) != magnet2.get(2)) {
					deque.add(Arrays.asList(2, (dir == 1) ? -1 : 1));
				}
				if(magnet3.get(2) != magnet4.get(6)) {
					deque.add(Arrays.asList(4, (dir == 1) ? -1 : 1));
				}		
				
				if(dir == 1) {
					magnet3.add(0, magnet3.get(magnet3.size()-1));
					magnet3.remove(magnet3.size()-1);
				}
				else {
					magnet3.add(magnet3.size(), magnet3.get(0));
					magnet3.remove(0);
				}	
			}
		}
	}
}
