package baekjoon.sort;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
// 정렬2 - 국영수 객체 사용하지 않고 배열, BufferedReader로 풀이(1200ms)
public class P10825_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = stoi(br.readLine());
        String[][] arr = new String[N][4];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = st.nextToken(); // 이름
            arr[i][1] = st.nextToken(); // 국어점수
            arr[i][2] = st.nextToken(); // 영어점수
            arr[i][3] = st.nextToken(); // 수학점수
        }

        Arrays.sort(arr, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if(stoi(o1[1])!=stoi(o2[1]))
                    return stoi(o2[1]) - stoi(o1[1]);
                else if(stoi(o1[2])!=stoi(o2[2]))
                    return stoi(o1[2]) - stoi(o2[2]);
                else if(stoi(o1[3])!=stoi(o2[3]))
                    return stoi(o2[3]) - stoi(o1[3]);
                else
                    return o1[0].compareTo(o2[0]);

            }
        });
        for (int i = 0; i < N; i++) {
            bw.write(arr[i][0]+"\n");
        }
        bw.flush();
        bw.close();

    }

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }
}
