package baekjoon.tree;

import java.io.*;
import java.util.*;

// 회사에 있는 사람 - TreeSet풀이 (통과)
public class P7785_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        // Comparator를 이용해 사전 역순으로 저장되도록 선언
        Set<String> set = new TreeSet<>(Comparator.reverseOrder());

        for (int i = 0; i < n; i++) {
            String[] log = br.readLine().split(" ");

            switch (log[1]) {
                case "enter":
                    set.add(log[0]);
                    break;
                case "leave":
                    set.remove(log[0]);
                    break;
            }
        }
        for (String s : set) {
            bw.write(s+"\n");
        }
        bw.flush();
        bw.close();
    }
}
