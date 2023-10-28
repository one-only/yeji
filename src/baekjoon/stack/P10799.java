package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//쇠막대기 https://www.acmicpc.net/problem/10799
public class P10799 {
    public static void main(String[] args) throws IOException {
        int sum = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char val = str.charAt(i);
            if (val == '(') {
                stack.add('(');
                continue;
            }
            if (val == ')') {
                stack.pop();
                if (str.charAt(i - 1) == '(') { // 직전이 열린괄호면 레이저
                    sum += stack.size();
                } else { // 직전이 닫힌 괄호면 레이저아님, 막대끝
                    sum++;
                }

            }

        }

    }
}
