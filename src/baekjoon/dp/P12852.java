package baekjoon.dp;

import java.io.*;

//1로 만들기 2
public class P12852 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 2];
        int[] trace = new int[N + 2];

        dp[1] = 0;
        trace[1] = -1;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i-1]+1;
            trace[i] = i-1;

            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i/2]+1;
                trace[i] = i/2;
            }
            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i/3]+1;
                trace[i] = i/3;
            }
        }
        int num = dp[N];
        bw.write(num+"\n");
        int index = N;
        for (int i = 0; i <= num; i++) {
            bw.write(index + " ");
            index = trace[index];
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
