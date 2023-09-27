package baekjoon.sort;

import java.io.*;
import java.util.*;

// 정렬2 - 나이순 정렬
public class P10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = stoi(br.readLine());

        String[][] arr = new String[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = st.nextToken();
            arr[i][1] = st.nextToken();
        }
        // 나이 순 -> 가입 순으로 정렬(가입 순은 이미 저장된 순서이므로 고려X)
        Arrays.sort(arr, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return stoi(o1[0])-stoi(o2[0]);
            }
        });
        for (int i = 0; i < N; i++) {
            bw.write(arr[i][0]+" "+arr[i][1]+"\n");
        }
        bw.flush();
        bw.close();
    }

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }
}
