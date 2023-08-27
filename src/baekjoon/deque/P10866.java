package baekjoon.deque;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 덱
public class P10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            switch (order) {
                case "push_front":
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if(deque.isEmpty())
                        bw.write("-1\n");
                    else
                        bw.write(deque.removeFirst()+"\n");
                    break;
                case "pop_back":
                    if(deque.isEmpty())
                        bw.write("-1\n");
                    else
                        bw.write(deque.removeLast()+"\n");
                    break;
                case "size":
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
                        bw.write(deque.getFirst()+"\n");
                    break;
                case "back":
                    if(deque.isEmpty())
                        bw.write("-1\n");
                    else
                        bw.write(deque.getLast()+"\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}
