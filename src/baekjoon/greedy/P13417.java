package baekjoon.greedy;

import java.io.*;
import java.util.*;

// 카드 문자열
public class P13417 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        while (N--> 0) { // for(int i=0;i<N;i++)
            int num = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            for (int j = 0; j < num-1; j++) {
                String next = st.nextToken();
                if (str.compareTo(next) <= 0) { // str이 더 앞인 경우
                    str = str.concat(next);
                } else{ // next가 더 앞인 경우
                    str = next.concat(str);
                }
            }
            sb.append(str+"\n");
        }
        System.out.print(sb);
    }
}
