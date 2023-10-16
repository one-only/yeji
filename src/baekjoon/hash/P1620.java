package baekjoon.hash;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

// 나는야 포켓몬 마스터 이다솜 https://www.acmicpc.net/problem/1620
public class P1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = stoi(st.nextToken());
        int M = stoi(st.nextToken());

        String[] arr = new String[N+1];
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            map.put(name,i+1);
            arr[i+1] = name;
        }
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (str.matches("\\d+")) { // 숫자인 경우
                bw.write(arr[stoi(str)]+"\n");
            } else { // 문자열인 경우
                bw.write(map.get(str)+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
    static int stoi(String str) {
       return Integer.parseInt(str);
    }
}
