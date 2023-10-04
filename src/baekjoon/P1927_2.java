package baekjoon;

import java.io.*;
import java.util.PriorityQueue;
import java.util.TreeSet;

// 최소 힙
public class P1927_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x > 0) {
                minHeap.add(x);
            } else {
                if(minHeap.isEmpty())
                    bw.write("0\n");
                else
                    bw.write(minHeap.poll()+"\n");
            }
        }

        bw.flush();
        bw.close();

    }
}
