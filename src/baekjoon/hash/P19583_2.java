package baekjoon.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 싸이버개강총회 https://www.acmicpc.net/problem/19583
// String값을 int형으로 변환하지 않고 compareTo()이용하여 비교한 풀이
public class P19583_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;

        String S = st.nextToken();
        String E = st.nextToken();
        String Q = st.nextToken();

        Set<String> entranceSet = new HashSet<>();
        Set<String> exitSet = new HashSet<>();

        String line=null;
        while ((line = br.readLine())!=null && !line.isEmpty()) { // 탈출 조건
            // && !line.isEmpty() 조건을 넣지 않으면 NoSuchElement 에러가 발생, 단 백준 문제풀이는 통과함.
            st = new StringTokenizer(line);
            String time = st.nextToken();
            String nickname = st.nextToken();

            if (time.compareTo(S) <= 0) {
                entranceSet.add(nickname);
            }
            if (time.compareTo(E) >= 0 && time.compareTo(Q) <= 0) {
                exitSet.add(nickname);
            }
        }
        for (String nickname : exitSet) {
            if(entranceSet.contains(nickname))
                count++;
        }
        System.out.println(count);
        br.close();
    }

    static int stoi(String str) {
        return Integer.parseInt(str);
    }

}
