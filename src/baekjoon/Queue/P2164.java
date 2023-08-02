package baekjoon.Queue;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

// 백준 2164 카드2
public class P2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        // Queue의 타입<>을 지정해주니 시간이 292ms->192ms로 줄어듦
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
        System.out.print(queue.poll());

    }
}
