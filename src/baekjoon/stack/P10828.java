package baekjoon.stack;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;
// 스택 제출완료
public class P10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            switch (str) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if(stack.empty())
                        bw.write(-1+"\n");
                    else
                        bw.write(stack.pop()+"\n");
                    break;
                case "size" :
                        bw.write(stack.size()+"\n");
                    break;
                case "empty":
                    if(stack.empty())
                        bw.write(1+"\n");
                    else
                        bw.write(0+"\n");
                    break;
                case "top" :
                    if(stack.empty())
                        bw.write(-1+"\n");
                    else
                        bw.write(stack.peek()+"\n");
                    break;

            }
        }
        bw.flush();
        bw.close();
    }
}
