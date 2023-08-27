package baekjoon.stack;

import java.io.*;
import java.util.Stack;
// 수열
public class P1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int count = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int val = 1;

        for (int i = 0; i < count; i++) {
            int target = Integer.parseInt(br.readLine());
            while (val <= target) {
                stack.push(val);
                sb.append('+').append('\n');
                val++;
            }
            if (stack.peek() == target) {
                stack.pop();
                sb.append('-').append('\n');
            } else {
                System.out.println("NO");
                System.exit(0); // 강제 종료
            }
        }
        System.out.println(sb);
    }
}
