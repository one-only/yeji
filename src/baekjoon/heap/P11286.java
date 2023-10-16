package baekjoon.heap;

import java.io.*;
import java.util.*;

// 절댓값 힙 https://www.acmicpc.net/problem/11286
// 별도의 큐를 만들어 음수를 판별하는 방식(시간초과)

public class P11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = stoi(br.readLine());
        int[] arr = new int[N];

        // 절댓값을 기준으로 정렬하는 큐
        PriorityQueue<Integer> absPQ = new PriorityQueue<>();
        // 일반 크기순대로 정렬하는 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int xVal = stoi(br.readLine());
            switch (xVal) {
                case 0:
                    if (absPQ.isEmpty()) {
                        bw.write(0 + "\n");
                    } else { // 배열에서 절댓값 가장 작은 값 출력, 그 값 제거
                        int num = absPQ.poll(); // -1의 경우 num=1
                        if (pq.contains(-num)) { // 음수값이 존재하는 경우
                            bw.write(-num+"\n");
                            pq.remove(-num);
                        } else {
                            bw.write(num+"\n");
                            pq.remove(num);
                        }
                    }
                    break;
                default:
                    //배열에 x 추가
                    pq.add(xVal);
                    absPQ.add(Math.abs(xVal));
//                    Collections.sort(pq);
                    break;
            }
        }
        bw.flush();
        bw.close();

    }

    static int stoi(String str) {
        return Integer.parseInt(str);
    }
}
