package baekjoon.sort;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
// 좌표 정렬하기
public class P11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        int[][] arr = new int[num][2];

        for (int i = 0; i < num; i++) { // 좌표 배열에 저장
            StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr,(arr_1,arr_2)->{
            if(arr_1[0] == arr_2[0])
                return arr_1[1] - arr_2[1]; // x좌표가 같다면 y좌표
            else
                return arr_1[0] - arr_2[0]; // x좌표가 같지 않다면 x좌표로 비교
        });
        for (int i = 0; i < num; i++) {
            bw.write(arr[i][0]+" "+arr[i][1]+"\n");
        }
        bw.flush();
        bw.close();

    }
}
