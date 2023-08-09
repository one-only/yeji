package baekjoon.Stack;

import java.io.*;
import java.util.Stack;

public class P10773 {
    // 제로(담당) - 제출 완료
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int sum = 0;

        for (int i = 0; i < count; i++) {
            int num = Integer.parseInt(br.readLine());
            switch (num) {
                case 0:
                    sum -= stack.pop();
                    break;
                default:
                    stack.push(num);
                    sum += num;
                    break;
            }
        }
        System.out.println(sum); //단일 출력은 bw와 시간이 동일했다.

    }
}
