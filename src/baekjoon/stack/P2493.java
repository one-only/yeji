package baekjoon.stack;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;
// 탑
public class P2493 {
    // 로직은 구현하였으나
    // 탑의 번호 출력 부분은 참고함
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 탑 번호를 함께 저장하기 위해 타입을 정수 배열로 설정
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < count; i++) {

            int top = Integer.parseInt(st.nextToken());

            while (true) {
                if (stack.empty()) { // 비어있다면 0출력
                    bw.write("0 ");
                    break;
                } else { // 비어있지 않다면 peek과 비교
                    int peek = stack.peek()[0];
                    if (peek < top) {
                        stack.pop();
                        continue;
                    } else {
                        bw.write(stack.peek()[1]+" ");
                        break;
                    }
                }
            }//while
            stack.push(new int[]{top,i+1});// 탑높이, 탑번호
        }
        bw.flush();
        bw.close();
    }
}
