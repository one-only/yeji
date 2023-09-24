package baekjoon.binarySearch;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
// 정렬2 - 먹을 것인가 먹힐 것인가 - 시간초과 (정렬안하고 A요소보다 큰것 찾도록만 변경)
public class P7795_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = stoi(br.readLine());
        for (int i = 0; i < N; i++) {
            int count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int aNum = stoi(st.nextToken());
            int bNum = stoi(st.nextToken());

            st = new StringTokenizer(br.readLine());
            List<Integer> listA = new ArrayList<>();
            // 리스트에 A 요소 저장
            for (int j = 0; j < aNum; j++) {
                listA.add(stoi(st.nextToken()));
            }
            int index=0;
            st = new StringTokenizer(br.readLine());
            // B보다 큰 요소
            for (int j = 0; j < bNum; j++) {
                int bVal = stoi(st.nextToken());
                for (int k = 0; k < aNum; k++) {
                    if (bVal < listA.get(k)) {
                        count++;
                    }
                }
            }
            bw.write(count+"\n");
        }
        bw.flush();
        bw.close();
    }

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }
}
