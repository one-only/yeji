package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 카드 합체 놀이
public class P15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int index1, index2; // 작은 값 2개의 인덱스
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] arr = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) { // m번 합체
            long sum = 0;
            index1 = 0;
            index2 = 1;
            for (int j = 1; j < n; j++) { // 가장 작은 값 2개 찾기
                if (arr[j] <= arr[index1]) {
                    index2 = index1; // 기존 가장 작은 값을 부여
                    index1 = j; // 새로운 가장 작은 값의 인덱스 부여
                }
                else if (arr[j] < arr[index2])
                    index2 = j;
            }
            sum = arr[index1] + arr[index2];
            arr[index1] = sum;
            arr[index2] = sum;
        }
        long min = 0;
        for (long i : arr) {
            min += i;
        }
        System.out.println(min);

    }
}
