package baekjoon.stack;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

// 단어순서 뒤집기
public class P12605 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Stack<String> stack = new Stack<>();

            while (st.hasMoreTokens()) {
                stack.add(st.nextToken());
            }
            bw.write("Case #"+i+": ");
            while (!stack.isEmpty()) {
                bw.write(stack.pop()+" ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();

    }
}
