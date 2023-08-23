package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 스택 옥상 정원(담당)
public class P6198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        long sum = 0;
        for (int i = 0; i < count; i++) {
            int tmp = Integer.parseInt(br.readLine());
            // 이전에 위치한 빌딩 중 새로운 빌딩보다 낮은 빌딩 모두 제거
            while (!stack.isEmpty() && stack.peek() <= tmp) {
                stack.pop();
            }
            // 새로운 빌딩을 추가
            stack.push(tmp);
            // 스택에 남아있는 빌딩은 새로운 빌딩보다 높으므로
            sum += stack.size() - 1;
        }
        System.out.println(sum);


    }
}
