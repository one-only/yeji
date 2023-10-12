package baekjoon.backtrack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 로또
public class P6603 {
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

            arr = new int[7];
            S = new int[kNum + 1];
            visited = new boolean[kNum + 1];

            for (int i = 1; i < kNum+1; i++) {
                S[i] = stoi(st.nextToken());
            }
            bk(0,1);
            System.out.println(sb);
            sb.setLength(0); // StringBuilder 비우기
        }
    }

    static void bk(int depth, int start){
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(arr[i]+" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i <= kNum; i++) { // i=depth+1부터 시작하도록 설정
            arr[depth] = S[i];
            bk(depth+1,i+1);
        }
    }

    static int stoi(String str) {
        return Integer.parseInt(str);
    }
}
