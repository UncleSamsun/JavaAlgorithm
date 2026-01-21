import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.*;

public class Main {
    // 입력설정
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        // 입력받을 책의 수 N개
        int N = Integer.parseInt(br.readLine());
        // 책목록을 HashMap으로 선언, <책이름, 수량>
        HashMap<String, Integer> books = new HashMap<>();

        // 입력받을 책의 수 만큼 for문
        for (int in = 0; in < N; in++) {
            // 책 이름 입력
            String inputStr = br.readLine();

            // 책 목록에 입력받은 책이 없으면 추가
            if(!books.containsKey(inputStr)) {
                books.put(inputStr, 1);
            }
            // 이미 목록에 책이 있으면 값 + 1
            else {
                books.put(inputStr, books.get(inputStr) + 1);
            }
        }

        // 책 목록에 대한 이터레이터 생성
        Iterator<Entry<String, Integer>> bookList = books.entrySet().iterator();
        // 가장 많은 책의 수를 계산하기 위한 리스트 생성
        List<Integer> bookValues = new ArrayList<>(books.values());
        // 책의 수를 기준으로 정렬
        bookValues.sort(Integer::compareTo);
        // 가장 많은 책의 수를 max값에 저장
        int max = bookValues.get(bookValues.size() - 1);
        // 가장 많은 책의 수를 기준으로 책 이름을 저장할 책 리스트 생성
        List<String> topBooks = new ArrayList<>();
        // 책 목록 이터레이터를 순회
        while (bookList.hasNext()) {
            // 현재 책에 대한 정보를 bookEntry에 저장
            Entry<String, Integer> bookEntry = bookList.next();
            // 책의 최대개수와 현재 책의 수가 같다면 topBooks 리스트에 저장
            if (max == bookEntry.getValue()) {
                topBooks.add(bookEntry.getKey());
            }
        }
        // 가장 많은 수를 가지고있는 책 리스트를 이름순으로 정렬
        topBooks.sort(String::compareTo);
        // 가장 많은 수의 책 중 가장 앞서는 책 제목을 출력
        System.out.println(topBooks.get(0));
    }
}
