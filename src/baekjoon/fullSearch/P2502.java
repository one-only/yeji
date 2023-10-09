package baekjoon.fullSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 브루트포스(완전탐색) - 떡 먹는 호랑이
public class P2502 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dp = new int[D];

        for (int i = 1; i <= K/2; i++) {
            for (int j = i+1; j < K; j++) {
                dp[0] = i;
                dp[1] = j;
                for (int k = 2; k < D; k++) {
                    dp[k] = dp[k - 1] + dp[k - 2];
                }
                if (dp[D-1] == K) {
                    System.out.println(dp[0]);
                    System.out.println(dp[1]);
                    System.exit(0);
                }
            }
        }
    }
}
