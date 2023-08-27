package baekjoon.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P1021 {
    public static int count = 0;
    public static LinkedList<Integer> leftTurn(LinkedList<Integer> deque) {
        count++;
        deque.addLast(deque.removeFirst());
        return deque;
    }

    public static LinkedList<Integer> rightTurn(LinkedList<Integer> deque) {
        count++;
        deque.addFirst(deque.removeLast());
        return deque;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] seq = new int[M]; //뽑고자 하는 수들의 위치
        LinkedList<Integer> deque = new LinkedList<>();

        // 1부터 N까지 덱에 담는다.
        for (int i = 1; i <= N; i++) {
            deque.addLast(i);
        }
        for (int i = 0; i < M; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        // N/2+1이지만 인덱스는 0부터이므로 -1하여 2/N
        // 짝,홀 모두 N/2 까지는 2번, 그 이후는 3번 연산을 해야한다.
        // 근데
        for (int i = 0; i < M; i++) {
            int target_idx = deque.indexOf(seq[i]);
            int limit = deque.size()/2;
            if (target_idx <= limit) {
                while (deque.getFirst() != seq[i]) deque = leftTurn(deque);
            } else {
                while(deque.getFirst() !=seq[i]) deque = rightTurn(deque);
            }
            deque.removeFirst();
        }
        System.out.println(count);
    }
}
