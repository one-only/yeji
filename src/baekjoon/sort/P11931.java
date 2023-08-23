package baekjoon.sort;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
// 수 정렬하기4
public class P11931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        // Collections는 제네릭 타입만 사용가능하므로 int는 사용할 수 없다.
        Integer arr[] = new Integer[num];

        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
//        Arrays.sort(arr); 오름차순 정렬
        Arrays.sort(arr, Collections.reverseOrder());
        for (Integer integer : arr) {
            bw.write(integer+"\n");
        }
        bw.flush();
        bw.close();
    }
}
