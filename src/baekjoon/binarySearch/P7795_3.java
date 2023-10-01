package baekjoon.binarySearch;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
// 정렬2 - 먹을 것인가 먹힐 것인가
public class P7795_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = stoi(br.readLine());
        for (int i = 0; i < N; i++) {
            int count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int aNum = stoi(st.nextToken());
            int bNum = stoi(st.nextToken());

            int[] arrA = new int[aNum];
            int[] arrB = new int[bNum];

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < aNum; j++) {
                arrA[j] = stoi(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < bNum; j++) {
                arrB[j] = stoi(st.nextToken());
            }
            Arrays.sort(arrB);
            int result = 0;

            for (int j = 0; j < aNum; j++) {
                int left = 0;
                int right = bNum -1;
                int index = 0;

                while (left <= right) {
                    int mid = (left+right)/2;
                    if (arrB[mid] < arrA[j]) {
                        left = mid + 1;
                        index = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                result += index;
            }

            bw.write(result+"\n");
        }
        bw.flush();
        bw.close();
    }

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }
}
