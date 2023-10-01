package baekjoon.binarySearch;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
// 정렬2 - 먹을 것인가 먹힐 것인가 - 시간초과
public class P7795 {
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
            Collections.sort(listA);
            int index=0;
            st = new StringTokenizer(br.readLine());
            // B보다 큰 요소를 A리스트에서 찾아 인덱스를 구함
            for (int j = 0; j < bNum; j++) {
                int bVal = stoi(st.nextToken());
                for (int k = 0; k < aNum; k++) {
                    if (bVal < listA.get(k)) {
                        index = k;
                        count += listA.size()-index;
                        break;
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
