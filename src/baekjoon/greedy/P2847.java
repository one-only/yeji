package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 게임을 만든 동준이
public class P2847 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int count = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = N-2; i >= 0; i--) {
            int score = arr[i];
            if (arr[i] >= arr[i + 1]) {
                score = arr[i + 1] - 1;
            }
            count += arr[i]-score;
            arr[i] = score;
        }
        System.out.println(count);

    }
}
