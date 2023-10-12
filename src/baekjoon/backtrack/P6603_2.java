package baekjoon.backtrack;

import java.io.*;
import java.util.StringTokenizer;

// 로또 - 출력초과(문제를 잘못 이해해서 중복을 순서에 따른 모든 경우의 수 출력하도록 품)
public class P6603_2 {
    static int[] S;
    static int[] arr;
    static int kNum;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            kNum = Integer.parseInt(st.nextToken());
            if(kNum==0) break;

            arr = new int[kNum+1];
            S = new int[kNum + 1];
            visited = new boolean[kNum + 1];

            for (int i = 1; i < kNum+1; i++) {
                S[i] = stoi(st.nextToken());
            }
            bk(0);
            System.out.println(sb);
            sb.setLength(0); // StringBuilder 비우기
        }
    }

    static void bk(int depth) throws IOException{
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(arr[i]+" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= kNum; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            arr[depth] = S[i];
            bk(depth+1);
            visited[i] = false;
        }
    }

    static int stoi(String str) {
        return Integer.parseInt(str);
    }
}
