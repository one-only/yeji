package baekjoon.tree;

import java.io.*;
import java.util.*;
// 회사에 있는 사람 - ArrayList풀이 (시간초과)
public class P7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] arr = br.readLine().split(" ");

            switch (arr[1]) {
                case "enter":
                    list.add(arr[0]);
                    break;
                case "leave":
                    list.remove(arr[0]);
                    break;
            }
        }
        // 사전 순의 역순으로 정렬하기
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        for (String s : list) {
            bw.write(s+"\n");
        }
        bw.flush();
        bw.close();
    }
}
