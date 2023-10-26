package baekjoon.stack;

import java.io.*;

// 괄호 https://www.acmicpc.net/problem/9012
// 실패. 짝이 맞으면 YES를 반환하나 ')'가 먼저 나오는 경우를 헤아리지 않음
public class P9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            int check = 0;
            for (int j = 0; j < str.length(); j++) {
                if(str.charAt(j)=='(') check++;
                else check--;
            }
            if(check==0) bw.write("YES\n");
            else bw.write("NO\n");
        }
        bw.flush();
        bw.close();
    }
}
