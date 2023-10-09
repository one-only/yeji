package baekjoon.fullSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 브루트포스(완전탐색) - 날짜계산 (시간초과)
public class P1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[3];
        int year = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        while (true) {
            if (year % 15 == arr[0] && year % 28 == arr[1] && year % 19 == arr[2]) {
                System.out.println(year);
                break;
            }
            year++;
        }
    }
}
