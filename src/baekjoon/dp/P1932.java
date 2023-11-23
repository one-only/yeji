package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//정수 삼각형
public class P1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int d[][] = new int[N + 1][N + 1];
        int a[][] = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                a[i][j] = stoi(st.nextToken());
            }
        }
        for (int i = 1; i <= N; i++) {
            for(int j=1;j<=N;j++){
                d[i][j] = Math.max(d[i-1][j-1],d[i-1][j])+a[i][j];
            }
        }
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            if(ans<d[N][i]) ans = d[N][i];
        }
        System.out.println(ans);

    }

    static int stoi(String str) {
        return Integer.parseInt(str);
    }
}
