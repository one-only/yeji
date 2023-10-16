package baekjoon.heap;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// N번째 큰 수 https://www.acmicpc.net/problem/2075
public class P2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = stoi(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                pq.add(stoi(st.nextToken()));
            }
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans = pq.poll();
        }
        bw.write(ans+"");
        bw.flush();
        bw.close();
    }
    static int stoi(String str) {
        return Integer.parseInt(str);
    }
}
