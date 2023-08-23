package baekjoon.queue;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
// 큐2
public class P18258 {
    public static void main(String[] args) throws IOException {
        // 10845 문제는 직접 큐의 기능을 구현해서 풀었고 18258은 Deque를 이용했다.

        // Queue는 맨 뒤의 요소를 확인하는 back()함수가 없다.
        // 1.LinkedList<>를 선언한거나 2. Dequeue<>를 선언하는 방법이 있다.
        // ArrayList로도 큐처럼 사용할 수 있으나 삽입 삭제가 많아
        // 효율이 LinkedList가 더 좋다. (ArrayList로 할 경우 시간초과가 난다고 한다.)
        Deque<Integer> deque = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            switch (str) {
                case "push":
                    // 주의! push()는 값을 앞쪽에 삽입하므로 X
                    deque.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if(deque.isEmpty())
                        bw.write("-1\n");
                    else
                        bw.write(deque.pop()+"\n");
                    break;
                case "size":
                    // bw.write()은 문자열 형태로 출력해야한다.
                    bw.write(Integer.toString(deque.size())+"\n");
                    // 뒤에 문자열을 붙여주면("\n") 앞에 문자열 변환을 생략할 수 있다.
                    bw.write(deque.size()+"\n");
                    break;
                case "empty":
                    if(deque.isEmpty())
                        bw.write("1\n");
                    else
                        bw.write("0\n");
                    break;
                case "front":
                    if(deque.isEmpty())
                        bw.write("-1\n");
                    else
                        bw.write(deque.peekFirst()+"\n");
                    break;
                case "back":
                    if(deque.isEmpty())
                        bw.write("-1\n");
                    else
                        bw.write(deque.peekLast()+"\n");
                    break;
            }
        }
        bw.flush();
        bw.close();

    }
}
