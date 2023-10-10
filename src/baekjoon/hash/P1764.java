package baekjoon.hash;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;
// 이진검색 - 듣보잡
public class P1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 최종적으론 nSet을 포함하는 mSet을 출력할 것이므로
        // nSet은 정렬시킬 필요가 없어, HashSet으로 선언
        Set<String> nSet = new HashSet<>();
        Set<String> mSet = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            nSet.add(br.readLine());
        }
        for (int i = 0; i < M; i++) {
            String mName = br.readLine();
            if (nSet.contains(mName)) {
                mSet.add(mName);
            }
        }
        bw.write(mSet.size()+"\n");
        for (String s : mSet) {
            bw.write(s+"\n");
        }
        bw.flush();
        bw.close();
    }
}
