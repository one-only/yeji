package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N + 1];
        int[] P = new int[N + 1];
        int[] DP = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            T[i] = Integer.parseInt(st.nextToken()); //상담 하는데 걸리는 일 수
            P[i] = Integer.parseInt(st.nextToken()); // 받는 금액
        }

        for (int i = N; i > 0; i--) { //N부터 1까지
            int next = i + T[i]; // 상담을 마친 날짜

            if (next > N + 1) { // 일할 수 있는 날짜를 넘어가는 경우
                DP[i] = DP[i + 1]; // 누적 수익이 동일하므로 그 다음날 수익을 그대로 이어받는다.
            } else { // 일할 수 있는 날짜인 경우
                // 1. 일하지 않았을 때: DP[i+1]
                // 2. 일했을 때 총 벌 수 있는 금액: P[i] + DP[next]
                DP[i] = Math.max(DP[i+1],P[i]+DP[next]);
            }
        }
        System.out.println(DP[1]);
    }
}
