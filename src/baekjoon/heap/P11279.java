package baekjoon.heap;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
// 최대 힙
public class P11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x > 0) {
                maxHeap.add(x);
            } else {
                if(maxHeap.isEmpty())
                    bw.write("0\n");
                else
                    bw.write(maxHeap.poll()+"\n");
            }
        }


        bw.flush();
        bw.close();
    }
}
