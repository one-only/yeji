package baekjoon;

import java.io.*;
import java.util.Set;
import java.util.TreeSet;
// 최소 힙 - (틀림)
public class P1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x > 0) { // x가 자연수
                set.add(x);
            } else { // x=0
                // 타입을 Set으로 선언하면 first(),pollFirst 등의 메서드가 정의되어있지 않다. TreeSet으로 선언해야한다.
                if(set.isEmpty())
                    bw.write("0\n");
                else
                    bw.write(set.pollFirst()+"\n");
            }
        }
        bw.flush();
        bw.close();

    }
}
