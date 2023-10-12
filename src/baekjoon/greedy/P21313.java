package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

// 문어
// System.out.printf() 로 출력 시 300ms
// StringBuilder 이용하여 출력 시 148ms
public class P21313 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // 문어의 개수
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];

        arr[1] = 1;
        for (int i = 2; i <= N; i++) {

            for (int j = 1; j < N ; j++) {
                if(i==N && j==1) j++; // 마지막 항목은 첫번째항목이 1을 사용하고 있어 1은 제외해야한다.
                if(arr[i-1]==j){
                    continue;
                }
                arr[i] = j;
                break;
            }
        }
        for (int i = 1; i <= N; i++) {
            sb.append(arr[i] + " ");
        }
        System.out.println(sb);

    }
}
