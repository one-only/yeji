package baekjoon.hash;

import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

// 걸그룹 마스터 준석이 https://www.acmicpc.net/problem/16165
public class P16165 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken());
        int M = stoi(st.nextToken());

        String[] arr = new String[N];
        TreeMap<String, Integer> map = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
            int num = stoi(br.readLine());
            for (int j = 0; j < num; j++) {
                map.put(br.readLine(), i);
            }
        }
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (stoi(br.readLine()) == 1) { // 멤버 이름
                int index = map.get(str);
                bw.write(arr[index]+"\n");
            }
            else { // 걸그룹 이름
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j].equals(str)) {
                        for (String s : map.keySet()) {
                            if (map.get(s) == j)
                                bw.write(s+"\n");
                        }
                    }
                }
            }
        }
        bw.flush();
        bw.close();
    }
    static int stoi(String str) {
        return Integer.parseInt(str);
    }
}
