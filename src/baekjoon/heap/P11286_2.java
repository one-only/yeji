package baekjoon.heap;

import java.io.*;
import java.util.Collections;
import java.util.Map;
import java.util.PriorityQueue;

// 절댓값 힙 https://www.acmicpc.net/problem/11286


public class P11286_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = stoi(br.readLine());
        int[] arr = new int[N];

        // 일반 크기순대로 정렬하는 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);

            if(abs1==abs2) return o1-o2;
            return abs1 - abs2;
        });
        for (int i = 0; i < N; i++) {
            int val = stoi(br.readLine());
            if (val == 0) {
                if (pq.isEmpty()) {
                    bw.write("0\n");
                } else {
                    bw.write(pq.poll() + "\n");
                }
            } else {
                pq.add(val);
            }
        }

        bw.flush();
        bw.close();

    }

    static int stoi(String str) {
        return Integer.parseInt(str);
    }
}
