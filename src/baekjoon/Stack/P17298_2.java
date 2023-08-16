package baekjoon.Stack;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

// 오큰수 - 배열(시간초과)
public class P17298_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        int[] arr = new int[count];
        int[] max = new int[count];
        // 배열에 값 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 값 비교하여 큰 수 찾기
        for (int i = 0; i < count-1; i++) {
            max[i] = -1;
            for (int j = i+1; j < count; j++) {
                if (arr[i] < arr[j]) {
                    max[i] = arr[j];
                    break;
                }
            }
        }//for
        max[count-1] = -1;
        for (int i = 0; i < count; i++) {
            bw.write(max[i]+" ");
        }
        bw.flush();
        bw.close();
    }
}
