package baekjoon.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
// 오큰수 - 스택 (참조)
public class P17298{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> ans = new Stack<>();
        Stack<Integer> tmp = new Stack<>();
        int count = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        for (int i = count-1; i <= 0; i++) {
            int num = Integer.parseInt(input[i]);
            // 1.임시스택이 비어있지 않고 현재 값이 임시 스택의 top보다 크거나 같다면
            // 계속 뺴낸다.(작은 값을 계속 빼낸다)
            while (!tmp.empty() && num >= tmp.peek()) {
                tmp.pop();
            }
            // 2.임시스택이 비어있다면 -1
            if (tmp.isEmpty()) {
                ans.add(-1);
            // 비어있지 않다면 peek()값을 정답스택에 추가한다.
            } else {
                ans.add(tmp.peek());
            }
            // 3.현재 값을 임시스택에 추가한다.
            tmp.add(num);
        }

        // 결과 출력
        while (!ans.isEmpty()) {
            sb.append(ans.pop()+" ");
        }
        System.out.println(sb);
    }
}
