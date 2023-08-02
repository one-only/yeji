package baekjoon.Queue;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

// 백준 2164_2 카드2
// 방식2 출력부분만 BufferedWriter로 변경 -> 시간은 192ms로 동일했다.
// 1개 출력같은 간단한 출력은 print()를 이용해도 무방할 것으로 보인다.
public class P2164_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < num; i++) {
            // 1부터 num까지 큐에 저장
            queue.offer(i + 1);
        }
        // 큐에 요소가 1개 남을때까지 반복
        while (queue.size() != 1) {
            // 제일 위의 카드를 버린다.
            queue.poll();
            // 제일 위의 카드를 맨 아래로 옮긴다.
            queue.add(queue.poll());
        }
        bw.write(Integer.toString(queue.poll()));
        bw.flush();
        bw.close();
    }
}
