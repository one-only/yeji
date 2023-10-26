package baekjoon.stack;

import java.io.*;
import java.util.Stack;
// 괄호 https://www.acmicpc.net/problem/9012
public class P9012_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '(') {
                    stack.add(str.charAt(j));
                } else {
                    if(stack.isEmpty()){
                        stack.add('n'); // 괄호가 있어야하는데 스택이 빈 경우, NO출력하기 위해 스택에 값 추가
                        break;
                    }

                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
