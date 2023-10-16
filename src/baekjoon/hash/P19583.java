package baekjoon.hash;

import java.io.*;
import java.util.*;

// 싸이버개강총회 https://www.acmicpc.net/problem/19583
// time을 정수형으로 변환한 풀이(그러나 P19583_2처럼 String자체로 비교할 수 있다)
public class P19583 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;

        int S = makeTime(st.nextToken());
        int E = makeTime(st.nextToken());
        int Q = makeTime(st.nextToken());

        Set<String> entranceSet = new HashSet<>();
        Set<String> exitSet = new HashSet<>();

        String line=null;
        while ((line = br.readLine())!=null && !line.isEmpty()) { // 탈출 조건
            st = new StringTokenizer(line);
            int history = makeTime(st.nextToken());
            String nickname = st.nextToken();

            if (history <= S) {
                entranceSet.add(nickname);
            }
            if (history >= E && history <= Q) {
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

    static int makeTime(String str) {
        String[] arr = str.split(":");
        int ans = stoi(arr[0]+arr[1]);
//        System.out.println("ans = " + ans);
        return ans;
    }
}
